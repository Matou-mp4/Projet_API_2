package MVC.View;
import MVC.observer.Observer;
import MVC.controller.SalleController;
import Ecole.Salle;
import java.util.List;

public abstract class SalleAbstractView implements Observer {
    protected SalleController salleController;
    protected List<Salle> lc;

    public void setController(SalleController SalleController){
        this.salleController=SalleController;
    }

    public abstract void affMsg(String msg);

    public abstract Salle selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}
