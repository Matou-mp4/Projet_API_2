import java.util.ArrayList;
/** Classe Infos
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Infos {
    protected int nbreHeures;
    protected Cours cours;
    protected Enseignant enseignant;
    protected Salle salle;

    public Infos(Cours cours,int nbreHeures ){
        this.cours=cours;
        this.nbreHeures=nbreHeures;
    }
    public int getNbreHeures() {
        return nbreHeures;
    }
    public String getNomEnseignant() {
        return enseignant.nom;
    }

    public void setNbreHeures(int nbreHeures) {
        this.nbreHeures = nbreHeures;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public int getCapaciteSalle() {
        return salle.capacite;
    }
    public String getNomCours(){
        return cours.intitule;
    }
    public Cours getCours() {
        return cours;
    }

}
