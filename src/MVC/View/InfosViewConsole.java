package MVC.View;

import Ecole.*;
import MVC.controller.ClasseController;
import MVC.controller.EnseignantController;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;
import static utilitaires.Utilitaire.lireInt;


public class InfosViewConsole extends InfosAbstractView {
    private Scanner sc = new Scanner(System.in);
    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }
    @Override
    public void menu() {
        int ch;
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            ch = lireInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    ajout();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modification();
                    break;
                case 4:
                    suppression();
                    break;
                case 5:
                    tous();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=6);

    }


    @Override
    public void affList(List l) {
        affList(l);
    }

    public void ajout() {
        //todo:trouver une solution
        System.out.print("Classe souhaitee :");
        List<Classe> classes = infosController.getClasses();
        Classe classe = classes.get(choixListe(classes)-1);
        System.out.print("Cours souhaite :");
        List<Cours> courss = infosController.getCourss();
        Cours cours = courss.get(choixListe(courss)-1);
        System.out.print("Enseignant souhaite :");
        List<Enseignant> enseignants = infosController.getEnseignants();
        Enseignant enseignant = enseignants.get(choixListe(enseignants)-1);
        System.out.print("Salle souhaitee :");
        List<Salle> salles = infosController.getSalles();
        Salle salle = salles.get(choixListe(salles)-1);
        System.out.print("nbre d'heures souhaitees :");
        int nbreHeures = lireInt();
        Infos Infos = new Infos(nbreHeures,cours,enseignant,salle,classe);
        Infos cl = infosController.add(Infos);
        if(cl==null) affMsg("La Infos recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("id de l'infos recherché ");
        int idrech = lireInt();
        Infos infos = infosController.read(idrech);
        if(infos==null) affMsg("La Infos recherchee n'existe pas");
        else{
            affMsg(infos.toString());
        }
    }
    //todo:arranger ca...
    public void modification() {
        List<Infos> Infoss = infosController.getAll();
        int idrech = choixListe(Infoss);
        Infos Infos = Infoss.get(idrech-1);
        int ch;
        do {
            System.out.println("1.Classe\n2.Cours\n3.Enseignant\n4.Salle\n5.Nbre d'heures\n6.Fin");
            System.out.println("choix : ");
            ch = lireInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    System.out.println("nouvelle Classe : ");
                    List<Classe> classes = infosController.getClasses();
                    Classe classe = classes.get(choixListe(classes)-1);
                    Infos.setClasse(classe);
                    break;
                case 2:
                    System.out.println("nouveau Cours : ");
                    List<Cours> courss = infosController.getCourss();
                    Cours cours = courss.get(choixListe(courss)-1);
                    Infos.setCours(cours);
                    break;
                case 3:
                    System.out.println("nouvel Enseignant : ");
                    List<Enseignant> enseignants = infosController.getEnseignants();
                    Enseignant enseignant = enseignants.get(choixListe(enseignants)-1);
                    Infos.setEnseignant(enseignant);
                    break;
                case 4:
                    System.out.println("nouvelle Salle : ");
                    List<Salle> salles = infosController.getSalles();
                    Salle salle = salles.get(choixListe(salles)-1);
                    Infos.setSalle(salle);
                    break;
                case 5:
                    System.out.println("nouveau nbre d'heures");
                    int nbreHeures = lireInt();
                    Infos.setNbreHeures(nbreHeures);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=5);
        Infos InfosVerif = infosController.update(Infos);
        if(InfosVerif == null){
            affMsg("La Infos est vide.");
        }
        else if(InfosVerif.equals(Infos)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Infos> Infoss = infosController.getAll();
        int idrech = choixListe(Infoss);
        Infos Infos = Infoss.get(idrech-1);
        boolean isRemoved = infosController.remove(Infos);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Infos> Infoss = infosController.getAll();
        affList(Infoss);
        if(Infoss.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Infos selectionner() {
        update(infosController.getAll());
        int nl = choixListe(lc);
        Infos Infos = lc.get(nl - 1);
        return Infos;
    }

}


