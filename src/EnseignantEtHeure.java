public class EnseignantEtHeure {
    protected int nbreHeures = 0;
    protected Enseignant enseignant;

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public int getNbreHeures() {
        return nbreHeures;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }
}
