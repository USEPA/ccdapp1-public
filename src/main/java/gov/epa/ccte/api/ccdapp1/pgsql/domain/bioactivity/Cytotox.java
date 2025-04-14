package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bioactivity_cytotox", schema = "ccd_app")
public class Cytotox implements Serializable {

    @Id
    @Column(name = "dtxsid", nullable = false)
    String id;

    @Column(name = "dtxsid", nullable = false, insertable = false, updatable = false)
    String dtxsid;

    @Column(name = "cytotox_med_raw_val", nullable = false)
    String cytotoxMedRawVal;

    @Column(name = "cytotox_mad_val", nullable = false)
    String cytotoxMadVal;

    @Column(name = "global_mad_val", nullable = false)
    String globalMadVal;

    @Column(name = "cytotox_medn_log", nullable = false)
    String cytotoxMednLog;

    @Column(name = "cytotox_medn_um", nullable = false)
    String cytotoxMednUm;

    @Column(name = "nhit_val", nullable = false)
    String nhitVal;

    @Column(name = "cytotox_low_bnd_um", nullable = false)
    String cytotoxLowBndUm;

    @Column(name = "ntested_val", nullable = false)
    String ntestedVal;

    @Column(name = "cytotox_low_bnd_log", nullable = false)
    String cytotoxLowBndLog;
}
