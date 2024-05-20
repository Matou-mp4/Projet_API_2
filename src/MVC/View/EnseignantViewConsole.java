package MVC.View;

import Ecole.*;
import MVC.Model.ModelSalleDB;
import MVC.View.SalleAbstractView;
import myConnectionDB.DBConnection;
import MVC.gestionMVC;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;
import static MVC.Model.ModelSalleDB.*;

public class EnseignantViewConsole extends EnseignantAbstractView {
    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;

    @Override
    public void affMsg(String msg) {
        System.out.println("information:" + msg);
    }

    @Override
    public void menu() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }
        System.out.println("connexion établie");
        do {
            System.out.println("1.ajout\n2.recherche\n3.modification\n4.suppression\n5.tous\n6.fin");
            System.out.println("choix : ");
            int ch = sc.nextInt();
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
                    System.exit(0);
                    break;
                default:
                    System.out.println("choix invalide recommencez ");
            }
        } while (true);

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
        int sigle = sc.nextInt();
        String query1 = "insert into API_Enseignant(matricule,nom,prenom,tel,chargesem,salairemensu,dateengag,sigle) values(?,?,?,?,?,?,?,?)";
        String query2 = "select matricule from API_Enseignant where nom = ? and  prenom=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, matricule);
            pstm1.setString(2, nom);
            pstm1.setString(3, prenom);
            pstm1.setString(4, tel);
            pstm1.setInt(5, chargeSem);
            pstm1.setFloat(6, salaireMensu);
            pstm1.setDate(7, Date.valueOf(date));
            pstm1.setInt(8, sigle);
            int n = pstm1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if (n == 1) {
                pstm2.setString(1, nom);
                pstm2.setString(2, prenom);
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    String mat = rs.getString(1);
                    System.out.println("matricule = " + mat);
                } else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }


    public void recherche() {

        System.out.println("matricule de l'Enseignant recherché ");
        String mat = sc.nextLine();
        String query = "select * from API_Enseignant where  matricule = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, mat);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String matricule = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String tel = rs.getString(4);
                int chargesem = rs.getInt(5);
                BigDecimal salaireMensu = BigDecimal.valueOf(rs.getFloat(6));
                LocalDate date = rs.getDate(7).toLocalDate();
                int sigle = rs.getInt(8);
                Salle salle;
                Enseignant cl = new Enseignant(matricule, nom, prenom, tel, chargesem, salaireMensu, date, salle);
                System.out.println(cl);
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }

    }

    public void modification() {
        System.out.println("Matricule de l'Enseignant recherché");
        int idrech = sc.nextInt();
        sc.skip("\n");
        System.out.println("nouveau nombre d'élève : ");
        int nbreEleves = sc.nextInt();
        String query = "update API_Enseignant set =? where  = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, nbreEleves);
            pstm.setInt(2, idrech);
            int n = pstm.executeUpdate();
            if (n != 0) System.out.println(n + "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    public void suppression() {
        System.out.println("id de la Enseignant recherchée ");
        int idrech = sc.nextInt();
        String query = "delete from API_Enseignant where  = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idrech);
            int n = pstm.executeUpdate();
            if (n != 0) System.out.println(n + "ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }

    }

    private void tous() {
        String query = "select * from API_Enseignant";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                int idEnseignant = rs.getInt(1);
                String sigle = rs.getString(5);
                String specialite = rs.getString(3);
                int annee = rs.getInt(2);
                int nbreEleves = rs.getInt(4);
                Enseignant cl = new Enseignant();
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }

    @Override
    public Enseignant selectionner() {
        update(EnseignantController.getAll());
        int nl = choixListe(lc);
        Enseignant Enseignant = lc.get(nl - 1);
        return Enseignant;
    }

    public String choixSigle() {
        ArrayList<Salle> ls = MVC.gestionMVC.;

    }
}


