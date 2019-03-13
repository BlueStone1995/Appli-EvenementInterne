package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreditListener implements PropertyChangeListener {

    final private BanqueContext context;

    public CreditListener(BanqueContext app) {
        context = app;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (predicat_evt(evt)) trigger_evt(evt);

    }

    private boolean predicat_evt(PropertyChangeEvent evt) {
        boolean res = false;

        return res;
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement alimentation compte courant par le compte epargne ou modification seuilMin
        System.out.println("Trigger Event ");
        System.out.println(evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old value " + evt.getOldValue() + " new value " + evt.getNewValue());

    }

}
