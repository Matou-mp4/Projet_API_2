package MVC.Model;

import Ecole.*;
import MVC.controller.EnseignantController;
import myConnectionDB.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelEnseignantDB extends DAO<Enseignant> {
    protected Connection dbConnect;

    public ModelEnseignantDB() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion");
            System.exit(1);
        }
    }

    @Override
    public Enseignant add(Enseignant elt) {
        String query1 = "insert into API_Enseignant(matricule,nom,prenom,tel,chargesem,salairemensu,dateengag,sigle) values(?,?,?,?,?,?,?,?)";
        String query2 = "select matricule from API_Enseignant where nom = ? and  prenom=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
             PreparedStatement pstm2 = dbConnect.prepareStatement(query2);
        ) {
            pstm1.setString(1, elt.getMatricule());
            pstm1.setString(2, elt.getNom());
            pstm1.setString(3, elt.getPrenom());
            pstm1.setString(4, elt.getTel());
            pstm1.setInt(5, elt.getChargeSem());
            pstm1.setBigDecimal(6, elt.getSalaireMensu());
            pstm1.setDate(7, Date.valueOf(elt.getDateEngag()));
            pstm1.setInt(8, elt.getPreference().getSigle());
            int n = pstm1.executeUpdate();
            System.out.println(n + " ligne insérée");
            if (n == 1) {
                pstm2.setString(1, elt.getNom());
                pstm2.setString(2, elt.getPrenom());
                ResultSet rs = pstm2.executeQuery();
                if (rs.next()) {
                    String mat = rs.getString(1);
                    System.out.println("matricule = " + mat);
                    return elt;
                } else System.out.println("record introuvable");
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }


    @Override
    public boolean remove(Enseignant elt) {
        String query = "delete from API_Enseignant where  matricule= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, elt.getMatricule());
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
    public Enseignant update(Enseignant elt) {
        String query = "update API_Enseignant set nom=?,prenom=?,tel=?,chargesem=?,salairemensu=?,dateengag=?,sigle=? where matricule= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, elt.getNom());
            pstm.setString(2, elt.getPrenom());
            pstm.setString(3, elt.getTel());
            pstm.setInt(4, elt.getChargeSem());
            pstm.setBigDecimal(5, elt.getSalaireMensu());
            pstm.setDate(6, Date.valueOf(elt.getDateEngag()));
            pstm.setInt(7, elt.getPreference().getSigle());
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
    public Enseignant read(int rech) {
        return null;
    }

    @Override
    public Enseignant read(String rech) {
        String query = "select * from API_Enseignant where  matricule = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, rech);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String tel = rs.getString(4);
                int chargesem = rs.getInt(5);
                BigDecimal salaireMensu = BigDecimal.valueOf(rs.getFloat(6));
                LocalDate date = rs.getDate(7).toLocalDate();
                int sigle = rs.getInt(8);
                Salle salle = new Salle(sigle);
                Enseignant enseignant = new Enseignant(rech, nom, prenom, tel, chargesem, salaireMensu, date, salle);
                return enseignant;
            } else System.out.println("record introuvable");
        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return null;
    }


    @Override
    public List<Enseignant> getAll() {
        List<Enseignant> enseignants = new ArrayList<>();
        String query = "select * from API_Enseignant";
        try (Statement stm = dbConnect.createStatement()) {
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String matricule = rs.getString(1);
                String nom = rs.getString(2);
                String prenom = rs.getString(3);
                String tel = rs.getString(4);
                int chargeSem = rs.getInt(5);
                BigDecimal salairemensu = rs.getBigDecimal(6);
                LocalDate dateengag = rs.getDate(7).toLocalDate();
                int sigle = rs.getInt(8);
                Salle salle = new Salle(sigle);
                Enseignant enseignant = new Enseignant(matricule, nom, prenom, tel, chargeSem, salairemensu, dateengag, salle);
                enseignants.add(enseignant);
            }

        } catch (SQLException e) {
            System.out.println("erreur sql :" + e);
        }
        return enseignants;
    }

}
