package MVC.View;
import MVC.observer.Observer;
import MVC.controller.EnseignantController;
import Ecole.Enseignant;
import java.util.List;

public abstract class EnseignantAbstractView implements Observer {
    protected EnseignantController EnseignantController;
    protected List<Enseignant> lc;

    public void setController(EnseignantController EnseignantController){
        this.EnseignantController=EnseignantController;
    }

    public abstract void affMsg(String msg);

    public abstract Enseignant selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}
