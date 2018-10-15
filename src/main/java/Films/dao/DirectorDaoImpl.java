package Films.dao;

import Films.ds.DirectorDs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

// klasa implementuje interfejs DAO do obsługi podstawowych operacji na bazie
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class DirectorDaoImpl implements DirectorDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // metoda dodaje dane reżysera do tabeli z reżyserami
    @Override
    public void insert(DirectorDs direcor) {
        try {
            entityManager.persist(direcor);
        } catch (Exception e) {
            System.out.println("Coś poszło nie tak. Dane nie zostały zapisane do bazy z reżyserami");
            e.printStackTrace();
        }
    }
    // metoda usuwa wpis z tabeli na podstawie tytułu otrzymanego z kontrolera FilmOperation
    @Override
    public void deleteDirector(String title) {
        Query director = entityManager.createQuery("DELETE FROM DirectorDs director WHERE director.tytul = :tytul");
        try {
            int rezyser = director.setParameter("tytul", title).executeUpdate();
            System.out.println("Z bazy reżyserów usunięto: " + rezyser + " rekord/ów");
        } catch (Exception e) {
            System.out.println("Nie usunięto danych.");
            e.printStackTrace();
        }
    }
    // metoda aktualizuje wpis o reżyserze filmu w tabeli na podstawie tytułu otrzymanego z kontrolera FilmOperation
    @Override
    public void updateDirectorsFirstNameAndLastName(String noweDane, String tytul) {
        Query updateDirector = entityManager.createQuery("UPDATE DirectorDs director SET director.imieInazwisko = :noweDane WHERE director.tytul = :tytul");
        try {
            updateDirector.setParameter("tytul", tytul);
            int update = updateDirector.setParameter("noweDane", noweDane).executeUpdate();
            System.out.println("W bazie reżyserów zmodyfikowano: " + update + " rekord/ów");
        } catch (Exception e) {
            System.out.println("Nie zmodyfikowano danych reżysera.");
            e.printStackTrace();
        }

    }
    // metoda aktualizuje wpis o filmie w tabeli na podstawie tytułu otrzymanego z kontrolera FilmOperation
    @Override
    public void updateFilm(String oldTitle, String newTitle) {
        Query updateFilm = entityManager.createQuery("UPDATE DirectorDs director SET director.tytul = :NowyTytul WHERE director.tytul = :tytul");
        try {
            updateFilm.setParameter("tytul", oldTitle);
            int updatedItems = updateFilm.setParameter("NowyTytul", newTitle).executeUpdate();
            System.out.println("W bazie reżyserów zmodyfikowano: " + updatedItems + " rekord/ów");
        } catch (Exception e) {
            System.out.println("Nie zmodyfikowano danych filmu.");
            e.printStackTrace();
        }
    }
}
