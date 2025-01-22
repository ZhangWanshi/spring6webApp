package wanshi.springframework.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wanshi.springframework.spring_6_webapp.domain.Author;
import wanshi.springframework.spring_6_webapp.domain.Book;
import wanshi.springframework.spring_6_webapp.domain.Publisher;
import wanshi.springframework.spring_6_webapp.repositories.AuthorRepository;
import wanshi.springframework.spring_6_webapp.repositories.BookRepository;
import wanshi.springframework.spring_6_webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE development without EJB");
        noEJB.setIsbn("87549239");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);


        //build association between author and book
        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(ericSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher penguin = new Publisher();
        penguin.setPublisherName("penguin");
        penguin.setAddress("D12CH79");
        penguin.setCity("New York");
        penguin.setState("NY");
        penguin.setZip("9748ed");

        Publisher penguinSaved = publisherRepository.save(penguin);


        //build association between publisher and book
        dddSaved.setPublisher(penguinSaved);
        noEJBSaved.setPublisher(penguinSaved);

        //save the association
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);


        System.out.println("in boostrap data");
        System.out.println("author count: " + authorRepository.count());
        System.out.println("book count: " + bookRepository.count());
        System.out.println("publisher count: " + publisherRepository.count());
    }
}
