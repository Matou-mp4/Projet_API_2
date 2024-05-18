package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;


public class CoursViewConsole extends CoursAbstractView {
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
        System.out.print("Code :");
        String code = sc.nextLine();
        sc.skip("\n");
        System.out.print("Intitulé :");
        String intitule = sc.nextLine();
        String query1 = "insert into API_Cours(code,intitule) values(?,?)";
        String query2 = "select code from API_Cours where intitule= ?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setString(1,code);
            pstm1.setString(2,intitule);
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }


    public void recherche() {

        System.out.println("Code du cours recherché : ");
        String idrech = sc.nextLine();
        String query = "select * from API_Cours where code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,idrech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                String intitule = rs.getString(2);
                Cours cl = new Cours(idrech,intitule);
                System.out.println(cl);
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    public void modification() {
        System.out.println("code du Cours recherché : ");
        String idrech = sc.nextLine();
        sc.skip("\n");
        System.out.println("nouveau nombre d'élève : ");
        String intitule = sc.nextLine();
        String query = "update API_Cours set intitule=? where code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,intitule);
            pstm.setString(2,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }
    public void suppression() {
        System.out.println("Code du cours recherché ");
        String idrech = sc.nextLine();
        String query = "delete from API_Cours where code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    private void tous() {
        String query="select * from API_Cours";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                String code = rs.getString(1);
                String intitule = rs.getString(5);

                Cours cl = new Cours(code,intitule);
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
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


