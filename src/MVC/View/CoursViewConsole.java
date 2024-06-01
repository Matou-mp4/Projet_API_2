package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;
import utilitaires.Utilitaire;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;
import static utilitaires.Utilitaire.lireInt;


public class CoursViewConsole extends CoursAbstractView {
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
        System.out.print("Code :");
        String code = sc.nextLine();
        System.out.print("Intitulé :");
        String intitule = sc.nextLine();
        Cours Cours = new Cours(code,intitule);
        Cours cl = CoursController.add(Cours);
        if(cl==null) affMsg("La Cours recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("Code du cours recherché : ");
        String code = sc.nextLine();
        Cours Cours = CoursController.read(code);
        if(Cours==null) affMsg("La Cours recherchee n'existe pas");
        else{
            affMsg(Cours.toString());
        }
    }

    public void modification() {
        List<Cours> Courss = CoursController.getAll();
        int idrech = choixListe(Courss);
        Cours Cours = Courss.get(idrech-1);
        int ch;
        do {
            System.out.println("1.intitule\n2.fin");
            System.out.println("choix : ");
            ch = lireInt();
            switch (ch) {
                case 1:
                    System.out.println("nouvel intitule : ");
                    String intitule = sc.nextLine();
                    Cours.setIntitule(intitule);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=2);
        Cours CoursVerif = CoursController.update(Cours);
        if(CoursVerif == null){
            affMsg("La Cours est vide.");
        }
        else if(CoursVerif.equals(Cours)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Cours> Courss = CoursController.getAll();
        int idrech = choixListe(Courss);
        Cours Cours = Courss.get(idrech-1);
        boolean isRemoved = CoursController.remove(Cours);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Cours> Courss = CoursController.getAll();
        affList(Courss);
        if(Courss.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Cours selectionner() {
        update(CoursController.getAll());
        int nl = choixListe(lc);
        Cours Cours = lc.get(nl - 1);
        return Cours;
    }

}


