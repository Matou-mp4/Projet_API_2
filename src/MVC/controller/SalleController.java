package MVC.controller;

import MVC.Model.*;
import MVC.View.SalleAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class SalleController {
    private DAO<Salle> model;
    private SalleAbstractView view;

    public SalleController(DAO<Salle> model, SalleAbstractView view) {
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

    public Salle read(int rech) {
        return  model.read(rech);
    }


}
