package MVC.View;
import MVC.observer.Observer;
import MVC.controller.InfosController;
import Ecole.Infos;
import java.util.List;

public abstract class InfosAbstractView implements Observer {
    protected InfosController InfosController;
    protected List<Infos> lc;

    public void setController(InfosController InfosController){
        this.InfosController=InfosController;
    }

    public abstract void affMsg(String msg);

    public abstract Infos selectionner();

    public abstract void menu();

    public abstract void affList(List l);

    @Override
    public void update(List lc) {
        this.lc = lc;
        affList(lc);
    }
}
