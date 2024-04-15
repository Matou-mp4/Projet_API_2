package Class;

/** Class.Classe Class.SalleEtHeure
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class SalleEtHeure {
    /**
     * nombre d'heures
     */
    protected int nbreHeures = 0;
    /**
     * salle
     */
    protected Salle salle;

    /**
     * getter du nombre d'heures
     * @return nombre d'heures
     */
    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * getter de salle
     * @return sallz
     */
    public Salle getSalle() {
        return salle;
    }

    /**
     * setter du nombre d'heures
     * @param nbreHeures nombre d'heures
     */
    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * setter de salle
     * @param salle salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
