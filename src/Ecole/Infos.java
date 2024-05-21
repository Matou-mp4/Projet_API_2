package Ecole;
/* peut etre ajouter idClasse*/
/** Class.Classe Class.Infos
 * @Author Dangreau Antoine
 * @Version 1.0
 */
public class Infos {
    /**
     * nombre d'heure d'un cours donné
     */
    protected int nbreHeures;
    private int idInfos;
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

    protected Classe classe;
    /**
     * Constructeur 1 parametré de la classe infos
     * @param cours cours donné
     * @param nbreHeures nombre d'heures du cours donné
     */
    public Infos(Cours cours, int nbreHeures ){
        this.cours=cours;
        this.nbreHeures=nbreHeures;
    }

    /**
     * onstructeur 2 parametré de la classe infos
     * @param nbreHeures nombre d'heure du cours donné
     * @param cours cours donné
     * @param enseignant enseignant donnant le cours
     * @param salle salle ou le cours est donné
     */
    public Infos(int nbreHeures, Cours cours, Enseignant enseignant, Salle salle,Classe classe) {
        this.nbreHeures = nbreHeures;
        this.cours = cours;
        this.enseignant = enseignant;
        this.salle = salle;
        this.classe=classe;
    }

    public Infos(int nbreHeures, int idInfos, Cours cours, Enseignant enseignant, Salle salle, Classe classe) {
        this.nbreHeures = nbreHeures;
        this.idInfos = idInfos;
        this.cours = cours;
        this.enseignant = enseignant;
        this.salle = salle;
        this.classe = classe;
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
        return enseignant.nom;
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
        return salle.capacite;
    }

    /**
     * getter de l'intitulé du cours
     * @return intitule de cours
     */
    public String getNomCours(){
        return cours.intitule;
    }

    /**
     * getter de cours
     * @return cours
     */
    public Cours getCours() {
        return cours;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public Salle getSalle() {
        return salle;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getIdInfos() {
        return idInfos;
    }

    public void setIdInfos(int idInfos) {
        this.idInfos = idInfos;
    }
}
