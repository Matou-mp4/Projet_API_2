package MVC.Model;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class ModelInfosDB extends DAOInfos {
    private List<Infos> ldatas = new ArrayList<>();


    @Override
    public Infos add(Infos elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Infos elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Infos update(Infos elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Infos read(Infos rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Infos> getAll() {
        return ldatas;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Infos c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Infos c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Infos c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Infos c) {
        return null;
    }
}
