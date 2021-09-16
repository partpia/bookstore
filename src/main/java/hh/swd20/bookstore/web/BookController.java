package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	// welcome-msg
	@GetMapping("/index")
	public String helloUser() {
		return "index";		// index.html
	}
	// all books from the database
	@GetMapping("/booklist")
	public String getAllBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "booklist";	// booklist.html
	}
}