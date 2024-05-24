package MVC.controller;

import MVC.Model.*;
import MVC.View.ClasseAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClasseController {
    private DAO<Classe> model;
    private ClasseAbstractView view;

    public ClasseController(DAO<Classe> model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Classe> getAll(){
        List<Classe> l = model.getAll();
        l.sort(new Comparator<Classe>() {
            @Override
            public int compare(Classe o1, Classe o2) {
                return Integer.compare(o1.getIdClasse(),o2.getIdClasse());
            }
        });
        return l;
    }

    public Classe add( Classe elt) {
        Classe nelt = model.add(elt);
        return nelt;
    }
    public boolean remove(Classe elt) {
        return model.remove(elt);
    }
    public Classe update(Classe elt) {
        return model.update(elt);
    }

    public Classe read( int rech) {
        return  model.read(rech);
    }

}
