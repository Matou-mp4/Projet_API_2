package MVC.Model;

import Ecole.*;

import java.util.ArrayList;

public interface DAOSpecialClasse {
    public abstract ArrayList<Infos> listerInfos(Classe c);
    public abstract int nbreHeuresTot(Classe c);
    public abstract ArrayList<EnseignantEtHeure> listeEnseignantsEtHeures(Classe c);
    public abstract ArrayList<SalleEtHeure> listeSallesEtHeures(Classe c);
    public abstract ArrayList<CoursEtHeure> listeCoursEtHeures(Classe c);
    public abstract Classe addCours(Classe c,Cours co, int heures);
    public abstract Classe modifCours(Classe c,Cours co, Enseignant e);
    public abstract Classe modifCours(Classe c,Cours co, Salle s);
    public abstract Classe modifCours(Classe c,Cours co, int heures);
    public abstract boolean suppCours(Classe c,Cours co);
    public abstract boolean salleCapaciteOK(Classe c,Salle salle);

}
