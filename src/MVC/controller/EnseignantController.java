package MVC.controller;

import MVC.Model.*;
import MVC.View.EnseignantAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class EnseignantController {
    private DAOEnseignant model;
    private EnseignantAbstractView view;

    public EnseignantController(DAOEnseignant model, EnseignantAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Enseignant> getAll(){
        List<Enseignant> l = model.getAll();
        return l;
    }

    public Enseignant add( Enseignant elt) {
        Enseignant nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Enseignant elt) {
        return model.remove(elt);
    }
    public Enseignant update(Enseignant elt) {
        return model.update(elt);
    }

    public Enseignant search(Enseignant rech) {
        return  model.read(rech);
    }
    public ArrayList<Infos> listerinfos(Enseignant c) {
        return model.listerInfos(c);
    }

    public List<EnseignantEtHeure> listerLivre(Enseignant c, Enseignant en) {

        return model.listerEnseigant(c,en);
    }

    public List<CoursEtHeure> listerOuvrages(Enseignant c, Cours co) {
        return model.listerCours(c,co);
    }
    public List<SalleEtHeure> listerLivre(Enseignant c, Salle sa) {

        return model.listerSalles(c,sa);
    }

}
