package MVC.Model;
import Ecole.*;
import MVC.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOCours extends Subject {
    public abstract Cours add(Cours elt) ;

    public abstract boolean remove( Cours elt) ;

    public abstract Cours update(Cours elt) ;

    public abstract Cours read(Cours rech) ;

    public abstract List<Cours> getAll() ;

    public abstract ArrayList<Infos> listerInfos(Cours c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Cours c,Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Cours c,Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Cours c,Cours co);

    @Override
    public List<Cours> getNotification() {
        return null;
    }
}
