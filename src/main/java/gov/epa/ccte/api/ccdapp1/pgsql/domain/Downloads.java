package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "download_links")
public class Downloads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @JsonProperty("name")
    public String name;

    @Column(name = "label")
    @JsonProperty("label")
    public String label;

    @Column(name = "title")
    @JsonProperty("title")
    public String title;

    @Column(name = "url")
    @JsonProperty("url")
    public String url;

    @Column(name = "long_description")
    @JsonProperty("longDescription")
    public String longDescription;

    @Column(name = "short_description")
    @JsonProperty("shortDescription")
    public String ShortDescription;


    @Column(name = "admin")
    @JsonProperty("admin")
    public String admin;

    @Column(name = "created_at")
    @JsonProperty("createdDate")
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonProperty("lastModifiedDate")
    public LocalDateTime updatedAt;
}
