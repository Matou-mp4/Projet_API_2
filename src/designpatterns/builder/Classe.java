package designpatterns.builder;

import Ecole.*;

import java.util.ArrayList;
import java.util.Objects;

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
    private Classe(ClasseBuilder cb){
        this.annee=cb.annee;
        this.idClasse=cb.idClasse;
        this.nbreEleves=cb.nbreEleves;
        this.sigle=cb.sigle;
        this.specialite=cb.specialite;

    }

    public String getSigle() {
        return sigle;
    }

    public String getSpecialite() {
        return specialite;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public int getAnnee() {
        return annee;
    }

    public int getNbreEleves() {
        return nbreEleves;
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


    public static class ClasseBuilder{
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

        public ClasseBuilder setSigle(String sigle) {
            this.sigle = sigle;
            return this;
        }

        public ClasseBuilder setSpecialite(String specialite) {
            this.specialite = specialite;
            return this;
        }

        public ClasseBuilder setIdClasse(int idClasse) {
            this.idClasse = idClasse;
            return this;
        }

        public ClasseBuilder setAnnee(int annee) {
            this.annee = annee;
            return this;
        }

        public ClasseBuilder setNbreEleves(int nbreEleves) {
            this.nbreEleves = nbreEleves;
            return this;
        }
         public Classe build() throws Exception{
            if(idClasse<=0 || sigle==null || specialite==null || annee<=0 || nbreEleves<=0  ) throw new Exception("informations de construction incomplètes");
            return new Classe(this);
         }

    }
}
