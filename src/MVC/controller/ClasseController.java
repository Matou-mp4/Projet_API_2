package MVC.controller;

import MVC.Model.*;
import MVC.View.ClasseAbstractView;
import Class.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClasseController {
    private DAOClasse model;
    private ClasseAbstractView view;

    public ClasseController(DAOClasse model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Classe> getAll(){
        List<Classe> l = model.getAll();
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

    public Classe search(Classe rech) {
        return  model.read(rech);
    }
    public ArrayList<Infos> listerinfos(Classe c) {
        return model.listerInfos(c);
    }

    public List<EnseignantEtHeure> listerLivre(Classe c, Enseignant en) {

        return model.listerEnseigant(c,en);
    }

    public List<CoursEtHeure> listerOuvrages(Classe c, Cours co) {
        return model.listerCours(c,co);
    }
    public List<SalleEtHeure> listerLivre(Classe c, Salle sa) {

        return model.listerSalles(c,sa);
    }

}
