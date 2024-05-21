package MVC.controller;

import MVC.Model.*;
import MVC.View.CoursAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class CoursController {
    private DAO<Cours> model;
    private CoursAbstractView view;

    public CoursController(DAO<Cours> model, CoursAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Cours> getAll(){
        List<Cours> l = model.getAll();
        return l;
    }

    public Cours add(Cours elt) {
        Cours nelt = model.add(elt);
        return nelt;
    }
    public boolean remove(Cours elt) {
        return model.remove(elt);
    }
    public Cours update(Cours elt) {
        return model.update(elt);
    }
    public Cours read(String code) {
        return model.read(code);
    }
}
