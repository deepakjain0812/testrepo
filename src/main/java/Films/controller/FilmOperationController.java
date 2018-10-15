package Films.controller;

import Films.dao.DirectorDAO;
import Films.dao.FilmDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@RestController
// klasa odpowiada za pobieranie oraz przsył danych wykorzystywanych w DAO
public class FilmOperationController {

    private Scanner sc = new Scanner(System.in);
    @Autowired
    private FilmDAO filmDao;
    @Autowired
    private DirectorDAO directorDao;

    // metoda zbiera tytuł, po którym będzie wyszukiwany film w bazie
    protected String searchedFilm() {
        String title = "";
        System.out.print("Podaj tytuł, który chcesz wyszukać: ");
        title = sc.nextLine();
        return title;
    }

    // metoda zbiera tytuł, po którym będzie usuwany film z bazy
    public void deteleteExistingFilm() {
        String title = "";
        System.out.print("Podaj tytuł, który chcesz usunąć: ");
        title = sc.nextLine();
        filmDao.deleteFilm(title);
        directorDao.deleteDirector(title);
    }

    // metoda zbiera tytuł istniejący i nowy, po którym będzie modyfikowany film w bazie
    public void updateExistingFilm() {
        System.out.print("Podaj tytuł, który chcesz zaktualizować: ");
        String oldTitle = sc.nextLine();
        System.out.print("Podaj nowy tytuł, który ma być zapisany: ");
        String newTitle = sc.nextLine();
        filmDao.updateFilm(oldTitle, newTitle);
        directorDao.updateFilm(oldTitle, newTitle);
    }

    // metoda zwraca listę wszystkich filmów bazie
    @RequestMapping(value = "/showAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public List<Object[]> showAll() {
        return filmDao.getAllFilms();
    }

    // metoda zwraca listę filmów po podaniu tytułu
    @Transactional(readOnly = true)
    public List<Object[]> showByTitle() {
        return filmDao.getFilm(searchedFilm());
    }
}