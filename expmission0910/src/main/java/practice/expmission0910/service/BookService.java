package practice.expmission0910.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.expmission0910.dto.BookDto;
import practice.expmission0910.mapper.BookMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    //모든 책 정보 가져오기
    public List<BookDto> findAll() {
        return bookMapper.findAll();
    }

    public BookDto findById(Long id) {
        return bookMapper.findById(id);
    }

    // 도서 저장
    public void save(BookDto bookDto) {
        bookMapper.save(bookDto);
    }

    // 도서 수정
    public void update(BookDto bookDto) {
        bookMapper.update(bookDto);
    }

    // 도서 삭제
    public void deleteById(Long id) {
        bookMapper.deleteById(id);
    }
}
