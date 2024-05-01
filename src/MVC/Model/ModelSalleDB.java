package MVC.Model;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class ModelSalleDB extends DAOSalle {
    private List<Salle> ldatas = new ArrayList<>();


    @Override
    public Salle add(Salle elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Salle elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Salle update(Salle elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Salle read(Salle rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Salle> getAll() {
        return ldatas;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Salle c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Salle c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Salle c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Salle c) {
        return null;
    }
}
