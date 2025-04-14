package gov.epa.ccte.api.ccdapp1.pgsql.domain.bioactivity;

import lombok.Data;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "bioactivity_model", schema = "ccd_app")
public class BioactivityModel {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;


    @Column(name = "dtxsid", nullable = true, length = 50)
    private String dtxsid;

    @Column(name = "model", nullable = true, length = 255)
    private String model;

    @Column(name = "receptor", nullable = true, length = 255)
    private String receptor;

    @Column(name = "agonist", nullable = true, length = 255)
    private String agonist;

    @Column(name = "antagonist", nullable = true, length = 255)
    private String antagonist;

    @Column(name = "binding", nullable = true, length = 255)
    private String binding;

    @Column(name = "help", nullable = true, length = 1024)
    private String help;
}
