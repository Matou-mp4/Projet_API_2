package designpatterns.builder;

import Ecole.Cours;
import Ecole.Enseignant;
import Ecole.Salle;

import java.util.Objects;

public class Infos {
    /**
     * nombre d'heure d'un cours donné
     */
    protected int nbreHeures;
    /**
     * cours donné
     */
    protected Cours cours;
    /**
     * enseignant donnant le cours
     */
    protected Enseignant enseignant;
    /**
     * sallee où le cours est donné
     */
    protected Salle salle;
    public Infos(InfosBuilder ib){
        this.cours=ib.cours;
        this.salle=ib.salle;
        this.enseignant=ib.enseignant;
        this.nbreHeures=ib.nbreHeures;
    }
    /**
     * getter du nombre d'heure
     * @return nbreHeures
     */
    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * getter du nom de l'enseignant
     * @return nom de l'enseignant
     */
    public String getNomEnseignant() {
        return enseignant.getNom();
    }

    /**
     * setter de nombreHeures par l'entier envoyé en paramètre
     * @param nbreHeures nombre d'heures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * setter de cours par le cours envoyé en paramètre
     * @param cours cours
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    /**
     * setter de l'enseignant par l'enseignant envoyé en paramètre
     * @param enseignant enseignant
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     * setter de salle par la salle envoyée en paramètre
     * @param salle salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * getter de la capacité de la salle
     * @return capacité de la salle
     */
    public int getCapaciteSalle() {
        return salle.getCapacite();
    }

    /**
     * getter de l'intitulé du cours
     * @return intitule de cours
     */
    public String getNomCours(){
        return cours.getIntitule();
    }

    /**
     * getter de cours
     * @return cours
     */
    public Cours getCours() {
        return cours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Infos infos = (Infos) o;
        return nbreHeures == infos.nbreHeures && Objects.equals(cours, infos.cours) && Objects.equals(enseignant, infos.enseignant) && Objects.equals(salle, infos.salle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nbreHeures, cours, enseignant, salle);
    }

    @Override
    public String toString() {
        return "Infos{" +
                "nbreHeures=" + nbreHeures +
                ", cours=" + cours +
                ", enseignant=" + enseignant +
                ", salle=" + salle +
                '}';
    }
        public static class InfosBuilder{
            /**
             * nombre d'heure d'un cours donné
             */
            protected int nbreHeures;
            /**
             * cours donné
             */
            protected Cours cours;
            /**
             * enseignant donnant le cours
             */
            protected Enseignant enseignant;
            /**
             * sallee où le cours est donné
             */
            protected Salle salle;
            public InfosBuilder setSalle(Salle salle){
                this.salle = salle;
                return this;
            }
            public InfosBuilder setEnseignant(Enseignant enseignant){
                this.enseignant=enseignant;
                return this;
            }
            public InfosBuilder setCours(Cours cours) {
                this.cours = cours;
                return this;
            }
            public InfosBuilder setNbreHeures(int nbreHeures) {
                this.nbreHeures = nbreHeures;
                return this;
            }
            public Infos builder() throws Exception{
                if(salle == null || nbreHeures<=0 || cours==null || enseignant==null ) throw new Exception("informations de construction incomplètes");
                return new Infos(this);
            }
        }
}
