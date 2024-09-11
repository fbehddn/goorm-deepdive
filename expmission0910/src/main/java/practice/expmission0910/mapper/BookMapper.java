package practice.expmission0910.mapper;

import org.apache.ibatis.annotations.Mapper;
import practice.expmission0910.dto.BookDto;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDto> findAll();
    BookDto findById(Long id);
    void save(BookDto bookDto);
    void update(BookDto bookDto);
    void deleteById(Long id);

}
