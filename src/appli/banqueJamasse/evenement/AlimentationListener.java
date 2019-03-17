package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteCourant;
import appli.banqueJamasse.objets.CompteEpargne;
import appli.banqueJamasse.objets.Operation;
import appli.banqueJamasse.type.TypeOperation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

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
        if (evt.getPropertyName().equals("solde")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            Float s = c.getSeuilMin();
            res = (oldValue >= s && (newValue < s));
        } else if (evt.getPropertyName().equals("seuilMin")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            res = ((c.getSolde() >= oldValue) && (c.getSolde() < newValue));
        }
        return res;
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement alimentation compte courant par le compte epargne ou modification seuilMin
        System.out.println("Trigger Event ");
        System.out.println(evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old value " + evt.getOldValue() + " new value " + evt.getNewValue());

        if (evt.getPropertyName().equals("solde")) System.out.println("Générée suite à un changement de solde");
        else System.out.println("Générée suite à un changement de seuilMin");

        CompteCourant c = (CompteCourant) evt.getSource();

        int idCompteEpargne = c.getIdCompteEpargne();
        CompteEpargne e = context.getCompteEpargne(idCompteEpargne);

        Date date = new Date();
        float montant;

        montant = c.getSeuilMin() - c.getSolde();

        if (e.getSolde() <= 0) {
            System.out.println("Alimentation compte courant refusé");
            return;
        } else if (montant > e.getSolde()) {
            montant = e.getSolde();
        }

        System.out.println("Montant : " + montant);

        c.setSolde(c.getSolde() + montant);

        e.debiter(montant);

        Operation operationEpargne = new Operation(context.getMaxIdOperation() + 1, date, -montant, TypeOperation.VIREMENT, e);
        context.addOperation(operationEpargne);

        Operation operationCourant = new Operation(context.getMaxIdOperation() + 1, date, montant, TypeOperation.CB, c);
        context.addOperation(operationCourant);
    }
}
