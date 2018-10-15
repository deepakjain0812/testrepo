package Films.ds;

import javax.persistence.*;
// konfiguracja tabeli z filmami
@Entity
@Table(name = "film")
public class FilmDs {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "tytul",columnDefinition = "varchar(255) NOT NULL")
    private String tytul;
    @Column(name = "czasTrwania", columnDefinition = "varchar(255) NOT NULL")
    private String czasTrwania;
    @Column(name = "rozmiar", precision = 0, scale = 6)
    private double rozmiar;

    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(String czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public double getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(double rozmiar) {
        this.rozmiar = rozmiar;
    }
}
