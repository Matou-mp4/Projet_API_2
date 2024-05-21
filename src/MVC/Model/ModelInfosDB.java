package MVC.Model;
import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelInfosDB extends DAO<Infos> {
    protected Connection dbConnect;

    public ModelSalleDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
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
    public Infos add(Infos elt) {
        String query1 = "insert into API_Infos(idclasse,code,matricule,sigle,nbreheures) values(?,?,?,?,?)";
        String query2 = "select idInfos from API_Infos where idclasse= ? and sigle =? and code=? and matricule = ? ";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setInt(1,elt.getClasse().getIdClasse());
            pstm1.setString(2,elt.getCours().getCode());
            pstm1.setString(3,elt.getEnseignant().getMatricule());
            pstm1.setInt(4,elt.getSalle().getSigle());
            pstm1.setInt(5,elt.getNbreHeures());

            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
            if(n==1){
                pstm2.setInt(1,elt.getClasse().getIdClasse());
                pstm2.setInt(2,elt.getSalle().getSigle());
                pstm2.setString(3,elt.getCours().getCode());
                pstm2.setString(4,elt.getEnseignant().getMatricule());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idInfos= rs.getInt(1);
                    System.out.println("idInfos= "+idInfos);
                    elt.setIdInfos(idInfos);
                    return elt;
                }
                else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public boolean remove(Infos elt) {
        String query = "delete from API_Infos where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getIdInfos());
            int n = pstm.executeUpdate();
            if(n!=0) {
                System.out.println(n+ "ligne supprimée");
                return true;
            }
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return false;
    }

    @Override
    public Infos update(Infos elt) {
        String query = "update API_Infos set idclasse=?,code=?,matricule=?,sigle=?,nbreheures=? where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getClasse().getIdClasse());
            pstm.setString(2,elt.getCours().getCode());
            pstm.setString(3,elt.getEnseignant().getMatricule());
            pstm.setInt(4,elt.getSalle().getSigle());
            pstm.setInt(5,elt.getNbreHeures());
            int n = pstm.executeUpdate();
            if(n!=0){
                System.out.println(n+ "ligne mise à jour");
                return elt;
            }
            else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }

    @Override
    public Infos read(int rech) {
        String query = "select * from API_Infos where idInfos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,rech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int idClasse = rs.getInt(1);
                String code = rs.getString(2);
                String matricule = rs.getString(3);
                int sigle = rs.getInt(4);
                int nbreHeures = rs.getInt(5);
                //todo: creer une infos
                Infos infos = new Infos();
                return infos;
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public Infos read(String rech) {
        return null;
    }
    @Override
    public List<Infos> getAll() {
        List<Infos> lInfos = new ArrayList<>();
        String query="select * from API_Infos";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int idClasse = rs.getInt(1);
                String code = rs.getString(2);
                String matricule = rs.getString(3);
                int sigle = rs.getInt(4);
                int nbreHeures = rs.getInt(5);
                int idInfos = rs.getInt(6);
                //todo: creer une infos
                Infos infos = new Infos();
                lInfos.add(infos);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return lInfos;
    }

}
