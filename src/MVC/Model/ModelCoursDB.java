package MVC.Model;

import Ecole.*;
import myConnectionDB.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelCoursDB extends DAO<Cours> implements DAOSpecialCours{
    protected Connection dbConnect;

    public ModelCoursDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Cours add(Cours elt) {
        String query1 = "insert into API_Cours(code,intitule) values(?,?)";
        String query2 = "select code from API_Cours where intitule= ?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, elt.getCode());
            pstm1.setString(2, elt.getIntitule());
            int n = pstm1.executeUpdate();
            System.out.println(n + " ligne insérée");
            return elt;
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }

    @Override
    public boolean remove(Cours elt) {
        String query = "delete from API_Cours where code = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, elt.getCode());
            int n = pstm.executeUpdate();
            if (n != 0) {
                System.out.println(n + "ligne supprimée");
                return true;
            } else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return false;
    }

    @Override
    public Cours update(Cours elt) {
        String query = "update API_Cours set intitule=? where code = ?";
        System.out.println(elt.getCode()+" "+elt.getIntitule());
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, elt.getIntitule());
            pstm.setString(2, elt.getCode());
            int n = pstm.executeUpdate();
            if (n != 0) {
                System.out.println(n + "ligne mise à jour");
                return elt;
            } else System.out.println("record introuvable");

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }

    @Override
    public Cours read(int rech) {
        return null;
    }

    @Override
    public Cours read(String code) {
        String query = "select * from API_Cours where code = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, code);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String intitule = rs.getString(2);
                Cours classe = new Cours(code, intitule);
                System.out.println(classe);
                return classe;
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }

    @Override
    public List<Cours> getAll() {
        ArrayList<Cours> lCours = new ArrayList<>();
        String query = "select * from API_Cours";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String code = rs.getString(1);
                String intitule = rs.getString(2);
                Cours cours = new Cours(code, intitule);
                lCours.add(cours);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return lCours;
    }
    @Override
    public int getNombreHeure(Cours cours){
        String query = "select sum(nbreheures) from API_Infos where code = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, cours.getCode());
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return 0;
    }

}
