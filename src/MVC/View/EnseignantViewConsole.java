package MVC.View;

import Ecole.*;
import MVC.Model.ModelSalleDB;
import MVC.View.SalleAbstractView;
import MVC.controller.EnseignantController;
import MVC.controller.SalleController;
import myConnectionDB.DBConnection;
import utilitaires.Utilitaire;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static MVC.Model.ModelSalleDB.*;
import static utilitaires.Utilitaire.*;

public class EnseignantViewConsole extends EnseignantAbstractView {
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
        Utilitaire.affListe(l);
    }

    public void ajout() {
        System.out.print("Matricule :");
        String matricule = sc.nextLine();
        System.out.print("nom :");
        String nom = sc.nextLine();
        System.out.print("prenom :");
        String prenom = sc.nextLine();
        System.out.print("tel :");
        String tel = sc.nextLine();
        System.out.println("charge semestrielle : ");
        int chargeSem = lireInt();
        System.out.println("salaire mensuel : ");
        BigDecimal salaireMensu = BigDecimal.valueOf(lireDouble());
        System.out.println("date d'engagement");
        System.out.println("jour : ");
        int jour = lireInt();
        System.out.println("mois :");
        int mois = lireInt();
        System.out.println("année : ");
        int annee = lireInt();
        LocalDate date = LocalDate.of(annee, mois, jour);
        System.out.println("sigle de la salle preférée");
        List<Salle> salles = enseignantController.getSalles();
        Salle preference = salles.get(choixListe(salles)-1);
        Enseignant enseignant = new Enseignant(matricule, nom, prenom, tel, chargeSem, salaireMensu, date, preference);
        Enseignant cl = enseignantController.add(enseignant);
        if(cl==null) affMsg("La Enseignant recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("Matricule de l'Enseignant recherché : ");
        String matricule = sc.nextLine();
        Enseignant Enseignant = enseignantController.read(matricule);
        if(Enseignant==null) affMsg("La Enseignant recherchee n'existe pas");
        else{
            affMsg(Enseignant.toString());
        }
    }

    public void modification() {
        List<Enseignant> enseignants = enseignantController.getAll();
        int idrech = choixListe(enseignants);
        Enseignant enseignant = enseignants.get(idrech-1);
        int ch;
        do {
            System.out.println("1.nom\n2.prenom\n3.tel\n4.charge semestrielle\n5.salaire mensuel \n6.date d'engagement \n7.sigle de la salle preferee\n8.fin");
            System.out.println("choix : ");
            ch = lireInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    System.out.println("nouveau nom : ");
                    String nom = sc.nextLine();
                    enseignant.setNom(nom);
                    break;
                case 2:
                    System.out.println("nouveau prenom : ");
                    String prenom = sc.nextLine();
                    enseignant.setPrenom(prenom);
                    break;
                case 3:
                    System.out.println("nouveau numero de telephone : ");
                    String tel = sc.nextLine();
                    enseignant.setTel(tel);
                    break;
                case 4:
                    System.out.println("nouvelle charge semestrielle : ");
                    int chargeSem = lireInt();
                    enseignant.setChargeSem(chargeSem);
                    break;
                case 5:
                    System.out.println("nouvelle charge mensuelle : ");
                    BigDecimal salaireMensu = BigDecimal.valueOf(lireLong());
                    enseignant.setSalaireMensu(salaireMensu);
                    break;
                case 6:
                    System.out.println("nouvelle date d'engagement : ");
                    System.out.println("jour : ");
                    int jour = lireInt();
                    System.out.println("mois :");
                    int mois = lireInt();
                    System.out.println("année : ");
                    int annee = lireInt();
                    LocalDate dateEngag = LocalDate.of(annee, mois, jour);
                    enseignant.setDateEngag(dateEngag);
                    break;
                case 7:
                    System.out.println("nouvelle salle preferee : ");
                    List<Salle> salles = enseignantController.getSalles();
                    enseignant.setPreference(salles.get(choixListe(salles)-1));
                    break;
                case 8:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=8);
        Enseignant enseignantVerif = enseignantController.update(enseignant);
        if(enseignantVerif == null){
            affMsg("L'Enseignant est vide.");
        }
        else if(enseignantVerif.equals(enseignant)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Enseignant> enseignants = enseignantController.getAll();
        int idrech = choixListe(enseignants);
        Enseignant enseignant = enseignants.get(idrech-1);
        boolean isRemoved = enseignantController.remove(enseignant);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Enseignant> enseignants = enseignantController.getAll();
        affList(enseignants);
        if(enseignants.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Enseignant selectionner() {
        update(enseignantController.getAll());
        int nl = choixListe(lc);
        Enseignant enseignant = lc.get(nl - 1);
        return enseignant;
    }
}


