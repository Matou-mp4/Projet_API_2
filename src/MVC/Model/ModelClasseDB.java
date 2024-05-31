package MVC.Model;
import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        String query2 = "select idclasse from API_CLASSE where annee= ? and sigle =? order by idclasse";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
            PreparedStatement pstm2= dbConnect.prepareStatement(query2)
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
    public int nbreHeuresTot(Classe c){
        return c.nbreHeuresTot();
    }

    @Override
    public ArrayList<EnseignantEtHeure> listeEnseignantsEtHeures(Classe c) {
       return c.listeEnseignantsEtHeures();
    }

    @Override
    public ArrayList<SalleEtHeure> listeSallesEtHeures(Classe c) {
        return c.listeSallesEtHeures();
    }

    @Override
    public ArrayList<CoursEtHeure> listeCoursEtHeures(Classe c) {
        return c.listeCoursEtHeures();
    }

    @Override
    public Classe addCours(Classe c, Cours co, int heures) {
        c.addCours(co,heures);
        String query="insert into api_infos(idclasse,code,matricule,sigle,nbreheures) values(?,?,?,?,?)";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query);
        ){
            pstm1.setInt(1,c.getIdClasse());
            pstm1.setString(2,co.getCode() );
            pstm1.setString(3,"x");
            pstm1.setInt(4,0);
            pstm1.setInt(5,heures);
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return c;
    }
    // Les elements ajoutes dans la table api_infos ne pouvant pas avoir de valeur null, le matricule aura x en valeur automatique et sigle aura 0

    @Override
    public Classe modifCours(Classe c, Cours co, Enseignant e) {
        c.modifCours(co,e);
        String query = "update API_INFOS  set enseignant=? where idclasse = ? and code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1,e.getMatricule());
            pstm.setInt(2,c.getIdClasse());
            pstm.setString(3,co.getCode());
            int n = pstm.executeUpdate();
            if(n!=0){
                System.out.println(n+ "ligne mise à jour");
                return c;
            }
            else System.out.println("record introuvable");
        } catch (SQLException ex) {
            System.out.println("erreur sql :" + ex);
        }
        return null;
    }

    @Override
    public Classe modifCours(Classe c, Cours co, Salle s) {
        c.modifCours(co,s);
        String query = "update API_INFOS  set sigle=? where idclasse = ? and code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,s.getSigle());
            pstm.setInt(2,c.getIdClasse());
            pstm.setString(3,co.getCode());
            int n = pstm.executeUpdate();
            if(n!=0){
                System.out.println(n+ "ligne mise à jour");
                return c;
            }
            else System.out.println("record introuvable");
        } catch (SQLException ex) {
            System.out.println("erreur sql :" + ex);
        }
        return null;
    }

    @Override
    public Classe modifCours(Classe c, Cours co, int heures) {
        c.modifCours(co,heures);
        String query = "update API_INFOS  set nbreheures=? where idclasse = ? and code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,heures);
            pstm.setInt(2,c.getIdClasse());
            pstm.setString(3,co.getCode());
            int n = pstm.executeUpdate();
            if(n!=0){
                System.out.println(n+ "ligne mise à jour");
                return c;
            }
            else System.out.println("record introuvable");
        } catch (SQLException ex) {
            System.out.println("erreur sql :" + ex);
        }
        return null;
    }

    @Override
    public boolean suppCours(Classe c, Cours co){
        String query = "delete from API_INFOS where idclasse = ? and code = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,c.getIdClasse());
            pstm.setString(2,co.getCode());
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
    public boolean salleCapaciteOK(Classe c, Salle salle) {
        return c.salleCapaciteOK(salle);
    }
    @Override
    public ArrayList<Infos> listerInfos(Classe c) {
        return c.getListeInfos();
    }
}
