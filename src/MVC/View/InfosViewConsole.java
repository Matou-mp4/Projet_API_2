package MVC.View;

import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

import static utilitaires.Utilitaire.choixListe;


public class InfosViewConsole extends InfosAbstractView {
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
        System.out.print("Année :");
        Integer annee = sc.nextInt();
        sc.skip("\n");
        System.out.print("Sigle :");
        String sigle = sc.nextLine();
        System.out.print("Specialite :");
        String specialite = sc.nextLine();
        System.out.print("Nombre d'élèves :");
        Integer nbreEleves = sc.nextInt();
        String query1 = "insert into API_Infos(annee,sigle,specialite,nbreeleves) values(?,?,?,?)";
        String query2 = "select idInfos from API_Infos where annee= ? and sigle =?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setInt(1,annee);
            pstm1.setString(2,sigle);
            pstm1.setString(3,specialite);
            pstm1.setInt(4,nbreEleves);
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
            if(n==1){
                pstm2.setInt(1,annee);
                pstm2.setString(2,sigle);
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idInfos= rs.getInt(1);
                    System.out.println("idclient = "+idInfos);
                }
                else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }


    public void recherche() {

        System.out.println("id de la Infos recherché ");
        int idrech = sc.nextInt();
        String query = "select * from API_Infos where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int annee = rs.getInt(2);
                String sigle = rs.getString(5);
                int nbreEleves = rs.getInt(4);
                String specialite = rs.getString(3);
                Infos cl = new Infos(idrech,sigle,specialite,annee,nbreEleves);
                System.out.println(cl);
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    public void modification() {
        System.out.println("id de la Infos recherchée ");
        int idrech = sc.nextInt();
        sc.skip("\n");
        System.out.println("nouveau nombre d'élève : ");
        int nbreEleves = sc.nextInt();
        String query = "update API_Infos set nbreeleves=? where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,nbreEleves);
            pstm.setInt(2,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne mise à jour");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
    }
    public void suppression() {
        System.out.println("id de la Infos recherchée ");
        int idrech = sc.nextInt();
        String query = "delete from API_Infos where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech);
            int n = pstm.executeUpdate();
            if(n!=0) System.out.println(n+ "ligne supprimée");
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    private void tous() {
        String query="select * from API_Infos";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int idInfos = rs.getInt(1);
                String sigle = rs.getString(5);
                String specialite = rs.getString(3);
                int annee = rs.getInt(2);
                int nbreEleves = rs.getInt(4);
                Infos cl = new Infos(idInfos,sigle,specialite,annee,nbreEleves);
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }
    @Override
    public Infos selectionner() {
        update(InfosController.getAll());
        int nl = choixListe(lc);
        Infos Infos = lc.get(nl - 1);
        return Infos;
    }

}


