/** Classe EnseignantEtHeure
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class EnseignantEtHeure {
    /**
     * nombre d'heure de l'enseignant
     */
    protected int nbreHeures = 0;
    /**
     * Enseignant
     */
    protected Enseignant enseignant;

    /**
     * setter du nombre d'heures
     * @param nbreHeures nombre d'heures
     */

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    /**
     * sette de l'enseignant
     * @param enseignant enseignant
     */
    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    /**
     * getter du nombre d'heures
     * @return nbreHeures
     */
    public int getNbreHeures() {
        return nbreHeures;
    }

    /**
     * getter de l'enseignant
     * @return enseignant
     */
    public Enseignant getEnseignant() {
        return enseignant;
    }
}
