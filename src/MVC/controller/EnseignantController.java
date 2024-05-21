package MVC.controller;

import MVC.Model.*;
import MVC.View.EnseignantAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class EnseignantController {
    private DAO<Enseignant> model;
    private EnseignantAbstractView view;
    private SalleController salleController;

    public EnseignantController(DAO<Enseignant> model, EnseignantAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void setSalleController(SalleController salleController) {
        this.salleController = salleController;
    }
    public List<Salle> getSalles(){
        return salleController.getAll();
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
        Enseignant enseignant = model.read(matricule);
        enseignant.setPreference(salleController.read(enseignant.getPreference().getSigle()));
        return enseignant;
    }

}
