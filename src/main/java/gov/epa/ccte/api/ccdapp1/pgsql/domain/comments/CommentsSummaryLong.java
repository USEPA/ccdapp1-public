package gov.epa.ccte.api.ccdapp1.pgsql.domain.comments;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Setter
@Getter
public class CommentsSummaryLong {

    @JsonProperty("chemName")
    private String chemName;

    @JsonProperty("dtxsid")
    private String dtxsid;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("status")
    private String status;


    @JsonProperty("createdAt")
    private LocalDateTime createdAt;





}
