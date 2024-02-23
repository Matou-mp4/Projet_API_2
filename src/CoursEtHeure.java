/** Classe CoursEtHeure
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class CoursEtHeure {
    protected int nbreHeures = 0;
    protected Cours cours;

    public int getNbreHeures() {
        return nbreHeures;
    }

    public Cours getCours() {
        return cours;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
