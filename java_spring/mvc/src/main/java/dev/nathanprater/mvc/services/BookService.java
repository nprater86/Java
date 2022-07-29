package dev.nathanprater.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.nathanprater.mvc.models.Book;
import dev.nathanprater.mvc.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //updates a book
    @Transactional
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            Book targetBook = optionalBook.get();
            if(title != null) {
            	targetBook.setTitle(title);
            }
            
            if(desc != null) {
            	targetBook.setDescription(desc);
            }
            
            if(lang != null) {
            	targetBook.setLanguage(lang);
            }
            
            if(numOfPages != null) {
            	targetBook.setNumberOfPages(numOfPages);
            }
            
            System.out.println(numOfPages);
            System.out.println(title);
            
            return targetBook;
        } else {
        	return null;
        }
    }
    
    //deletes a book
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
