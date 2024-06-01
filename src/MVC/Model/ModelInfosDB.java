package MVC.Model;
import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelInfosDB extends DAO<Infos> {
    protected Connection dbConnect;

    public ModelInfosDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }
    @Override
    public Infos add(Infos elt) {
        String query1 = "insert into API_Infos(idclasse,code,matricule,sigle,nbreheures) values(?,?,?,?,?)";
        String query2 = "select idInfos from API_Infos where idclasse= ? and sigle =? and code=? and matricule = ? ";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
        ){
            pstm1.setInt(1,elt.getClasse().getIdClasse());
            pstm1.setString(2,elt.getCours().getCode());
            pstm1.setString(3,elt.getEnseignant().getMatricule());
            pstm1.setInt(4,elt.getSalle().getSigle());
            pstm1.setInt(5,elt.getNbreHeures());

            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public boolean remove(Infos elt) {
        String query = "delete from API_Infos where id_Infos = ?";
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
        String query = "update API_Infos set idclasse=?,code=?,matricule=?,sigle=?,nbreheures=? where id_Infos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getClasse().getIdClasse());
            pstm.setString(2,elt.getCours().getCode());
            pstm.setString(3,elt.getEnseignant().getMatricule());
            pstm.setInt(4,elt.getSalle().getSigle());
            pstm.setInt(5,elt.getNbreHeures());
            pstm.setInt(6,elt.getIdInfos());
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
        String query = "select * from API_Infos where id_Infos = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,rech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int idClasse = rs.getInt(1); // classe
                Classe classe = new Classe(idClasse,null,null,0,0);
                String code = rs.getString(2); // cours
                Cours cours = new Cours(code,null);
                String matricule = rs.getString(3); // ens
                Enseignant enseignant = new Enseignant(matricule,null,null,null,0,null,null,null);
                int sigle = rs.getInt(4); // salle
                Salle salle = new Salle(sigle,0);
                int nbreHeures = rs.getInt(5);
                Infos infos = new Infos(nbreHeures,cours,enseignant,salle,classe);
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
                int idClasse = rs.getInt(1); // classe
                Classe classe = new Classe(idClasse,null,null,0,0);
                String code = rs.getString(2); // cours
                Cours cours = new Cours(code,null);
                String matricule = rs.getString(3); // ens
                Enseignant enseignant = new Enseignant(matricule,null,null,null,0,null,null,null);
                int sigle = rs.getInt(4); // salle
                Salle salle = new Salle(sigle,0);
                int nbreHeures = rs.getInt(5);
                int idInfos = rs.getInt(6);
                Infos infos = new Infos(nbreHeures,idInfos,cours,enseignant,salle,classe);
                lInfos.add(infos);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return lInfos;
    }

}
