package MVC;
import Ecole.*;
import MVC.Model.*;
import MVC.View.*;
import MVC.controller.*;
import utilitaires.Utilitaire;

import java.util.Arrays;
import java.util.List;


public class GestionMVC {
    public static DAO<Salle> modelSalle;
    public static SalleAbstractView salleAbstractView;
    public static SalleController salleController;
    private DAO<Classe> modelClasse;
    public static ClasseAbstractView classeAbstractView;
    public static ClasseController classeController;
    private DAO<Cours> modelCours;
    public static CoursAbstractView coursAbstractView;
    public static CoursController coursController;
    private DAO<Enseignant> modelEnseignant;
    public static EnseignantAbstractView enseignantAbstractView;
    public static EnseignantController enseignantController;
    private DAO<Infos> modelInfos;
    public static InfosAbstractView infosAbstractView;
    public static InfosController infosController;
    public void gestion(){
        modelSalle = new ModelSalleDB();
        modelClasse = new ModelClasseDB();
        modelEnseignant = new ModelEnseignantDB();
        modelInfos = new ModelInfosDB();
        modelCours = new ModelCoursDB();

        salleAbstractView = new SalleViewConsole();
        classeAbstractView = new ClasseViewConsole();
        enseignantAbstractView = new EnseignantViewConsole();
        infosAbstractView = new InfosViewConsole();
        coursAbstractView = new CoursViewConsole();

        salleController = new SalleController(modelSalle,salleAbstractView);
        classeController = new ClasseController(modelClasse,classeAbstractView);
        enseignantController = new EnseignantController(modelEnseignant,enseignantAbstractView);
        infosController = new InfosController(modelInfos,infosAbstractView);
        coursController = new CoursController(modelCours,coursAbstractView);

        enseignantController.setSalleController(salleController);

        classeController.setCoursController(coursController);
        classeController.setEnseignantController(enseignantController);
        classeController.setSalleController(salleController);
        classeController.setInfosController(infosController);

        infosController.setClasseController(classeController);
        infosController.setCoursController(coursController);
        infosController.setEnseignantController(enseignantController);
        infosController.setSalleController(salleController);

        salleController.setEnseignantController(enseignantController);
        salleController.setInfosController(infosController);
        salleController.setClasseController(classeController);

        modelSalle.addObserver(salleAbstractView);
        modelClasse.addObserver(classeAbstractView);
        modelEnseignant.addObserver(enseignantAbstractView);
        modelInfos.addObserver(infosAbstractView);
        modelCours.addObserver(coursAbstractView);

        List<String> lOptions = Arrays.asList("Classe","Cours","Enseignant","Salle","Infos","fin");
        do{
            int ch = Utilitaire.choixListe(lOptions);
            switch (ch){
                case 1 : classeAbstractView.menu();
                    break;
                case 2 : coursAbstractView.menu();
                    break;
                case 3 : enseignantAbstractView.menu();
                    break;
                case 4 : salleAbstractView.menu();
                    break;
                case 5 : infosAbstractView.menu();
                    break;
                case 6 : System.exit(0);
            }
        }
        while (true);
    }
    public static void main(String[] args) {
        GestionMVC gestionMVC = new GestionMVC();
        gestionMVC.gestion();
    }

}
