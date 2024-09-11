package practice.expmission0910.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import practice.expmission0910.dto.BookDto;
import practice.expmission0910.entity.Book;
import practice.expmission0910.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // 특정 ID의 책 정보를 조회하는 엔드포인트
    @GetMapping("/search/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());
        book.setPublished_date(bookDto.getPublished_date());

        return bookService.createBook(book);
    }


    // 도서 수정
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return bookService.updateBook(id,bookDto);
    }

    // 도서 삭제
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
