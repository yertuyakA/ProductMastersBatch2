package kz.kop_flowers.controller;

import kz.kop_flowers.model.dto.FlowerDto;
import kz.kop_flowers.service.FlowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
@RequiredArgsConstructor
public class FlowerController {

    private final FlowerService flowerService;

    @GetMapping()
    public List<FlowerDto> getFlowers() {
        return flowerService.getAllFlowers();
    }

    @GetMapping("/{id}")
    public FlowerDto getFlowerById(@PathVariable Integer id) {
        return flowerService.getFlowerById(id);
    }

    @PostMapping()
    public FlowerDto createFlower(@RequestBody FlowerDto flower) {
        return flowerService.createFlower(flower);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<FlowerDto> deleteFlower(@PathVariable Integer id) {
        FlowerDto deleted = flowerService.deleteFlower(id);
        return ResponseEntity.ok(deleted);
    }

    @GetMapping("/by-category/{categoryId}")
    public List<FlowerDto> getFlowersByCategory(@PathVariable Integer categoryId) {
        return flowerService.getFlowersByCategory(categoryId);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FlowerDto> updateFlowerById(@PathVariable Integer id, @RequestBody FlowerDto flowerDto) {
        FlowerDto updated = flowerService.updateFlower(id, flowerDto);
        return ResponseEntity.ok(updated);
    }
}
