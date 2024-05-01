package MVC.controller;

import MVC.Model.*;
import MVC.View.SalleAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class SalleController {
    private DAOSalle model;
    private SalleAbstractView view;

    public SalleController(DAOSalle model, SalleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Salle> getAll(){
        List<Salle> l = model.getAll();
        return l;
    }

    public Salle add( Salle elt) {
        Salle nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Salle elt) {
        return model.remove(elt);
    }
    public Salle update(Salle elt) {
        return model.update(elt);
    }

    public Salle search(Salle rech) {
        return  model.read(rech);
    }
    public ArrayList<Infos> listerinfos(Salle c) {
        return model.listerInfos(c);
    }

    public List<EnseignantEtHeure> listerLivre(Salle c, Enseignant en) {

        return model.listerEnseigant(c,en);
    }

    public List<CoursEtHeure> listerOuvrages(Salle c, Cours co) {
        return model.listerCours(c,co);
    }
    public List<SalleEtHeure> listerLivre(Salle c, Salle sa) {

        return model.listerSalles(c,sa);
    }

}
