package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "release_info")
public class ReleaseInfo {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "release_version")
    @JsonProperty("releaseVersion")
    private String releaseVersion;

}
