package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;
import utilitaires.Utilitaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.*;


public class ClasseViewConsole extends ClasseAbstractView {
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
        System.out.print("Année :");
        Integer annee = lireInt();
        System.out.print("Sigle :");
        String sigle = sc.nextLine();
        System.out.print("Specialite :");
        String specialite = sc.nextLine();
        System.out.print("Nombre d'élèves :");
        Integer nbreEleves = lireInt();
        Classe classe = new Classe(annee,sigle,specialite,nbreEleves);
        Classe cl = classeController.add(classe);
        if(cl==null) affMsg("La classe recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("id de la classe recherché ");
        int idrech = lireInt();
        Classe classe = classeController.read(idrech);
        if(classe==null) affMsg("La classe recherchee n'existe pas");
        else{
            affMsg(classe.toString());
        }
    }

    public void modification() {
        List<Classe> classes = classeController.getAll();
        int idrech = choixListe(classes);
        Classe classe = classes.get(idrech-1);
        int ch;
        do {
            System.out.println("1.annee\n2.sigle\n3.specialite\n4.nbreEleves\n5.fin");
            System.out.println("choix : ");
            ch = lireInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    System.out.println("nouvelle annee : ");
                    int annee = lireInt();
                    classe.setAnnee(annee);
                    break;
                case 2:
                    System.out.println("nouveau sigle : ");
                    String sigle = sc.nextLine();
                    classe.setSigle(sigle);
                    break;
                case 3:
                    System.out.println("nouvelle specialite : ");
                    String specialite = sc.nextLine();
                    classe.setSpecialite(specialite);
                    break;
                case 4:
                    System.out.println("nouveau nombre d'élève : ");
                    int nbreEleves = lireInt();
                    classe.setNbreEleves(nbreEleves);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=5);
        Classe classeVerif = classeController.update(classe);
        if(classeVerif == null){
            affMsg("La classe est vide.");
        }
        else if(classeVerif.equals(classe)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Classe> classes = classeController.getAll();
        int idrech = choixListe(classes);
        Classe classe = classes.get(idrech-1);
        boolean isRemoved = classeController.remove(classe);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Classe> classes = classeController.getAll();
        affList(classes);
        if(classes.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Classe selectionner() {
        update(classeController.getAll());
        int nl = choixListe(lc);
        Classe classe = lc.get(nl - 1);
        return classe;
    }

}


