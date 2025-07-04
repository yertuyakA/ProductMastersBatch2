package kz.kop_flowers.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Table(name = "flowers")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal price;

    private String size; // BIG, MEDIUM, SMALL

    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "flower")
    private List<Tag> tags;
}
