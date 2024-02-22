import java.util.ArrayList;

public class Classe {
    protected String sigle, specialite;
    protected int annee, nbreEleves;
    protected ArrayList <Infos> listeInfos = new ArrayList<>();
    protected ArrayList <EnseignantEtHeure> listeEnseigantEtHeure = new ArrayList<>();
    protected ArrayList <CoursEtHeure> listeCoursEtHeure = new ArrayList<>();
    protected ArrayList <SalleEtHeure> listeSalleEtHeure = new ArrayList<>();
    public Classe(){

    }
    public boolean listeInfosVerif(){
        int longueur = listeInfos.size();
        if(longueur==0){
            System.out.println("Erreur, aucune information présente dans la liste infos");
            return false;
        }
        else{
            return true;
        }
    }

    public void nbreHeuresTot(){
        int cptHeures=0;
        if(listeInfosVerif()){
            for (Infos element : listeInfos){
                cptHeures=cptHeures + element.getNbreHeures();
            }
            System.out.println("Nombre d'heures total : "+cptHeures+".");
        }
    }
    public void listeEnseignantsEtHeures(){
        int cpt=1;
        EnseignantEtHeure ajout = new EnseignantEtHeure();
        if(listeInfosVerif()){
            for (Infos element : listeInfos){
                ajout.setEnseignant(element.enseignant);
                ajout.setNbreHeures(element.nbreHeures);
                boolean flag=false;
                for (EnseignantEtHeure eH : listeEnseigantEtHeure) {
                    if(element.enseignant.equals(eH.enseignant)){
                        eH.setNbreHeures(eH.nbreHeures + element.nbreHeures);
                        flag=true;
                    }
                }
                if(!flag){
                    listeEnseigantEtHeure.add(ajout);
                }
            }
        }
    }
    public void listeSallesEtHeures(){
        int cpt=1;
        if(listeInfosVerif()){
            for (Infos element : listeInfos){

            }
        }
    }
    public void listeCoursEtHeures(){
        int cpt=1;
        if(listeInfosVerif()){
            for (Infos element : listeInfos){

            }
        }
    }
    public void addCours(Cours c,int heures){
        listeInfos.add(new Infos(c,heures));
    }
    public void modifCours(Cours c,Enseignant e){
        for (Infos element: listeInfos) {
            if(element.getCours().equals(c)){
                element.setEnseignant(e);
                break;
            }
        }
    }
    public void modifCours(Cours c,Salle s){
        for (Infos element: listeInfos) {
            if(element.getCours().equals(c)){
                element.setSalle(s);
                break;
            }
        }
    }
    public void modifCours(Cours c,int heures){
        for (Infos element: listeInfos) {
            if(element.getCours().equals(c)){
                element.setNbreHeures(heures);
                break;
            }
        }
    }
    public void suppCours(Cours c){
        listeInfos.removeIf(element -> (element.getCours()).equals(c));
        /*
        for (Infos element : listeInfos){
            if((element.getCours()).equals(c)){
                listeInfos.remove(element);
                System.out.println("Cours "+ c.getIntitule+" supprimé");
            }
        }
        */
        /*
        * 2 methodes :
        * - methode removeIf : ergonomique en une ligne (proposée par intelliji)
        * - methode forEach : permet d'afficher si la suppression est faite
        * */
    }
    public boolean salleCapaciteOK(Salle salle){
        return nbreEleves >= salle.getCapacite();
    }
}


