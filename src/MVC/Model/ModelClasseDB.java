package MVC.Model;
import Class.*;

import java.util.ArrayList;
import java.util.List;

public class ModelClasseDB extends DAOClasse {
    private List<Classe> ldatas = new ArrayList<>();


    @Override
    public Classe add(Classe elt) {
        boolean present = ldatas.contains(elt);
        if (!present) {
            ldatas.add(elt);
            notifyObservers();
            return elt;
        } else return null;
    }

    @Override
    public boolean remove(Classe elt) {
        boolean ok = ldatas.remove(elt);
        notifyObservers();
        return ok;
    }

    @Override
    public Classe update(Classe elt) {
        int p = ldatas.indexOf(elt);
        if (p < 0) return null;
        ldatas.set(p, elt);
        notifyObservers();
        return elt;
    }

    @Override
    public Classe read(Classe rech) {
        int p = ldatas.indexOf(rech);
        if (p < 0) return null;
        return ldatas.get(p);
    }

    @Override
    public List<Classe> getAll() {
        return ldatas;
    }

    @Override
    public ArrayList<CoursEtHeure> listerCours(Classe c,Cours co) {
        return null;
    }

    @Override
    public ArrayList<SalleEtHeure> listerSalles(Classe c,Salle sa) {
        return null;
    }

    @Override
    public ArrayList<EnseignantEtHeure> listerEnseigant(Classe c,Enseignant en) {
        return null;
    }

    @Override
    public ArrayList<Infos> listerInfos(Classe c) {
        return null;
    }
}
