package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteEpargne;

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
            Float oldValue = (Float) evt.getOldValue();
            Float newValue = (Float) evt.getNewValue();
            Float s = cc.getSeuilMax();
            res = (oldValue<=s && (newValue>s));
        }
        else 
            if (evt.getPropertyName().equals("seuilMax")) {
                CompteCourant cc = (CompteCourant) evt.getSource();
                Float oldValue=(Float) evt.getOldValue();
                Float newValue=(Float) evt.getNewValue();
                Float solde = cc.getSolde();
                res=((solde<oldValue) && (solde>=newValue)); 
        }    
        return res;
    }


    private void trigger_evt(PropertyChangeEvent evt) {

        // Traitement rupture de stock par le stock ou par le seuil
        System.out.println("trigger Event ");
        System.out.println("compte epargne :" + evt.getSource());
        System.out.println("property " + evt.getPropertyName() + " old " + evt.getOldValue() + " new " + evt.getNewValue());

        // TODO : Implementer logique métier
        if (evt.getPropertyName().equals("solde")) System.out.println("Augmentation  de solde");
        else System.out.println("Baisse de seuil maximum");
        DateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
        String d = fd.format(Calendar.getInstance().getTime());
        
        CompteCourant cc = ((CompteCourant)evt.getSource());
        CompteEpargne ec = cc.getCompteForcement();
        
        Float montant = cc.getSolde()-cc.getSeuilMax();
        
        TypeOperation t = TypeOperation.VIREMENT;
        
        Operation op1 = new Operation(context.getMaxIdOperation()+1, cc, d, -montant,"Débit compte courant :"+c, t);
        context.addOperationBancaire(op1);
        cc.debiter(montant);
        
        Operation op2 = new Operation(context.getMaxIdOperation()+1, ec, d, montant, "Crédit compte épargne : "+c, t);
        context.addOperationBancaire(op2);
        ec.crediter(montant);
       
        
    }
}
