package practice.expmission0910.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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

    // 도서 등록
    @PostMapping
    public void createBook(@RequestBody BookDto bookDto) {
        bookService.save(bookDto);
    }

    // 도서 수정
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        bookDto.setId(id);
        bookService.update(bookDto);
    }

    // 도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
