package Films.dao;

import Films.ds.FilmDs;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

// klasa implementuje interfejs DAO do obsługi podstawowych operacji na bazie
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class FilmDaoImpl implements FilmDAO {

	@PersistenceContext
	private EntityManager entityManager;

	// metoda zwraca wszystkie wartości z tabeli
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getAllFilms() {

		List<Object[]> all;

		return entityManager.createNativeQuery(
				"SELECT film.id, film.tytul, film.czasTrwania, film.rozmiar, director.imieInazwisko FROM film film "
						+ "JOIN director director ON film.tytul=director.tytul")
				.getResultList();
	}

	// wyszukiwanie po tytule. Tytuł przekazany z kontrolera FilmOperation
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getFilm(String title) {

		List<Object[]> searchedTitle;

		Query query = entityManager
				.createQuery("SELECT film.id, film.tytul, film.czasTrwania, film.rozmiar, director.imieInazwisko "
						+ "FROM FilmDs film JOIN DirectorDs director ON film.tytul=director.tytul WHERE film.tytul LIKE :tytul");
		query.setParameter("tytul", title);

		return searchedTitle = query.getResultList();
	}

	// metoda pobiera listę tytułów z tabeli z kolumny tytul
	@Override
	@SuppressWarnings("unchecked")
	public List<String> existingTitle() {
		List<String> titleInTheDatabase;
		return entityManager.createQuery("SELECT film.tytul FROM FilmDs film").getResultList();
	}

	// metoda usuwa wpis z tabeli na podstawie tytułu otrzymanego z kontrolera
	// FilmOperation
	@Override
	public void deleteFilm(String title) {
		Query film = entityManager.createQuery("DELETE FROM FilmDs film WHERE film.tytul = :tytul");
		try {
			int tytul = film.setParameter("tytul", title).executeUpdate();
			System.out.println("Z bazy filmów usunięto " + tytul + " rekord/ów");
		} catch (Exception e) {
			System.out.println("Dane nie zostały usunięte");
			e.printStackTrace();
		}
	}

	// metoda aktualizuje podany tytuł w tabeli na nowy otrzymany z kontrolera
	// FilmOperation
	@Override
	public void updateFilm(String oldTitle, String newTitle) {
		Query query = entityManager
				.createQuery("UPDATE FilmDs film SET film.tytul = :NowyTytul WHERE film.tytul = :tytul");
		try {
			query.setParameter("tytul", oldTitle);
			int updatedItems = query.setParameter("NowyTytul", newTitle).executeUpdate();
			System.out.println("W bazie filmów zmodyfikowano: " + updatedItems + " rekord/ów");
		} catch (Exception e) {
			System.out.println("Nie zmodyfikowano tytułu.");
			e.printStackTrace();
		}
	}

	// metoda zapisuje do tabeli dane otrzymane z kontrolera dataFromUser
	@Override
	public void insert(FilmDs film) {
		try {
			entityManager.persist((film));
		} catch (Exception e) {
			System.out.println("Coś poszło nie tak. Dane nie zostały zapisane");
			e.printStackTrace();
		}
	}
}
