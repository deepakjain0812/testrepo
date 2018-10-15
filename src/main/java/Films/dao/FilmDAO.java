package Films.dao;

import Films.ds.FilmDs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// interfejs dostępowy do tabeli z filmami. Konfiguracja tabeli zawarta jest w klasie FilmDs
public interface FilmDAO {
    @SuppressWarnings("unchecked")
    List<Object[]> getAllFilms();

    @SuppressWarnings("unchecked")
    List<Object[]> getFilm(String title);

    List<String> existingTitle();

    void deleteFilm(String title);

    void updateFilm(String oldTitle, String newTitle);

    void insert(FilmDs film);
}
