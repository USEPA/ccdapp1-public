package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.AbstractAuditingEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Table(name = "feedbacks")
public class Feedback extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private Integer id;


    @NotBlank(message = "Please make sure a valid email is present")
    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Please make sure a valid subject is present")
    @Column(name = "subject")
    @JsonProperty("subject")
    private String subject;

    @NotBlank(message = "Please make sure a valid message is present")
    @Column(name = "message")
    @JsonProperty("message")
    private String message;

}
