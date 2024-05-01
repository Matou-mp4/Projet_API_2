package MVC.Model;
import Ecole.*;
import MVC.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOInfos extends Subject {
    public abstract Infos add(Infos elt) ;

    public abstract boolean remove( Infos elt) ;

    public abstract Infos update(Infos elt) ;

    public abstract Infos read(Infos rech) ;

    public abstract List<Infos> getAll() ;

    public abstract ArrayList<Infos> listerInfos(Infos c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Infos c,Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Infos c,Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Infos c,Cours co);

    @Override
    public List<Infos> getNotification() {
        return null;
    }
}
