package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	// welcome-message
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
	
	// create a new book
	@GetMapping("/newbook")
	public String createNewBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";	// addbook.html
	}
	
	// save / update book
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	// delete book
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:/booklist";
	}
	
	// edit book
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		return "editbook";	// editbook.html
	}
}