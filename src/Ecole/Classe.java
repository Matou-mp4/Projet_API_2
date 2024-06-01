package Ecole;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Class.Classe Class.Classe
 *
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Classe {
    /**
     * le sigle et la specialité unique de la classe
     */
    protected String sigle, specialite;
    /**
     * l'id, l'annee et le nombre de l'élève de la classe
     */
    protected Integer idClasse, annee, nbreEleves;
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

    /**
     * Constructeur paramétré de la classe
     *
     * @param sigle      Sigle de la classe
     * @param specialite Spécialité de la classe
     * @param annee      Année de la classe
     * @param nbreEleves Le nombre d'élèves dans la classe
     */
    public Classe(int idClasse,String sigle, String specialite, int annee, int nbreEleves) {
        this.idClasse=idClasse;
        this.sigle = sigle;
        this.specialite = specialite;
        this.annee = annee;
        this.nbreEleves = nbreEleves;
    }

    public Classe(int annee, String sigle, String specialite, int nbreEleves) {
        this.annee=annee;
        this.sigle=sigle;
        this.specialite=specialite;
        this.nbreEleves=nbreEleves;
    }


    /**
     * fonction verifiant si la liste des infos n'est pas vide
     *
     * @return Booléen vrai si la liste contient au moins une info, faux dans le cas contraire
     */
    public boolean listeInfosVerif() {
        int longueur = listeInfos.size();
        if (longueur == 0) {
            System.out.println("Erreur, aucune information présente dans la liste infos");
            return false;
        } else {
            return true;
        }
    }

    /**
     * fonction calculant le nombre d'heures total puis l'affiche.
     */
    public int nbreHeuresTot() {
        int cptHeures = 0;
        if (listeInfosVerif()) {
            for (Infos element : listeInfos) {
                cptHeures = cptHeures + element.getNbreHeures();
            }
            System.out.println("Nombre d'heures total : " + cptHeures + ".");
        }
        return cptHeures;
    }

    /**
     * Fonction mettant à jour la liste d'enseigants et de nombre d'heures en parcourant la liste des informations.
     * Si un enseignant existe déjà dans la liste d'enseignants et de nombre d'heures, la fonction ajoute le nombre d'heures associées
     * à cet enseignant. Sinon, elle crée une nouvelle entrée pour l'enseignant avec le nombre d'heures spécifié.
     */
    public ArrayList<EnseignantEtHeure> listeEnseignantsEtHeures() {
        EnseignantEtHeure ajout = new EnseignantEtHeure();
        //verifier si la liste n'est pas vide
        if (listeInfosVerif()) {
            for (Infos element : listeInfos) {
                ajout.setEnseignant(element.enseignant);
                ajout.setNbreHeures(element.nbreHeures);
                boolean flag = false;
                for (EnseignantEtHeure eH : listeEnseigantEtHeure) {
                    if (element.enseignant.equals(eH.enseignant)) {
                        eH.setNbreHeures(eH.nbreHeures + element.nbreHeures);
                        flag = true;
                    }
                }
                if (!flag) {
                    listeEnseigantEtHeure.add(ajout);
                }
            }
        }
        return listeEnseigantEtHeure;
    }

    /**
     * Fonction mettant à jour la liste des salles et de nombre d'heures en parcourant la liste des informations.
     * Si une salle existe déjà dans la liste des salles et de nombre d'heures, la fonction ajoute le nombre d'heures associées
     * à cette salle. Sinon, elle crée une nouvelle entrée pour la salle avec le nombre d'heures spécifié.
     */
    public ArrayList<SalleEtHeure> listeSallesEtHeures() {
        SalleEtHeure ajout = new SalleEtHeure();
        if (listeInfosVerif()) {
            for (Infos element : listeInfos) {
                ajout.setSalle(element.salle);
                ajout.setNbreHeures(element.nbreHeures);
                boolean flag = false;
                for (SalleEtHeure sH : listeSalleEtHeure) {
                    if (element.salle.equals(sH.salle)) {
                        sH.setNbreHeures(sH.nbreHeures + element.nbreHeures);
                        flag = true;
                    }
                }
                if (!flag) {
                    listeSalleEtHeure.add(ajout);
                }
            }
        }
        return listeSalleEtHeure;
    }

    /**
     * Fonction mettant à jour la liste des cours et de nombre d'heures en parcourant la liste des informations.
     * Si un cours existe déjà dans la liste des cours et de nombre d'heures, la fonction ajoute le nombre d'heures associées
     * à ce cours. Sinon, elle crée une nouvelle entrée pour le cours avec le nombre d'heures spécifié.
     */
    public ArrayList<CoursEtHeure> listeCoursEtHeures() {
        CoursEtHeure ajout = new CoursEtHeure();
        if (listeInfosVerif()) {
            for (Infos element : listeInfos) {
                ajout.setCours(element.cours);
                ajout.setNbreHeures(element.nbreHeures);
                boolean flag = false;
                for (CoursEtHeure cH : listeCoursEtHeure) {
                    if (element.cours.equals(cH.cours)) {
                        cH.setNbreHeures(cH.nbreHeures + element.nbreHeures);
                        flag = true;
                    }
                }
                if (!flag) {
                    listeCoursEtHeure.add(ajout);
                }
            }
        }
        return listeCoursEtHeure;
    }

    /**
     * fonction permettant l'ajout d'un cours et de son nombre d'heures dans la liste des informations
     *
     * @param c      cours à ajouter
     * @param heures nombre d'heures du cours
     */
    public void addCours(Cours c, int heures) {
        listeInfos.add(new Infos(c, heures));
    }

    /**
     * Fonction permettant de modifier l'enseignant donnant un cours présant dans la liste des informations.
     * La fonction parcourt la listeInfos et lorsqu'elle trouve le cours envoyé en paramètre,
     * elle effectue la modification.
     *
     * @param c cours envoyé en paramètre afin de determiner l'emplacement de la modification
     * @param e enseignant qui prendra la place de l'ancien
     */
    public void modifCours(Cours c, Enseignant e) {
        for (Infos element : listeInfos) {
            if (element.getCours().equals(c)) {
                element.setEnseignant(e);
                break;
            }
        }
    }

    /**
     * Fonction permettant de modifier la salle présente dans la liste des informations.
     * La fonction parcourt la listeInfos et lorsqu'elle trouve le cours envoyé en paramètre,
     * elle effectue la modification.
     *
     * @param c cours envoyé en paramètre afin de determiner l'emplacement de la modification
     * @param s salle qui prendra la place de l'anciene
     */
    public void modifCours(Cours c, Salle s) {
        for (Infos element : listeInfos) {
            if (element.getCours().equals(c)) {
                element.setSalle(s);
                break;
            }
        }
    }

    /**
     * Fonction permettant de modifier le nombre d'heures présentes dans la liste des informations.
     * La fonction parcourt la listeInfos et lorsqu'elle trouve le cours envoyé en paramètre,
     * elle effectue la modification.
     *
     * @param c      cours envoyé en paramètre afin de determiner l'emplacement de la modification
     * @param heures heures qui prendront la place des anciennes
     */
    public void modifCours(Cours c, int heures) {
        for (Infos element : listeInfos) {
            if (element.getCours().equals(c)) {
                element.setNbreHeures(heures);
                break;
            }
        }
    }

    /**
     * Fonction permettant de supprimer un element de la liste des informations à partir d'un cours envoyé en paramètre.
     * La fonction parcourt la liste des informations afin de se placer où se trouve le cours, puis supprime l'information.
     *
     * @param c cours à supprimer
     */
    public void suppCours(Cours c) {
        listeInfos.removeIf(element -> (element.getCours()).equals(c));
        /*
        for (Class.Infos element : listeInfos){
            if((element.getCours()).equals(c)){
                listeInfos.remove(element);
                System.out.println("Class.Cours "+ c.getIntitule+" supprimé");
            }
        }
        */
        /*
         * 2 methodes :
         * - methode removeIf : ergonomique en une ligne (proposée par intelliji)
         * - methode forEach : permet d'afficher si la suppression est faite
         * */
    }

    /**
     * Fonction vérifiant si le nombre d'élève de la classe est inférieur ou égale a la capacité de cette dernière
     * (envoyée en paramètre).
     *
     * @param salle salle de cours
     * @return Booléen vrai si le nombre d'élèves est inférieur à la capacité de la classe et faux, si inverse.
     */
    public boolean salleCapaciteOK(Salle salle) {
        return nbreEleves <= salle.getCapacite();
    }

    @Override
    public String toString() {
        return "Class.Classe{" +
                "idClasse="  + idClasse +
                ", annee= " + annee +
                ", sigle= '" + sigle + '\'' +
                ", specialite='" + specialite + '\'' +
                ", nbreEleves=" + nbreEleves +
                '}';
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNbreEleves() {
        return nbreEleves;
    }

    public void setNbreEleves(int nbreEleves) {
        this.nbreEleves = nbreEleves;
    }

    public ArrayList<Infos> getListeInfos() {
        return listeInfos;
    }

    public void setListeInfos(ArrayList<Infos> listeInfos) {
        this.listeInfos = listeInfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classe classe = (Classe) o;
        return idClasse == classe.idClasse && annee == classe.annee && nbreEleves == classe.nbreEleves && Objects.equals(sigle, classe.sigle) && Objects.equals(specialite, classe.specialite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigle, specialite, idClasse, annee, nbreEleves);
    }
}



