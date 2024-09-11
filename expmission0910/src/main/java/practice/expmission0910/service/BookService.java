package practice.expmission0910.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import practice.expmission0910.dto.BookDto;
import practice.expmission0910.entity.Book;
import practice.expmission0910.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    //모든 책 정보 가져오기
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // 도서 저장
    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // 도서 수정
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation =Isolation.REPEATABLE_READ)
    public Book updateBook(Long id, BookDto bookDto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(bookDto.getTitle());
        book.setPublisher(bookDto.getPublisher());

        return bookRepository.save(book);
    }

    // 도서 삭제
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
