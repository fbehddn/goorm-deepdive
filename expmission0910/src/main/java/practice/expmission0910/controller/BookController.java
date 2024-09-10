package practice.expmission0910.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.expmission0910.dto.BookDto;
import practice.expmission0910.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDto> findAll() {
        return bookService.findAll();
    }

    // 특정 ID의 책 정보를 조회하는 엔드포인트
    @GetMapping("/search/{id}")
    public BookDto findById(@PathVariable Long id) {
        return bookService.findById(id);
    }
}
