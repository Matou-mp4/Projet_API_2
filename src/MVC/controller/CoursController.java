package MVC.controller;

import MVC.Model.*;
import MVC.View.CoursAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class CoursController {
    private DAOCours model;
    private CoursAbstractView view;

    public CoursController(DAOCours model, CoursAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Cours> getAll(){
        List<Cours> l = model.getAll();
        return l;
    }

    public Cours add( Cours elt) {
        Cours nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Cours elt) {
        return model.remove(elt);
    }
    public Cours update(Cours elt) {
        return model.update(elt);
    }

    public Cours search(Cours rech) {
        return  model.read(rech);
    }
    public ArrayList<Infos> listerinfos(Cours c) {
        return model.listerInfos(c);
    }

    public List<EnseignantEtHeure> listerLivre(Cours c, Enseignant en) {

        return model.listerEnseigant(c,en);
    }

    public List<CoursEtHeure> listerOuvrages(Cours c, Cours co) {
        return model.listerCours(c,co);
    }
    public List<SalleEtHeure> listerLivre(Cours c, Salle sa) {

        return model.listerSalles(c,sa);
    }

}
