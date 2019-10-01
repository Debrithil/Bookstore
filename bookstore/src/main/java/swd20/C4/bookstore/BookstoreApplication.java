package swd20.C4.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import swd20.C4.bookstore.domain.Book;
import swd20.C4.bookstore.domain.BookRepository;
import swd20.C4.bookstore.domain.Category;
import swd20.C4.bookstore.domain.CategoryRepository;
import swd20.C4.bookstore.domain.User;
import swd20.C4.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
		
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti

		public static void main(String[] args) {
			SpringApplication.run(BookstoreApplication.class, args);
		}
		
		//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
		@Bean // luo tietokantaan jo kaksi kirjaa ohjelman käynnistyessä
		
		public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository) { 
			return (args) -> {
				log.info("tallenna pari kirjaa tietokantaan");
				
				categoryRepository.save(new Category("IT"));
				categoryRepository.save(new Category("Science"));
				categoryRepository.save(new Category("Sport"));
				
				bookRepository.save(new Book("Hands-On Full Stack Development", "Juha Hinkula", 2018, "ISBN-9781789138085", 48.40, categoryRepository.findByName("IT").get(0)));
				bookRepository.save(new Book("Java-ohjelmointi", "Mika Vesterholm", 2018, "ISBN-9789521435560", 65.50, categoryRepository.findByName("IT").get(0)));
				bookRepository.save(new Book("Mielen voima urheilussa", "Ilkka Virolainen", 2017, "ISBN-9789522606273", 21.50, categoryRepository.findByName("Sport").get(0)));
				bookRepository.save(new Book("Tiede tutkimuskohteena", "Mika Kiikeri", 2017, "ISBN-9789516629264", 22.60, categoryRepository.findByName("Science").get(0)));
				
		// Luo käyttäjätunnukset: user / tanjaoletparas1 / admin / tanjaoletparas2 / testaaja / tamaontesti
				
				User user1 = new User("user", "$2a$04$aH/licpe7Z51UaSjwaiV8ugItIhVc2mjzhMZNu4GOARg5OQN5VQBy", "user@bookstore.fi", "USER");
				User user2 = new User("admin", "$2a$04$P/nZmOaX9nFIAxoj9ggfcu8VIlnz28Fjx24iINrPPiZAqOWWkZSxe", "admin@bookstore.fi","ADMIN");
				User user3 = new User("testaaja", "$2a$04$Fk642dHcIv3c/Deb/e7MROKtIrhqsPOJ8hq9r6a9PmQR2SSIj8/0C", "testi@bookstore.fi","TESTAAJA");
				
				userRepository.save(user1);
				userRepository.save(user2);
				userRepository.save(user3);
				
		// käy kaikki kirjat listalta läpi
				
				log.info("kerää kaikki kirjat");
				for (Book book : bookRepository.findAll()) {
					log.info(book.toString());
				}

			};
		}
	}