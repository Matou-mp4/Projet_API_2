package MVC.View;

import Ecole.*;
import MVC.Model.ModelSalleDB;
import MVC.View.SalleAbstractView;
import MVC.controller.SalleController;
import myConnectionDB.DBConnection;
import MVC.gestionMVC;

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

    }

    public void ajout() {
        System.out.print("Matricule :");
        String matricule = sc.nextLine();
        sc.skip("\n");
        System.out.print("nom :");
        String nom = sc.nextLine();
        System.out.print("prenom :");
        String prenom = sc.nextLine();
        System.out.print("tel :");
        String tel = sc.nextLine();
        System.out.println("charge mensuelle : ");
        int chargeSem = sc.nextInt();
        System.out.println("salaire mensuel : ");
        Float salaireMensu = sc.nextFloat();
        System.out.println("date d'engagement");
        System.out.println("jour : ");
        int jour = sc.nextInt();
        System.out.println("mois :");
        int mois = sc.nextInt();
        System.out.println("année : ");
        int annee = sc.nextInt();
        LocalDate date = LocalDate.of(annee, mois, jour);
        System.out.println("sigle de la salle preférée");
        List<Salle> salles = SalleController.getAll();


        Enseignant enseignant = new Enseignant(matricule, nom, prenom, tel, chargeSem, salaireMensu, date, preference);
        Enseignant cl = EnseignantController.add(enseignant);
        if(cl==null) affMsg("La Enseignant recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("Matricule de l'Enseignant recherché ");
        String matricule = sc.nextLine();
        Enseignant Enseignant = EnseignantController.read(matricule);
        if(Enseignant==null) affMsg("La Enseignant recherchee n'existe pas");
        else{
            affMsg(Enseignant.toString());
        }
    }

    public void modification() {
        List<Enseignant> Enseignants = EnseignantController.getAll();
        int idrech = choixListe(Enseignants);
        Enseignant Enseignant = Enseignants.get(idrech-1);
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
                    Enseignant.setNom(nom);
                    break;
                case 2:
                    System.out.println("nouveau sigle : ");
                    String prenom = sc.nextLine();
                    Enseignant.setPrenom(prenom);
                    break;
                case 3:
                    System.out.println("nouveau numero de telephone : ");
                    String tel = sc.nextLine();
                    Enseignant.setTel(tel);
                    break;
                case 4:
                    System.out.println("nouvelle charge semestrielle : ");
                    int chargeSem = lireInt();
                    Enseignant.setChargeSem(chargeSem);
                    break;
                case 5:
                    System.out.println("nouvelle charge mensuelle : ");
                    BigDecimal salaireMensu = BigDecimal.valueOf(lireLong());
                    Enseignant.setSalaireMensu(salaireMensu);
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
                    Enseignant.setDateEngag(dateEngag);
                    break;
                case 7:
                    System.out.println("nouvelle salle preferee : ");
                    Salle preference = choixListe(SalleController.getAll())-1;
                    //todo: regler le soucis
                    break;
                case 8:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=8);
        Enseignant EnseignantVerif = EnseignantController.update(Enseignant);
        if(EnseignantVerif == null){
            affMsg("La Enseignant est vide.");
        }
        else if(EnseignantVerif.equals(Enseignant)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Enseignant> Enseignants = EnseignantController.getAll();
        int idrech = choixListe(Enseignants);
        Enseignant Enseignant = Enseignants.get(idrech-1);
        boolean isRemoved = EnseignantController.remove(Enseignant);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Enseignant> Enseignants = EnseignantController.getAll();
        affList(Enseignants);
        if(Enseignants.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Enseignant selectionner() {
        update(EnseignantController.getAll());
        int nl = choixListe(lc);
        Enseignant Enseignant = lc.get(nl - 1);
        return Enseignant;
    }
}


