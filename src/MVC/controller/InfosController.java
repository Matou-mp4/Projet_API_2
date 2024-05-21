package MVC.controller;

import MVC.Model.*;
import MVC.View.InfosAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class InfosController {
    private DAO<Infos> model;
    private InfosAbstractView view;

    public InfosController(DAO<Infos> model, InfosAbstractView view) {
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

    public Infos read(int rech) {
        return  model.read(rech);
    }

}
