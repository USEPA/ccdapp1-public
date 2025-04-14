package gov.epa.ccte.api.ccdapp1.web.rest;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.Comments;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.CommentsSummary;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.CommentsSummaryLong;
import gov.epa.ccte.api.ccdapp1.pgsql.repository.CommentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@Slf4j
@CrossOrigin
public class CommentsController {


    private final CommentsRepository commentsRepository;

    private static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

    public CommentsController(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @GetMapping("/comments/search/by-dtxsid")
    public List<CommentsSummary> getCommentsByDtxsid(@RequestParam("id") String dtxsid) {
        List<Comments> commentsList = commentsRepository.findByDtxsidAndVisibleIsTrueOrderByCreatedAtDesc(dtxsid);

        LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);

        // Filtering comments to only include those from last 1 year
        List<CommentsSummary> filteredComments = commentsList.stream()
                .filter(comment -> comment.getCreatedAt() != null && comment.getCreatedAt().isAfter(oneYearAgo))
                .map(this::mapToSummary)
                .collect(Collectors.toList());

        return filteredComments;
    }

    @GetMapping("/comments/search/all-comments")
    public List<CommentsSummaryLong> getAllComments() {
        List<Comments> commentsList = commentsRepository.findCommentsByVisibleIsTrue();

        LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);

        // Filtering comments to only include those which are created or updated in last 1 year
        List<CommentsSummaryLong> filteredComments = commentsList.stream()
                .filter(comment -> comment.getCreatedAt() != null && comment.getUpdatedAt().isAfter(oneYearAgo))
                .map(this::mapToSummaryAllComments)
                .collect(Collectors.toList());

        // Update status if not "Resolved"
        filteredComments.forEach(commentSummary -> {
            if (!"Resolved".equals(commentSummary.getStatus())) {
                commentSummary.setStatus("");  // Setting status to blank if not "Resolved"
            }
        });

        return filteredComments;
    }

    private CommentsSummaryLong mapToSummaryAllComments(Comments comment) {
        CommentsSummaryLong summary = new CommentsSummaryLong();
        summary.setComment(comment.getComment());
        summary.setFeedback(comment.getFeedback());
        summary.setCreatedAt(comment.getCreatedAt());
        summary.setDtxsid(comment.getDtxsid());
        summary.setChemName(comment.getChemName());
        summary.setStatus(comment.getStatus());
        return summary;
    }

    private CommentsSummary mapToSummary(Comments comment) {
        CommentsSummary summary = new CommentsSummary();
        summary.setComment(comment.getComment());
        summary.setFeedback(comment.getFeedback());
        summary.setCreatedAt(comment.getCreatedAt());
        return summary;
    }

    @PostMapping("/comments")
    public ResponseEntity<?> addComment(@RequestBody Comments comment) {

        if (containsEmail(comment.getComment())) {
            return ResponseEntity.badRequest().body("Posting comments with email addresses in the body is not allowed.");
        }
        Comments savedComment = commentsRepository.save(comment);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedComment.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedComment);
    }

    private boolean containsEmail(String content) {
        Matcher matcher = EMAIL_PATTERN.matcher(content);
        return matcher.find();
    }
}

