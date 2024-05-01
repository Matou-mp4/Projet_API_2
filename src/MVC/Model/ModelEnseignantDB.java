package MVC.Model;
import Ecole.*;

import java.util.ArrayList;
import java.util.List;

public class ModelEnseignantDB extends DAOEnseignant {
    private List<Enseignant> ldatas = new ArrayList<>();


    @Override
    public Enseignant add(Enseignant elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Enseignant elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Enseignant update(Enseignant elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Enseignant read(Enseignant rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Enseignant> getAll() {
        return ldatas;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Enseignant c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Enseignant c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Enseignant c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Enseignant c) {
        return null;
    }
}
