package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;
import utilitaires.Utilitaire;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;
import static utilitaires.Utilitaire.lireInt;


public class SalleViewConsole extends SalleAbstractView {
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
        System.out.print("Sigle :");
        Integer sigle = lireInt();
        System.out.print("Nombre de place :");
        int capacite = lireInt();
        Salle Salle = new Salle(sigle,capacite);
        Salle cl = salleController.add(Salle);
        if(cl==null) affMsg("La Salle recherchee n'existe pas");
        else{
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("sigle de la Salle recherché : ");
        int sigle = lireInt();
        Salle salle = salleController.read(sigle);
        if(salle==null) affMsg("La Salle recherchee n'existe pas");
        else{
            affMsg(salle.toString());
            afficheClassesParSalle(salle);
            special(salle);
        }

    }

    public void afficheClassesParSalle(Salle salle){
        ArrayList<Salle> salles = new ArrayList<>();
        ArrayList<Classe> classes = new ArrayList<>();
        int cpt;
        for (Infos infos:salleController.getInfos()
             ) {
            if (salle.getSigle()==infos.getSalle().getSigle()) {
                cpt=0;
                for (Classe cl: classes
                     ) {
                    if(infos.getClasse().getIdClasse()==cl.getIdClasse()){
                        cpt++;
                    }
                }
                if(cpt==0){
                    salles.add(infos.getSalle());
                    Classe classe = infos.getClasse();
                    classes.add(salleController.getClasseController().read(classe.getIdClasse()));
                }
            }
        }
        //Utilitaire.affListe(classes);
    }

    public void modification() {
        List<Salle> Salles = salleController.getAll();
        int idrech = choixListe(Salles);
        Salle Salle = Salles.get(idrech-1);
        int ch;
        do {
            System.out.println("1. Capacite\n2. Retour");
            System.out.println("choix : ");
            ch = lireInt();
            switch (ch) {
                case 1:
                    System.out.println("nouvelle capacite : ");
                    int capacite = lireInt();
                    Salle.setCapacite(capacite);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch!=2);
        Salle SalleVerif = salleController.update(Salle);
        if(SalleVerif == null){
            affMsg("La Salle est vide.");
        }
        else if(SalleVerif.equals(Salle)){
            affMsg("Aucune modification n'a ete effectue.");
        }
        else{
            affMsg("modification effectuee");
        }
    }
    public void suppression() {
        List<Salle> Salles = salleController.getAll();
        int idrech = choixListe(Salles);
        Salle Salle = Salles.get(idrech-1);
        boolean isRemoved = salleController.remove(Salle);
        if(isRemoved){
            affMsg("Suppression effectuee");
        }
        else{
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Salle> Salles = salleController.getAll();
        affList(Salles);
        if(Salles.isEmpty()){
            affMsg("La liste est vide.");
        }
    }
    @Override
    public Salle selectionner() {
        update(salleController.getAll());
        int nl = choixListe(lc);
        Salle Salle = lc.get(nl - 1);
        return Salle;
    }
    public void special(Salle salle) {
        int ch;
        do {
            System.out.println("1. Lister les enseignant ayant cette salle par derault\n2. Retour");
            System.out.println("choix : ");
            ch = lireInt();
            switch (ch) {
                case 1:
                    ensSalleDefault(salle);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch != 2);
    }

    private void ensSalleDefault(Salle salle) {
       affList(salleController.ensSalleDefault(salle));
    }
}


