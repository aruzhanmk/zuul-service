package kz.iitu.end.repository;

import kz.iitu.end.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitleContaining(String title);

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long bookId);
}
