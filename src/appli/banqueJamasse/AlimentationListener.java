package appli.banqueJamasse;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AlimentationListener implements PropertyChangeListener {

    final private BanqueContext context;

    public AlimentationListener(BanqueContext app) {
        context = app;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (predicat_evt(evt)) trigger_evt(evt);

    }

    private boolean predicat_evt(PropertyChangeEvent evt) {
        boolean res = false;
        if (evt.getPropertyName().equals("soldeCourant")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            Float s = c.getSeuilMin();
            res = (oldValue > s && (newValue <= s));
        } else if (evt.getPropertyName().equals("seuilMin")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            // TODO : Implementer logique changement de seuil
        }
        return res;
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement rupture de stock par le stock ou par le seuil
        System.out.println("trigger Event ");
        System.out.println("compte courant :" + evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old " + evt.getOldValue() + " new " + evt.getNewValue());

        // TODO : Implementer logique métier
    }
}
