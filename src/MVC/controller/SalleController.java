package MVC.controller;

import MVC.Model.*;
import MVC.View.SalleAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SalleController {
    private DAO<Salle> model;
    private SalleAbstractView view;
    private EnseignantController enseignantController;
    private InfosController infosController;
    private ClasseController classeController;

    public void setInfosController(InfosController infosController) {
        this.infosController = infosController;
    }
    public List<Infos> getInfos(){
        return infosController.getAll();
    }

    public void setClasseController(ClasseController classeController) {
        this.classeController = classeController;
    }
    public List<Classe> getClasses(){
        return classeController.getAll();
    }
    public ClasseController getClasseController(){
        return classeController;
    }

    public void setEnseignantController(EnseignantController enseignantController) {
        this.enseignantController = enseignantController;
    }

    public SalleController(DAO<Salle> model, SalleAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }
    public List<Salle> getAll(){
        List<Salle> l = model.getAll();
        l.sort(new Comparator<Salle>() {
            @Override
            public int compare(Salle s1, Salle s2) {
                return Integer.compare(s1.getSigle(),s2.getSigle());
            }
        });
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

    public ArrayList<Enseignant> ensSalleDefault(Salle salle){
        ArrayList<Enseignant> enseignants = ((ModelSalleDB)model).ensSalleDefault(salle);
        enseignants.sort(new Comparator<Enseignant>() {
            @Override
            public int compare(Enseignant e1, Enseignant e2) {
                return e1.getMatricule().compareTo(e2.getMatricule());
            }
        });
        return enseignants;
    }
}
