import java.sql.Connection;
import java.util.Scanner;
import myConnectionDB.DBConnection;
import java.math.BigDecimal;
import java.sql.*;

public class gestionClasse {
    private Scanner sc = new Scanner(System.in);
    private Connection dbConnect;
    public gestionClasse(){

    }

    public void gestion() {
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
        String query1 = "insert into API_CLASSE(annee,sigle,specialite,nbreelves) values(?,?,?,?)";
        String query2 = "select idclasse from API_CLASSE where annee= ? and sigle =?";
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
                    int idClasse= rs.getInt(1);
                    System.out.println("idclient = "+idClasse);
                }
                else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }


    public void recherche() {

        System.out.println("id de la classe recherché ");
        int idrech = sc.nextInt();
        String query = "select * from API_CLASSE where idClasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idrech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int annee = rs.getInt(2);
                String sigle = rs.getString(5);
                int nbreEleves = rs.getInt(4);
                String specialite = rs.getString(3);
                Classe cl = new Classe(idrech,sigle,specialite,annee,nbreEleves);
                System.out.println(cl);
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }

    }

    public void modification() {
        System.out.println("id de la classe recherchée ");
        int idrech = sc.nextInt();
        sc.skip("\n");
        System.out.println("nouveau nombre d'élève : ");
        int nbreEleves = sc.nextInt();
        String query = "update API_CLASSE set nbreeleves=? where idclasse = ?";
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
        System.out.println("id de la classe recherchée ");
        int idrech = sc.nextInt();
        String query = "delete from API_CLASSE where idclasse = ?";
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
        String query="select * from API_CLASSE";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int idClasse = rs.getInt(1);
                String sigle = rs.getString(5);
                String specialite = rs.getString(3);
                int annee = rs.getInt(2);
                int nbreEleves = rs.getInt(4);
                Classe cl = new Classe(idClasse,sigle,specialite,annee,nbreEleves);
                System.out.println(cl);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
    }
    public static void main(String[] args){
        gestionClasse g = new gestionClasse();
        g.gestion();
    }
}
