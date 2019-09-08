package swd20.C4.bookstore.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swd20.C4.bookstore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "bookform";
	}	

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String getNewBookForm(@ModelAttribute Book book, Model model) {
		model.addAttribute("book", book);
		return "bookresult";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("ORACLE Tietokannan tehokas hallinta", "Anssi Hakkarainen" , 2011, "1-56592-464-9", 53.80));
		books.add(new Book("Learning Python", "Mark Lutz, David Ascher" , 1999, "1-55678-234-6", 44.00));
		books.add(new Book("Java", "Simo Silander, Vesa Ollikainen, Juha Peltomäki" , 2010, "1-65478-222-9", 53.80));
		model.addAttribute("books", books); 
		return "booklist";
	}

}