package swd20.C4.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import swd20.C4.bookstore.web.BookController;

@RunWith(SpringRunner.class) // ajetaan spring-boot kirjaston avulla
@SpringBootTest
public class BookstoreApplicationTests {

	// SMOKE -TEST
	
    @Autowired
    private BookController controller;
	
	@Test
	public void contextLoads() throws Exception {
		
	    assertThat(controller).isNotNull(); // asserThat(tutkittava olio).isNotNull(); onko/ei ole null, on luotu);
	}

}
