package Ecole;

/** Class.Classe Class.CoursEtHeure
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class CoursEtHeure {
    /**
     * nombre d'heures recupéré depuis liste
     */
    protected int nbreHeures = 0;
    /**
     * cours
     */
    protected Cours cours;

    /**
     * fonction retournant le nombre d'heures
     * @return nbreHeures
     */
    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * getter de cours
     * @return cours
     */
    public Cours getCours() {
        return cours;
    }

    /**
     * setter du nombre d'heures
     * @param nbreHeures nombre d'heures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * setter du cours
     * @param cours cours
     */
    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "CoursEtHeure{" +
                " cours=" + cours +
                ", nbreHeures=" + nbreHeures +
                '}';
    }
}
