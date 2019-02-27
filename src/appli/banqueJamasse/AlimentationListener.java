package appli.banqueJamasse;

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
            res = (oldValue > s && (newValue <= s));
        } else if (evt.getPropertyName().equals("seuilMin")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            Float seuil = c.getSeuilMin();
            res = (oldValue == seuil && (newValue != seuil));
        }
        return res;
    }

    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement alimentation compte courant par le compte epargne ou modification seuilMin
        System.out.println("Trigger Event ");
        System.out.println(evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old solde " + evt.getOldValue() + " new solde " + evt.getNewValue());

        if (evt.getPropertyName().equals("solde")) {
            float montantDebit, montantCredit, newSoldeE, newSoldeC;
            Date date = new Date();
            TypeOperation typeOperation = TypeOperation.CB;

            CompteCourant c = (CompteCourant) evt.getSource();

            int idCompteEpargne = c.getIdCompteEpargne();
            CompteEpargne e = context.getCompteEpargne(idCompteEpargne);

            float montant = c.getSeuilMin() - (Float) evt.getNewValue();

            System.out.println("Montant : " + montant);
            System.out.println(e);
            if (e.getSolde() > montant) {
                newSoldeE = e.getSolde() - montant;
                newSoldeC = c.getSolde() + montant;
                montantDebit = -montant;
                montantCredit = montant;
            } else if (e.getSolde() > 0) {
                newSoldeE = 0;
                newSoldeC = c.getSolde() - e.getSolde();
                montantDebit = -e.getSolde();
                montantCredit = e.getSolde();
            } else {
                return;
            }

            System.out.println("Montant débit : " + montantDebit);
            System.out.println("Montant credit : " + montantCredit);
            System.out.println("Montant epargne : " + newSoldeE);
            System.out.println("Montant courant : " + newSoldeC);

            // TODO : Mettre à jour solde
            // e.setSolde(newSoldeE);
            // c.setSolde(newSoldeC);
            Operation opCourant = new Operation(context.getMaxIdOperation() + 1, date, montantCredit, typeOperation);
            Operation opEpargne = new Operation(context.getMaxIdOperation() + 1, date, montantDebit, typeOperation);

            context.addCompteCourant(c);
            context.addCompteEpargne(e);
            context.addOperation(opCourant);
            context.addOperation(opEpargne);
        } else if (evt.getPropertyName().equals("seuilMin")) {
            CompteCourant c = (CompteCourant) evt.getSource();
            c.setSeuilMin((Float) evt.getNewValue());
            context.addCompteCourant(c);
        }
    }
}
