package MVC.controller;

import MVC.Model.*;
import MVC.View.EnseignantAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class EnseignantController {
    private DAO<Enseignant> model;
    private EnseignantAbstractView view;

    public EnseignantController(DAO<Enseignant> model, EnseignantAbstractView view) {
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
    public Enseignant read(String matricule) {
        return model.read(matricule);
    }
}
