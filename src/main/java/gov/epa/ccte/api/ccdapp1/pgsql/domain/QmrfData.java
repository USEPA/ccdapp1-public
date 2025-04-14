package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name = "model_reports")
public class QmrfData {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fk_model_id")
    @JsonProperty("modelId")
    private int modelId;

    @Column(name = "report_pdf")
    @JsonProperty("reportPdf")
    private byte[] reportPdf;
}
