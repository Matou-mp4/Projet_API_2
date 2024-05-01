package MVC.Model;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class ModelCoursDB extends DAOCours {
    private List<Cours> ldatas = new ArrayList<>();


    @Override
    public Cours add(Cours elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Cours elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Cours update(Cours elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Cours read(Cours rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Cours> getAll() {
        return ldatas;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Cours c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Cours c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Cours c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Cours c) {
        return null;
    }
}
