package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteEpargne;

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
        this.epargne.setSolde(this.epargne.getSolde() + this.epargne.getSolde()*tx);
    }
}
