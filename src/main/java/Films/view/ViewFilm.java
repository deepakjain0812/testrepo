package Films.view;

import Films.controller.FilmOperationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
// klasa odpowiadająca za wyświetlanie elementów z tabel na ekranie
public class ViewFilm {
	@Autowired
	private FilmOperationController filmOperationController;

	// metoda wyświetla wszystkie wpisy z tabeli
	public void viewAll() {
		for (Object[] film : filmOperationController.showAll()) {
			Arrays.asList(film);
			System.out.print("Nr. " + film[0] + ", Tytuł: " + film[1] + ", Reżyser: " + film[4] + ", Czas:  "
					+ film[2] + ", Wielkość pliku: " + film[3] + "\n");
		}
	}

	// metoda wyświetla wpis w tabeli wyszukany po tytule. Tytuł pochodzi z klasy
	// FilmOperationController
	public void viewSearched() {
		for (Object[] film : filmOperationController.showByTitle()) {
			Arrays.asList(film);
			System.out.print("Nr. " + film[0] + ", Tytuł: " + film[1] + ", Reżyser: " + film[4] + ", Czas:  "
					+ film[2] + ", Wielkość pliku: " + film[3] + "\n");
		}
	}
}
