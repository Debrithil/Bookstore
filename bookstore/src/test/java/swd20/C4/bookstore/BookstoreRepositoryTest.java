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
    	Book book = new Book("Java-ohjelmointi", "Mika Vesterholm", 2018, "ISBN-9789521435560", 21.50, categoryRepository.findByName("IT").get(0)); // department tarvii id:n
    	bookRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Autowired
    private UserRepository userRepository; // List<User> findByUsername(String title);
    
    @Test
    public void findByUserNameShouldReturnUser() {
    	List<User> users = userRepository.findByUsername("admin");
    	
    	assertThat(users).hasSize(1); // tietokannassa on vain yksi "ADMIN" -käyttäjätunnus
        assertThat(users.get(0).getEmail()).isEqualTo("admin@bookstore.fi"); // luo kirjalistan aina 0:sta
    	
    }

}