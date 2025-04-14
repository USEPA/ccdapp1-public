package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;

import jakarta.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // Auditing fields
    @Version
    @Setter(AccessLevel.PROTECTED)
    private Integer version;

    @Column(name="created_at", columnDefinition = "TIMESTAMP")
    @JsonProperty("createdDate")
    private LocalDateTime createdDate;

    @Column( name="updated_at", columnDefinition = "TIMESTAMP")
    @JsonProperty("lastModifiedDate")
    private LocalDateTime lastModifiedDate;

    @Column(name = "createdBy")
    @JsonProperty("createdBy")
    private String createdBy;

/*
    @CreatedBy
    @Field("created_by")
    private String createdBy;

    @LastModifiedBy
    @Field("last_modified_by")
    private String lastModifiedBy;
*/

}
