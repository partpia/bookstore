package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	// creating test data for database
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository,
			CategoryRepository categoryRepository) {
		return (args) -> {
			
			log.info("Save a couple of categories");
			
			categoryRepository.save(new Category("Crafts"));
			categoryRepository.save(new Category("Sports"));
			categoryRepository.save(new Category("Poetry"));
			
			log.info("Save a few of books");
			bookRepository.save(new Book("Clean Code", "Robert C. Martin", 2008, "9780132350884", 40.40));
			bookRepository.save(new Book("Knitting Know-How", "Peters Ryland", 2020, "9781782498278", 12.95));
			bookRepository.save(new Book("Understanding the Golf Swing", "Carol Mann", 2018, "9781510725973", 16.95));
			
			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}