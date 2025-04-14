package gov.epa.ccte.api.ccdapp1.pgsql.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "News")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @JsonProperty("title")
    public String title;

    @Column(name = "body")
    @JsonProperty("body")
    public String body;

    @Column(name = "admin")
    @JsonProperty("admin")
    public String admin;

    @Column(name = "created_at")
    @JsonProperty("createdAt")
    public LocalDateTime createdAt;

    @Column(name = "updated_at")
    @JsonProperty("updatedAt")
    public LocalDateTime updatedAt;
}
