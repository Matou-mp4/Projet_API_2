package MVC.controller;

import MVC.Model.*;
import MVC.View.InfosAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InfosController {
    private DAO<Infos> model;
    private InfosAbstractView view;
    private SalleController salleController;
    private ClasseController classeController;
    private CoursController coursController;
    private EnseignantController enseignantController;

    public InfosController(DAO<Infos> model, InfosAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Salle> getSalles(){
        return salleController.getAll();
    }
    public List<Classe> getClasses(){
        return classeController.getAll();
    }
    public List<Cours> getCourss(){
        return coursController.getAll();
    }
    public List<Enseignant> getEnseignants(){
        return enseignantController.getAll();
    }
    public List<Infos> getAll(){
        List<Infos> l = model.getAll();
        l.sort(new Comparator<Infos>() {
            @Override
            public int compare(Infos i1, Infos i2) {
                return Integer.compare(i1.getIdInfos(),i2.getIdInfos());
            }
        });
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
        Infos infos = model.read(rech);
        infos.setClasse(classeController.read(infos.getClasse().getIdClasse()));
        infos.setSalle(salleController.read(infos.getSalle().getSigle()));
        infos.setEnseignant(enseignantController.read(infos.getEnseignant().getMatricule()));
        infos.setCours(coursController.read(infos.getCours().getCode()));
        return infos;
    }


}
