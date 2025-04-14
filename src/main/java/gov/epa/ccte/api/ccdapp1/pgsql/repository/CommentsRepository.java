package gov.epa.ccte.api.ccdapp1.pgsql.repository;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@SuppressWarnings("unused")
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "comments", path = "comments")
public interface CommentsRepository  extends JpaRepository<Comments, Integer> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = false)
    List<Comments> findByDtxsidAndVisibleIsTrueOrderByCreatedAtDesc(@Param("id") String dtxsid);

    @RestResource(path = "all-comments", rel = "all-comments", exported = false)
    List<Comments> findCommentsByVisibleIsTrue();


    List<Comments> findByJiraIdIsNull();

    Comments findByJiraId(String jiraId);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Comments> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Comments comments);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Comments> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}

