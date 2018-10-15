package Films;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import Films.controller.DataFromUserController;
import Films.controller.DirectorController;
import Films.controller.FilmOperationController;
import Films.view.ViewFilm;

@SpringBootApplication
public class Main {

	
	  private ConfigurableApplicationContext application; private
	  DataFromUserController dataFromUserController = new DataFromUserController();
	  private FilmOperationController filmOperationController = new
	  FilmOperationController(); private DirectorController directorController =
	  new DirectorController(); private ViewFilm viewFilm = new ViewFilm();
	 
	/*public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}*/

	public static void main(String[] args) {
		Main m = new Main();
		m.startSpringApp();
		m.addAndSave();
		m.showAndSearch();
		m.updateAndDelete();
		m.closeSpringApp();
	}

	private void startSpringApp() {
        application = SpringApplication.run(Main.class);
        dataFromUserController = application.getBean(DataFromUserController.class);
        filmOperationController = application.getBean(FilmOperationController.class);
        directorController = application.getBean(DirectorController.class);
        viewFilm = application.getBean(ViewFilm.class);
    }
	
	  private void addAndSave() { dataFromUserController.collectData(); }
	  
	  private void showAndSearch() { viewFilm.viewAll(); //
	  viewFilm.viewSearched(); }
	  
	  private void updateAndDelete() {
	  filmOperationController.updateExistingFilm();
	  directorController.updateDirector();
	  filmOperationController.deteleteExistingFilm(); }
	  
	  private void closeSpringApp() { application.close(); }
	 
}
