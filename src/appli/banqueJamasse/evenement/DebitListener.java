package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DebitListener implements PropertyChangeListener {

    final private BanqueContext context;

    public DebitListener(BanqueContext app) {
        context = app;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        trigger_evt(evt);
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        System.out.println("Trigger Event Debit ");
        System.out.println(evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old value " + evt.getOldValue() + " new value " + evt.getNewValue());

    }
}
