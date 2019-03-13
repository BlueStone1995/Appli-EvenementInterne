package appli.banqueJamasse.evenement;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteEpargne;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    }
}
