package MVC.Model;

import Ecole.Enseignant;
import Ecole.Salle;

import java.util.ArrayList;

public interface DAOSpecialSalle {
    public abstract ArrayList<Enseignant> ensSalleDefault(Salle salle);
}
