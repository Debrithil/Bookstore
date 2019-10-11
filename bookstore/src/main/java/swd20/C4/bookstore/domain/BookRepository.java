package swd20.C4.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository<Book, Long> {
	
	 List<Book> findByTitle(String title);

}
