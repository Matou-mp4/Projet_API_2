package MVC.View;

import Ecole.*;
import utilitaires.Utilitaire;

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
        } while (ch != 6);

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
        Classe classe = new Classe(annee, sigle, specialite, nbreEleves);
        Classe cl = classeController.add(classe);
        if (cl == null) affMsg("La classe recherchee n'existe pas");
        else {
            affMsg(cl.toString());
        }
    }


    public void recherche() {
        System.out.println("id de la classe recherché ");
        int idrech = lireInt();
        Classe classe = classeController.read(idrech);
        if (classe == null) affMsg("La classe recherchee n'existe pas");
        else {
            affMsg(classe.toString());
            special(classe);
        }
    }

    public void modification() {
        List<Classe> classes = classeController.getAll();
        int idrech = choixListe(classes);
        Classe classe = classes.get(idrech - 1);
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
        } while (ch != 5);
        Classe classeVerif = classeController.update(classe);
        if (classeVerif == null) {
            affMsg("La classe est vide.");
        } else if (classeVerif.equals(classe)) {
            affMsg("Aucune modification n'a ete effectue.");
        } else {
            affMsg("modification effectuee");
        }
    }

    public void suppression() {
        List<Classe> classes = classeController.getAll();
        int idrech = choixListe(classes);
        Classe classe = classes.get(idrech - 1);
        boolean isRemoved = classeController.remove(classe);
        if (isRemoved) {
            affMsg("Suppression effectuee");
        } else {
            affMsg("Suppression non effectuee");
        }
    }

    private void tous() {
        List<Classe> classes = classeController.getAll();
        affList(classes);
        if (classes.isEmpty()) {
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

    public void special(Classe classe) {
        int ch;
        do {
            System.out.println("1. Lister les infos de la classe\n2. Nombre d'heures de cours\n3. Lister enseignant + heures\n4.Lister Salles + heures\n5.Lister Cours + heures\n6. ajout d'un cours\n7. Modifier un cours\n8. Supprimer un cours\n9. Verifier la capacite d'une salle\n10. Retour");
            System.out.println("choix : ");
            ch = lireInt();
            switch (ch) {
                case 1:
                    listerInfos(classe);
                    break;
                case 2:
                    nombreHeures(classe);
                    break;
                case 3:
                    listerEnseignantEtHeures(classe);
                    break;
                case 4:
                    listerSalleEtHeures(classe);
                    break;
                case 5:
                    listerCoursEtHeures(classe);
                    break;
                case 6:
                    ajoutCours(classe);
                    break;
                case 7:
                    modifierCours(classe);
                    break;
                case 8:
                    suppressionCours(classe);
                    break;
                case 9:
                    salleCapaciteOK(classe);
                    break;
                case 10:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch != 10);
    }

    public void listerInfos(Classe classe) {
        affList((classeController.listerInfos(classe)));
    }

    public void nombreHeures(Classe classe) {
        affMsg("nombre d'heure pour la classe choisie : " + classeController.nbreHeuresTot(classe));
    }

    public void listerEnseignantEtHeures(Classe classe) {
        affList(classeController.listeEnseignantsEtHeures(classe));
    }

    public void listerSalleEtHeures(Classe classe) {
        affList(classeController.listerSallesEtHeures(classe));
    }

    public void listerCoursEtHeures(Classe classe) {
        affList(classeController.listerCoursEtHeurs(classe));
    }

    public void ajoutCours(Classe classe) {
        System.out.print("Cours souhaite :");
        List<Cours> courss = classeController.getCourss();
        Cours cours = courss.get(choixListe(courss) - 1);
        System.out.print("nbre d'heures souhaitees :");
        int nbreHeures = lireInt();
        classeController.addCours(classe, cours, nbreHeures);
    }

    public void modifierCours(Classe classe) {
        System.out.print("Cours souhaite :");
        List<Cours> courss = classeController.getCourss();
        Cours cours = courss.get(choixListe(courss) - 1);
        int ch;
        do {
            System.out.println("1. Modifier enseignant\n2. Modifier salle\n3. Modifier heures\n4. Retour");
            System.out.println("choix : ");
            ch = lireInt();
            switch (ch) {
                case 1:
                    modifEnseignant(classe, cours);
                    break;
                case 2:
                    modifSalle(classe, cours);
                    break;
                case 3:
                    modifHeure(classe, cours);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (ch != 4);
    }

    public void modifEnseignant(Classe classe, Cours cours) {
        affMsg("Enseignant souhaite : ");
        List<Enseignant> enseignants = classeController.getEnseignants();
        int idrech = choixListe(enseignants);
        Enseignant enseignant = enseignants.get(idrech - 1);
        classeController.modifCours(classe, cours, enseignant);
    }

    public void modifSalle(Classe classe, Cours cours) {
        affMsg("Salle souhaitee : ");
        List<Salle> salles = classeController.getSalles();
        int idrech = choixListe(salles);
        Salle salle = salles.get(idrech - 1);
        classeController.modifCours(classe, cours, salle);
    }

    public void modifHeure(Classe classe, Cours cours) {
        System.out.print("nbre d'heures souhaitees :");
        int nbreHeures = lireInt();
        classeController.modifCours(classe, cours, nbreHeures);
    }

    public void suppressionCours(Classe classe) {
        System.out.print("Cours souhaite :");
        List<Cours> courss = classeController.getCourss();
        Cours cours = courss.get(choixListe(courss) - 1);
        classeController.suppCours(classe, cours);
    }

    public void salleCapaciteOK(Classe classe) {
        affMsg("Salle souhaitee : ");
        List<Salle> salles = classeController.getSalles();
        int idrech = choixListe(salles);
        Salle salle = salles.get(idrech - 1);
        System.out.println(classeController.salleCapaciteOK(classe, salle));
    }
}


