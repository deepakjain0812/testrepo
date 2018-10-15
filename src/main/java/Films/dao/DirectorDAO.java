package Films.dao;

import Films.ds.DirectorDs;
import org.springframework.stereotype.Repository;

// interfejs dostępowy do bazy z reżyserami. Konfiguracja bazy zawarta jest w klasie DirectorDs
@Repository
public interface DirectorDAO {
    void insert(DirectorDs direcor);
    void deleteDirector(String title);
    void updateDirectorsFirstNameAndLastName(String NoweDane, String tytul);
    void updateFilm(String oldTitle, String newTitle);
}
