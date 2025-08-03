package kz.kop_flowers.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tags")
@Entity
@Data
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "flower_id")
    @ManyToOne
    private Flower flower;

    @Column(name = "tag_name")
    private String tagName;
}
