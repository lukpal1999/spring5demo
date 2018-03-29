package guru.springframework.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Recipe receipe;

    @Lob
    private String receipeNotes;

    public Note() {
    }

    public Note(Recipe receipe, String receipeNotes) {
        this.receipe = receipe;
        this.receipeNotes = receipeNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getReceipe() {
        return receipe;
    }

    public void setReceipe(Recipe receipe) {
        this.receipe = receipe;
    }

    public String getReceipeNotes() {
        return receipeNotes;
    }

    public void setReceipeNotes(String receipeNotes) {
        this.receipeNotes = receipeNotes;
    }
}
