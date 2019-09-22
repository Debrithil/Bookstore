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

@SpringBootApplication
public class BookstoreApplication {
		
		private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti

		public static void main(String[] args) {
			SpringApplication.run(BookstoreApplication.class, args);
		}
		
		//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
		@Bean // luo tietokantaan jo kaksi kirjaa ohjelman käynnistyessä
		
		public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) { 
			return (args) -> {
				log.info("tallenna pari kirjaa tietokantaan");
				
				categoryRepository.save(new Category("IT"));
				categoryRepository.save(new Category("Science"));
				categoryRepository.save(new Category("Sport"));
				
				bookRepository.save(new Book("Hands-On Full Stack Development", "Juha Hinkula", 2018, "ISBN-9781789138085", 48.40, categoryRepository.findByName("IT").get(0)));
				bookRepository.save(new Book("Java-ohjelmointi", "Mika Vesterholm", 2018, "ISBN-9789521435560", 65.50, categoryRepository.findByName("IT").get(0)));
				bookRepository.save(new Book("Mielen voima urheilussa", "Ilkka Virolainen", 2017, "ISBN-9789522606273", 21.50, categoryRepository.findByName("Sport").get(0)));
				bookRepository.save(new Book("Tiede tutkimuskohteena", "Mika Kiikeri", 2017, "ISBN-9789516629264", 22.60, categoryRepository.findByName("Science").get(0)));
				
		// käy kaikki kirjat listalta läpi
				
				log.info("kerää kaikki kirjat");
				for (Book book : bookRepository.findAll()) {
					log.info(book.toString());
				}

			};
		}
	}