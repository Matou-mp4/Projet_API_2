package MVC.controller;

import MVC.Model.*;
import MVC.View.CoursAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.Comparator;
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
        l.sort(new Comparator<Cours>() {
            @Override
            public int compare(Cours c1, Cours c2) {
                return c1.getCode().compareTo(c2.getCode());
            }
        });
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
