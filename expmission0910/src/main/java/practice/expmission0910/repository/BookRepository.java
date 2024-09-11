package practice.expmission0910.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.expmission0910.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
