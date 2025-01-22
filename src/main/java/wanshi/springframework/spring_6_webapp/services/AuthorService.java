package wanshi.springframework.spring_6_webapp.services;

import wanshi.springframework.spring_6_webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
