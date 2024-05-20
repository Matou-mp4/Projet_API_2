//todo: retirer
package MVC.Model;

import Ecole.*;

import java.util.ArrayList;

public interface DAOSpecialClasse {
    public abstract ArrayList<Infos> listerInfos(Classe c);
    public abstract ArrayList<EnseignantEtHeure> listerEnseigant(Classe c, Enseignant en);
    public abstract ArrayList<SalleEtHeure> listerSalles(Classe c, Salle sa);
    public abstract ArrayList<CoursEtHeure> listerCours(Classe c,Cours co);
}
