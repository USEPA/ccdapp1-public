package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "help_texts")
public class HelpText {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "help_position")
    @JsonProperty("helpPosition")
    private String helpPosition;

    @Column(name = "help_text")
    @JsonProperty("helpText")
    private String helpText;

    @Column(name = "icon_type")
    @JsonProperty("iconType")
    private String iconType;

    @Column(name = "helptext_id")
    @JsonProperty("helpTextId")
    private String helpTextId;

}
