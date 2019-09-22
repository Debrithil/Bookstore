package swd20.C4.bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.C4.bookstore.domain.Book;
import swd20.C4.bookstore.domain.BookRepository;
import swd20.C4.bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository; 
	
	@Autowired
	CategoryRepository categoryRepository;
	
	// kirjalistaus
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
			List<Book> books =  (List<Book>) bookRepository.findAll();
			model.addAttribute("books", books);
			return "booklist";
	}

	// tyhjän kirjalomakkeen muodostaminen
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
	  	model.addAttribute("categories", categoryRepository.findAll());
		return "bookform";
	}

	// kirjalomakkeella syötettyjen tietojen vastaanotto ja tallennus
	@RequestMapping(value = "/newbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		// talletetaan yhden kirjan tiedot tietokantaan
		bookRepository.save(book);
		return "redirect:/booklist";
	}

	// kirjan poisto
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	
	// kirjan muokkaus
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
	  	model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
	
	
	
}