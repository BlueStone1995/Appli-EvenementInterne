package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteEpargne;
import appli.banqueJamasse.objets.Operation;
import appli.banqueJamasse.type.TypeOperation;

import java.util.Date;
import java.util.TimerTask;

public class AjoutInteret extends TimerTask {
    final private CompteEpargne epargne;
    final private BanqueContext context;

    public AjoutInteret(CompteEpargne epargne, BanqueContext app) {
        this.epargne = epargne;
        this.context = app;

    }

    public void run() {
        System.out.println("exécution taux interet");
        Float tx = this.epargne.getTxInteret();
        Float newSolde = this.epargne.getSolde() * (1 + tx);
        this.epargne.setSolde(newSolde);

        Date date = new Date();
        Operation opDebit = new Operation(this.context.getMaxIdOperation() + 1, date, newSolde, TypeOperation.INTERET, epargne, epargne);
        this.context.addOperation(opDebit);

        // this.context.getAgenda();
        //this.context.getAgenda().schedule(this, 10);
    }
}
