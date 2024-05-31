package MVC.controller;

import MVC.Model.*;
import MVC.View.ClasseAbstractView;
import Ecole.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClasseController{
    private DAO<Classe> model;
    private ClasseAbstractView view;
    private CoursController coursController;
    private SalleController salleController;
    private EnseignantController enseignantController;

    public ClasseController(DAO<Classe> model, ClasseAbstractView view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void setCoursController(CoursController coursController) {
        this.coursController = coursController;
    }
    public List<Cours> getCourss(){
        return coursController.getAll();
    }

    public void setSalleController(SalleController salleController) {
        this.salleController = salleController;
    }
    public List<Salle> getSalles(){
        return salleController.getAll();
    }

    public void setEnseignantController(EnseignantController enseignantController) {
        this.enseignantController = enseignantController;
    }

    public List<Enseignant> getEnseignants(){
        return enseignantController.getAll();
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

    public Classe read(int rech) {
        return  model.read(rech);
    }
    public int nbreHeuresTot(Classe c){
       return ((DAOSpecialClasse)model).nbreHeuresTot(c);
    }

    public ArrayList<EnseignantEtHeure> listeEnseignantsEtHeures(Classe c) {
        return ((DAOSpecialClasse)model).listeEnseignantsEtHeures(c);
    }

    public ArrayList<SalleEtHeure> listerSallesEtHeures(Classe c) {
        return ((DAOSpecialClasse)model).listeSallesEtHeures(c);
    }
    public ArrayList<CoursEtHeure> listerCoursEtHeurs(Classe c) {
        return ((DAOSpecialClasse)model).listeCoursEtHeures(c);
    }
    public Classe addCours(Classe c, Cours co, int heures) {
        return ((DAOSpecialClasse)model).addCours(c,co,heures);
    }
    public Classe modifCours(Classe c, Cours co, Enseignant e) {
        return ((DAOSpecialClasse)model).modifCours(c,co,e);
    }
    public Classe modifCours(Classe c, Cours co, Salle s) {
        return ((DAOSpecialClasse)model).modifCours(c,co,s);
    }
    public Classe modifCours(Classe c, Cours co, int heures) {
        return ((DAOSpecialClasse)model).modifCours(c,co,heures);
    }
    public boolean suppCours(Classe c, Cours co){
        return ((DAOSpecialClasse)model).suppCours(c,co);
    }
    public boolean salleCapaciteOK(Classe c, Salle salle) {
        return ((DAOSpecialClasse)model).salleCapaciteOK(c,salle);
    }
    public ArrayList<Infos> listerInfos(Classe c) {
        return ((DAOSpecialClasse)model).listerInfos(c);
    }
}
