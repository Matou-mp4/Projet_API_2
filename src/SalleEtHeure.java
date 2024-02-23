/** Classe SalleEtHeure
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class SalleEtHeure {
    protected int nbreHeures = 0;
    protected Salle salle;

    public int getNbreHeures() {
        return nbreHeures;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }
}
