package appli.banqueJamasse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EpargneListener implements PropertyChangeListener {

    final private BanqueContext context;

    public EpargneListener(BanqueContext app) {
        context = app;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (predicat_evt(evt)) trigger_evt(evt);

    }

    private boolean predicat_evt(PropertyChangeEvent evt) {
        boolean res = false;
        if (evt.getPropertyName().equals("epargne")) {
            CompteEpargne c = (CompteEpargne) evt.getSource();
            Integer oldValue = (Integer) evt.getOldValue();
            Integer newValue = (Integer) evt.getNewValue();
            // TODO : Implémenter condition métier
            // res = (oldValue > s && (newValue <= s));
        }
        return res;
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement rupture de stock par le stock ou par le seuil
        System.out.println("trigger Event ");
        System.out.println("compte epargne :" + evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old " + evt.getOldValue() + " new " + evt.getNewValue());

        // TODO : Implementer logique métier
    }
}
