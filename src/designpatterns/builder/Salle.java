package designpatterns.builder;

import Ecole.Enseignant;

import java.util.ArrayList;
import java.util.Objects;

public class Salle {
    /**
     * sigle unique de la salle
     */
    protected int sigle;
    /**
     * capacité de la classe
     */
    protected int capacite;
    /**
     * liste d'enseignant attitrés à cette salle
     */
    protected ArrayList<Enseignant> listeEnseignant=new ArrayList<>();

    public Salle(SalleBuilder sb) {
        this.sigle = sb.sigle;
        this.capacite = sb.capacite;
    }
    /**
     * fonction retournant la capacité de la classe
     * @return capacite capacite de la classe
     */
    public int getCapacite() {
        return capacite;
    }

    /**
     * fonction retournant le sigle de la classe
     * @return sigle sigle de la classe
     */
    public int getSigle() {
        return sigle;
    }

    /**
     *Verification de l'égalité de deux salles
     * @param o
     * @return égalité ou non
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return capacite == salle.getCapacite() && Objects.equals(sigle, salle.getSigle());
    }

    /**
     *  calcul du hashcode de la salle
     * @return valeur du hashcode de la salle
     */
    @Override
    public int hashCode() {
        return Objects.hash(sigle, capacite);
    }

    public void setSigle(int sigle) {
        this.sigle = sigle;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
    public static class SalleBuilder{
        /**
         * sigle unique de la salle
         */
        protected int sigle;
        /**
         * capacité de la classe
         */
        protected int capacite;

        public SalleBuilder setSigle(int sigle) {
            this.sigle = sigle;
            return this;
        }

        public SalleBuilder setCapacite(int capacite) {
            this.capacite = capacite;
            return this;
        }

        public Salle builder() throws Exception{
            if(sigle<=0 || capacite<=0 ) throw new Exception("informations de construction incomplètes");
            return new Salle(this);
        }
    }
}
