package kz.iitu.end.entity;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String title;


    public Book(){}

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "book_genres",
//            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "genre_id", referencedColumnName = "id")}
//    )
//    private List<Genre> genres = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "book_authors",
//            joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
//    )
//    private List<Author> authors = new ArrayList<>();

    public Book(String title)
    {
        this.title = title;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title ;
    }
}
