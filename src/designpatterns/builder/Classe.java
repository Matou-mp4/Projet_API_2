package designpatterns.builder;

import Ecole.CoursEtHeure;
import Ecole.EnseignantEtHeure;
import Ecole.Infos;
import Ecole.SalleEtHeure;

import java.util.ArrayList;

public class Classe {
    /**
     * le sigle et la specialité unique de la classe
     */
    protected String sigle, specialite;
    /**
     * l'id, l'annee et le nombre de l'élève de la classe
     */
    protected int idClasse, annee, nbreEleves;
    /**
     * Liste d'informations de la classe
     * Chaque infos contient :
     * - l'enseignant
     * - le cours
     * - la salle
     * - le nombre d'heures
     */
    protected ArrayList<Infos> listeInfos = new ArrayList<>();
    /**
     * Liste des enseignants et du nombre d'heures
     */
    protected ArrayList<EnseignantEtHeure> listeEnseigantEtHeure = new ArrayList<>();
    /**
     * Liste des cours et du nombre d'heures
     */
    protected ArrayList<CoursEtHeure> listeCoursEtHeure = new ArrayList<>();
    /**
     * Liste des salles et du nombre d'heures
     */
    protected ArrayList<SalleEtHeure> listeSalleEtHeure = new ArrayList<>();
    private Classe(ClasseBuilder cb){
        this.annee=cb.annee;
        this.idClasse=cb.idClasse;
        this.nbreEleves=cb.nbreEleves;
        this.sigle=cb.sigle;
        this.specialite=cb.specialite;

    }
}
