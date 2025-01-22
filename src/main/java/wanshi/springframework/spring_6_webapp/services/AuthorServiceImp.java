package wanshi.springframework.spring_6_webapp.services;

import org.springframework.stereotype.Service;
import wanshi.springframework.spring_6_webapp.domain.Author;
import wanshi.springframework.spring_6_webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImp implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
