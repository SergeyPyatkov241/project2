package ru.alishev.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;
import ru.alishev.springcourse.repositories.BooksRepository;
import ru.alishev.springcourse.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BooksService {

    private final BooksRepository booksRepository;

    private final PeopleRepository peopleRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository, PeopleRepository peopleRepository) {
        this.booksRepository = booksRepository;
        this.peopleRepository = peopleRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        return foundBook.orElse(null);
    }

    @Transactional
    public void save(Book book) {
        booksRepository.save(book);
    }

    @Transactional
    public void update(int id, Book updatedBook) {
        System.out.println("------ обновление книги -----");
        System.out.println("Книга до сохранения - " + updatedBook);
        updatedBook.setId(id);

        Person bookOwner = null;
        Optional<Person> bookOwnerResult = peopleRepository.findByBooks(updatedBook);
        if(bookOwnerResult.isPresent())
            bookOwner = bookOwnerResult.get();

        updatedBook.setOwner(bookOwner);
        booksRepository.save(updatedBook);
        System.out.println("Книга после сохранения - " + updatedBook);
        System.out.println("------ конец обновления книги -----");
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public void release(int id) {
        Optional<Book> foundBook = booksRepository.findById(id);
        Book releaseBook = foundBook.get();
        releaseBook.setOwner(null);
        booksRepository.save(releaseBook);
    }

    @Transactional
    public void assign(int id, Person selectedPerson) {
        Book updatedBook = findOne(id);
        updatedBook.setOwner(selectedPerson);
        booksRepository.save(updatedBook);
    }

    public List<Book> findByOwner(Person owner) {
        return booksRepository.findByOwner(owner);
    }
}
