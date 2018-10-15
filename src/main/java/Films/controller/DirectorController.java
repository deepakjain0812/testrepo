package Films.controller;

import Films.dao.DirectorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Klasa aktualizująca dane reżysera filmu w tabeli reżyserów
@Controller
public class DirectorController {

    @Autowired
    DirectorDAO directorDao;

    // metoda wykonjąca update na tabeli z reżysrrami
    public void updateDirector() {
        Scanner sc = new Scanner(System.in);
        List<String> filmAndDirector = new ArrayList<>();
        System.out.print("Podaj tytuł, dla którego chcesz zmienić reżysera: ");
        String tytul = sc.nextLine();
        System.out.print("Podaj nowe dane reżysera, który ma być zapisany: ");
        String noweDane = sc.nextLine();
        filmAndDirector.add(tytul);
        filmAndDirector.add(noweDane);
        tytul = filmAndDirector.get(0);
        noweDane = filmAndDirector.get(1);
        directorDao.updateDirectorsFirstNameAndLastName(noweDane, tytul);
    }
}