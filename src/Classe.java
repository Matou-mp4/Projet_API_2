import java.util.ArrayList;

public class Classe {
    protected String sigle, specialite;
    protected int annee, nbreEleves;
    protected ArrayList <Infos> listeInfos;
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
        if(listeInfosVerif()){
            for (Infos element : listeInfos){
                System.out.println(cpt+". Professeur(e) : "+element.getNomEnseignant()+" Nombre d'heures : "+element.getNbreHeures());
                cpt++;
            }
        }
    }
    public void listeSallesEtHeures(){
        int cpt=1;
        if(listeInfosVerif()){
            for (Infos element : listeInfos){
                System.out.println(cpt+". Professeur(e) : "+element.getCapaciteSalle()+" Nombre d'heures : "+element.getNbreHeures());
                cpt++;
            }
        }
    }
    public void listeCoursEtHeures(){
        int cpt=1;
        if(listeInfosVerif()){
            for (Infos element : listeInfos){
                System.out.println("Cours "+cpt+" : "+element.getNomCours()+" Nombre d'heures : "+element.getNbreHeures());
                cpt++;
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


