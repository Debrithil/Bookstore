package swd20.C4.bookstore;

import static org.assertj.core.api.Assertions.assertThat; // importoidaan metodi

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.C4.bookstore.domain.Book;
import swd20.C4.bookstore.domain.BookRepository;
import swd20.C4.bookstore.domain.CategoryRepository;
import swd20.C4.bookstore.domain.User;
import swd20.C4.bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest // JPA Repository

public class BookstoreRepositoryTest {
    
    // JPA-TESTING
    
    @Autowired
    private BookRepository bookRepository; // List<Book> findByTitle(String title);
    
    @Test
    public void findByBookTitleShouldReturnBook() {
        List<Book> books = bookRepository.findByTitle("Java-ohjelmointi"); // hakee tietokannasta Java-ohjelmointi nimellä olevan kirjan
        
        assertThat(books).hasSize(1); // tietokannassa on vain yksi "Java-ohjelmointi" -kirja
        assertThat(books.get(0).getAuthor()).isEqualTo("Mika Vesterholm"); // luo kirjalistan aina 0:sta
    }
    
    @Autowired
    private CategoryRepository categoryRepository; // List<Book> findByTitle(String title);
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Matka ohjelmoinnin maailmaan", "Elina Hiltunen", 2015, "ISBN-9789523210561", 18.80, categoryRepository.findByName("IT").get(0)); // department tarvii id:n
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void createNewUser() {
    	User user4 = new User("testaaja2", "$2a$04$.QbzbE7N3QYoKJRkIwqy0eOnhnYNODks91wozM6oyJTJzpo.GFfyu", "testaaja2@bookstore.fi", "TESTAAJA2");
    	userRepository.save(user4);
    	assertThat(user4.getId()).isNotNull();
    	
    	
    }

}