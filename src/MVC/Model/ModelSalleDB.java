package MVC.Model;
import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelSalleDB extends DAO<Salle> {
    protected Connection dbConnect;

    public ModelSalleDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }
    @Override
    public Salle add(Salle elt) {
        String query1 = "insert into API_Salle(sigle,capacite) values(?,?)";
        try(PreparedStatement pstm1= dbConnect.prepareStatement(query1);
        ){
            pstm1.setInt(1, elt.getSigle());
            pstm1.setInt(2,elt.getCapacite());
            int n = pstm1.executeUpdate();
            System.out.println(n+" ligne insérée");
            return elt;
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public boolean remove(Salle elt) {
        String query = "delete from API_Salle where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, elt.getSigle());
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
    public Salle update(Salle elt) {
        String query = "update API_Salle set capacite=? where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,elt.getCapacite());
            pstm.setInt(2, elt.getSigle());
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
    public Salle read(String rech) {
        return null;
    }

    @Override
    public Salle read(int rech) {
        String query = "select * from API_Salle where sigle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1,rech);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                int capacite = rs.getInt(2);
                Salle salle = new Salle(rech,capacite);
                System.out.println(salle);
                return salle;
            }
            else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return null;
    }

    @Override
    public List<Salle> getAll() {
        List<Salle> salles = new ArrayList<>();
        String query="select * from API_Salle";
        try(Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                int sigle = rs.getInt(1);
                int capacite = rs.getInt(2);
                Salle salle = new Salle(sigle,capacite);
                salles.add(salle);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :"+e);
        }
        return salles;
    }

}
