package Films.ds;

import javax.persistence.*;
// konfiguracja tabeli z tytułem filmu i reżyserem
@Entity
@Table(name = "director")
public class DirectorDs {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "imieInazwisko", columnDefinition = "varchar(255) NOT NULL")
    private String imieInazwisko;
    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "tytul", referencedColumnName = "tytul")
    private FilmDs film;
    @Column(insertable = false, updatable = false, columnDefinition = "varchar(255) NOT NULL")
    private String tytul;

    public FilmDs getFilm() {
        return film;
    }

    public void setFilm(FilmDs film) {
        this.film = film;
    }

    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImieInazwisko() {
        return imieInazwisko;
    }

    public void setImieInazwisko(String imieInazwisko) {
        this.imieInazwisko = imieInazwisko;
    }
}
