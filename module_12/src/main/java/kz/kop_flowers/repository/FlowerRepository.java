package kz.kop_flowers.repository;

import kz.kop_flowers.model.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowerRepository extends JpaRepository<Flower, Integer> {

    List<Flower> findByCategoryId(Integer categoryId);

}

