package MVC.Model;
import Ecole.*;
import MVC.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOEnseignant extends Subject {
    public abstract Enseignant add(Enseignant elt) ;

    public abstract boolean remove( Enseignant elt) ;

    public abstract Enseignant update(Enseignant elt) ;

    public abstract Enseignant read(Enseignant rech) ;

    public abstract List<Enseignant> getAll() ;

    public abstract ArrayList<Infos> listerInfos(Enseignant c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Enseignant c,Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Enseignant c,Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Enseignant c,Cours co);

    @Override
    public List<Enseignant> getNotification() {
        return null;
    }
}
