package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Immutable
@Table(name = "vw_bioactivity_assays", schema = "ccd_app")
public class BioactivityAssay {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "dtxsid")
    @JsonProperty("dtxsid")
    private String dtxsid;

    @Column(name = "name")
    @JsonProperty("listName")
    private String listName;

    @Column(name = "description")
    @JsonProperty("listDescription")
    private String listDescription;

}
