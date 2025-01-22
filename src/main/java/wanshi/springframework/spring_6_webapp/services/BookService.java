package wanshi.springframework.spring_6_webapp.services;

import wanshi.springframework.spring_6_webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
