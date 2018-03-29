package guru.springframework.spring5webapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToMany (mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String firsName,String lastName) {
        this.firstName=firsName;
        this.lastName=lastName;
    }

    public Author(String firsName,String lastName,Set<Book> books) {
        this.firstName=firsName;
        this.lastName=lastName;
        this.books=books;
    }

}
