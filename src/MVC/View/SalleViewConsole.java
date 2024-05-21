package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;


public class SalleViewConsole extends SalleAbstractView {
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
        System.out.print("Sigle :");
        String sigle = sc.nextLine();
        sc.skip("\n");
        System.out.print("Capacité :");
        Integer capacite = sc.nextInt();
        String query1 = "insert into API_Salle(sigle,capacite) values(?,?)";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
        ){
            pstm1.setString(1,sigle);
            pstm1.setInt(2,capacite);
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }


    public void recherche() {

        System.out.println("sigle de la Salle recherché ");
        String sigle = sc.nextLine();
        String query = "select * from API_Salle where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,sigle);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int capacite = rs.getInt(2);
                Salle salle = new Salle(sigle,capacite);
                System.out.println(salle);
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    public void modification() {
        System.out.println("sigle de la Salle recherchée ");
        String sigle = sc.nextLine();
        sc.skip("\n");
        System.out.println("nouvelle capacité : ");
        int capacite = sc.nextInt();
        String query = "update API_Salle set capacite=? where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,capacite);
            pstm.setString(2,sigle);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }
    public void suppression() {
        System.out.println("sigle de la Salle recherchée ");
        String sigle = sc.nextLine();
        String query = "delete from API_Salle where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,sigle);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    private void tous() {
        String query="select * from API_Salle";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                String sigle = rs.getString(1);
                int capacite = rs.getInt(2);
                Salle cl = new Salle(sigle,capacite);
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }
    @Override
    public Salle selectionner() {
        update(salleController.getAll());
        int nl = choixListe(lc);
        Salle Salle = lc.get(nl - 1);
        return Salle;
    }

}


