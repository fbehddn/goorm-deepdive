package practice.springboot_project.controller;

import org.springframework.web.bind.annotation.*;
import practice.springboot_project.model.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final List<Cat> catList = new ArrayList<>();

    public CatController() {
        catList.add(new Cat(1L, "Milo", "black", 3));
        catList.add(new Cat(2L, "Luna", "white", 4));
        catList.add(new Cat(3L, "Leo", "yellow", 1));
    }

    // http://localhost:8080/cats
    @GetMapping
    public List<Cat> getAllCats() {
        return catList;
    }

    // http://localhost:8080/cats/1
    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
        Optional<Cat> cat = catList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return cat.orElse(null);
    }

    // http://localhost:8080/cats/add
    @PostMapping("/add")
    public Cat addCat(@RequestBody Cat cat) {
        cat.setId(catList.size() + 1L);
        catList.add(cat);
        return cat;
    }

    // http://localhost:8080/cats/1
    @DeleteMapping("/{id}")
    public String deleteCat(@PathVariable Long id) {
        boolean removed = catList.removeIf(c -> c.getId().equals(id));
        return removed ? "삭제 완료" : "없는 고양이";
    }

}
