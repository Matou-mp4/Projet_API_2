package MVC.Model;
import Ecole.*;
import MVC.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOClasse extends Subject {
    public abstract Classe add(Classe elt) ;

    public abstract boolean remove( Classe elt) ;

    public abstract Classe update(Classe elt) ;

    public abstract Classe read(Classe rech) ;

    public abstract List<Classe> getAll() ;

    public abstract ArrayList<Infos> listerInfos(Classe c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Classe c,Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Classe c,Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Classe c,Cours co);

    @Override
    public List<Classe> getNotification() {
        return null;
    }
}
