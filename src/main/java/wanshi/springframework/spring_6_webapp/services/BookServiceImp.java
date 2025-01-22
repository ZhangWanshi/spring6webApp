package wanshi.springframework.spring_6_webapp.services;


import org.springframework.stereotype.Service;
import wanshi.springframework.spring_6_webapp.domain.Book;
import wanshi.springframework.spring_6_webapp.repositories.BookRepository;

@Service
public class BookServiceImp implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
