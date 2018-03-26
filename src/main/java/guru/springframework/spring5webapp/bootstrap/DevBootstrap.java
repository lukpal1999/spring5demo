package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        //Eric
        Author eric =new Author("Eric","Clapton");
        Publisher pub1 = new Publisher("WB","Bokserska 71");
        publisherRepository.save(pub1);

        Book book1 = new Book("Alice in the country","123456789",pub1);
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        //Adam
        Author adam =new Author("Adam","Kowlaski");
        Publisher pub2 = new Publisher("XYZ","Zamiejska 20");
        publisherRepository.save(pub2);

        Book book2 = new Book("Krzyżacy","987654321",pub2);
        adam.getBooks().add(book2);
        book2.getAuthors().add(adam);

        authorRepository.save(adam);
        bookRepository.save(book2);
    }
}
