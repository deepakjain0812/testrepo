package Films.controller;

import Films.dao.DirectorDAO;
import Films.dao.FilmDAO;
import Films.ds.DirectorDs;
import Films.ds.FilmDs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Klasa zbierająca dane od użytkownika
@Controller
public class DataFromUserController {
    @Autowired
    private FilmDAO filmDao;
    @Autowired
    private DirectorDAO directorDao;
    private Locale locale = Locale.getDefault();
    private Scanner sc = new Scanner(System.in).useLocale(locale);

    public FilmDs collectData() {
        FilmDs film = new FilmDs();
        DirectorDs director = new DirectorDs();
        film.setTytul(collectTitle());
        director.setFilm(film);
        director.setImieInazwisko(collectDirector());
        film.setCzasTrwania(collectTime());
        film.setRozmiar(collectSize());

        filmDao.insert(film);
        directorDao.insert(director);

        return film;
    }

    private String collectTitle() {
        System.out.print("Podaj tytuł filmu: ");
        String tytul = sc.nextLine();
        List<String> existingEntry = filmDao.existingTitle();
        if (existingEntry.contains(tytul)) {
            System.out.println("Tytuł jest już w bazie. Podaj inny");
            return collectTitle();
        }
        if (tytul.isEmpty()) {
            System.out.println("Tytuł nie może być pusty. Podaj go");
            return collectTitle();
        }
        return tytul;
    }

    private String collectDirector() {
        System.out.print("Podaj nazwisko i imię reżysera: ");
        String rezyser = sc.nextLine();
        if (rezyser.isEmpty() || rezyser.matches("^[(0-9)|(-0-9)]+$")) {
            System.out.println("To jest informacja obowiązkowa. Uzupełnij. Dozwolone są jedynie litery.");
            collectDirector();
        }
        return rezyser;
    }

    private String collectTime() {
        String czas;
        System.out.print("Podaj długość filmu: ");
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        try {
            czas = sc.next();
            format.parse(czas);
        } catch (ParseException e) {
            System.out.println("Błędny format czasu. Wymagany format to HH:MM:SS");
            return collectTime();
        }
        return czas;
    }

    private double collectSize() {
        double rozmiar = 0;
        System.out.print("Podaj rozmiar pliku: ");
        try {
            rozmiar = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Zgodnie z ustawieniami regionalnymi dla kraju rozmiar pliku nie może być pisany z \".\" jako separatorem.");
            sc.next();
            return collectSize();
        }
        if ((rozmiar < 0) || (rozmiar == 0)) {
            System.out.println("Rozmiar pliku nie może być mniejszy lub równy 0");
            return collectSize();
        }
        return rozmiar;
    }
}
