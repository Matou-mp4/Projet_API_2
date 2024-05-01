package MVC.Model;
import Ecole.*;
import MVC.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOSalle extends Subject {
    public abstract Salle add(Salle elt) ;

    public abstract boolean remove( Salle elt) ;

    public abstract Salle update(Salle elt) ;

    public abstract Salle read(Salle rech) ;

    public abstract List<Salle> getAll() ;

    public abstract ArrayList<Infos> listerInfos(Salle c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Salle c,Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Salle c,Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Salle c,Cours co);

    @Override
    public List<Salle> getNotification() {
        return null;
    }
}
