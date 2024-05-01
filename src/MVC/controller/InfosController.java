package MVC.controller;

import MVC.Model.*;
import MVC.View.InfosAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class InfosController {
    private DAOInfos model;
    private InfosAbstractView view;

    public InfosController(DAOInfos model, InfosAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Infos> getAll(){
        List<Infos> l = model.getAll();
        return l;
    }

    public Infos add( Infos elt) {
        Infos nelt = model.add(elt);
        return nelt;
    }


    public boolean remove(Infos elt) {
        return model.remove(elt);
    }
    public Infos update(Infos elt) {
        return model.update(elt);
    }

    public Infos search(Infos rech) {
        return  model.read(rech);
    }
    public ArrayList<Infos> listerinfos(Infos c) {
        return model.listerInfos(c);
    }

    public List<EnseignantEtHeure> listerLivre(Infos c, Enseignant en) {

        return model.listerEnseigant(c,en);
    }

    public List<CoursEtHeure> listerOuvrages(Infos c, Cours co) {
        return model.listerCours(c,co);
    }
    public List<SalleEtHeure> listerLivre(Infos c, Salle sa) {

        return model.listerSalles(c,sa);
    }

}
