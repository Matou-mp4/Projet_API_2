package MVC.Model;
import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//todo: supprimmer l'implementation
public class ModelClasseDB extends DAO<Classe> implements DAOSpecialClasse{
    protected Connection dbConnect;
    public ModelClasseDB(){
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }
    @Override
    public Classe add(Classe elt) {
        String query1 = "insert into API_CLASSE(annee,sigle,specialite,nbreeleves) values(?,?,?,?)";
        String query2 = "select idclasse from API_CLASSE where annee= ? and sigle =?";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2);
        ){
            pstm1.setInt(1,elt.getAnnee());
            pstm1.setString(2, elt.getSigle());
            pstm1.setString(3,elt.getSpecialite());
            pstm1.setInt(4,elt.getNbreEleves());
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
            notifyObservers();
            if(n==1){
                pstm2.setInt(1,elt.getAnnee());
                pstm2.setString(2,elt.getSigle());
                ResultSet rs= pstm2.executeQuery();
                if(rs.next()){
                    int idClasse= rs.getInt(1);
                    System.out.println("idclasse = "+idClasse);
                    elt.setIdClasse(idClasse);
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
    public boolean remove(Classe elt) {
        String query = "delete from API_CLASSE where idclasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getIdClasse());
            int n = pstm.executeUpdate();
            if(n!=0){
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
    public Classe update(Classe elt) {
        String query = "update API_CLASSE set annee=? , sigle = ?, specialite = ?, nbreeleves = ? where idclasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getAnnee());
            pstm.setString(2,elt.getSigle());
            pstm.setString(3,elt.getSpecialite());
            pstm.setInt(4,elt.getNbreEleves());
            pstm.setInt(5,elt.getIdClasse());
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
    public Classe read(int idClasse) {
        String query = "select * from API_CLASSE where idClasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,idClasse);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int annee = rs.getInt(2);
                String sigle = rs.getString(5);
                int nbreEleves = rs.getInt(4);
                String specialite = rs.getString(3);
                Classe cl = new Classe(idClasse,sigle,specialite,annee,nbreEleves);
                System.out.println(cl);
                return cl;
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public Classe read(String rech) {
        return null;
    }

    @Override
    public List<Classe> getAll() {
        ArrayList<Classe> classes = new ArrayList<>();
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
                classes.add(cl);
            }
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return classes;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Classe c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Classe c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Classe c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Classe c) {
        return null;
    }
}
