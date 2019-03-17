package appli.banqueJamasse.main;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteCourant;
import appli.banqueJamasse.objets.CompteEpargne;
import appli.banqueJamasse.type.TypeEpargne;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppEventInterne {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BanqueContext context = new BanqueContext();
            Date today = new Date();

            CompteCourant compteCourant = new CompteCourant(0, 200, today, 0, 100, 300, false);
            context.addCompteCourant(compteCourant);

            CompteEpargne compteEpargne = new CompteEpargne(0, 1000, today, 0, 0.07f, TypeEpargne.LIVRET_A);
            context.addCompteEpargne(compteEpargne);

            compteCourant.setSolde(400);
            System.out.println("Après modif sur compte courant");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            compteCourant.setSolde(-100);
            System.out.println("Après modif sur compte courant");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            compteCourant.setSeuilMax(400);
            compteCourant.setSolde(500);
            System.out.println("Après changement seuil max");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            compteCourant.setSeuilMin(50);
            compteCourant.setSolde(0);
            System.out.println("Après changement seuil min");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            context.crediter(compteCourant, compteEpargne, 200);
            System.out.println("Après crédit sur compte courant");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            context.debiter(compteCourant, 100);
            System.out.println("Après débit sur compte courant");
            AffichageCollections(context.getCompteCourants());
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            Thread.sleep(100);
            System.out.println("Calcul taux d'intérêts");
            AffichageCollections(context.getCompteEpargnes());
            AffichageCollections(context.getOperations());

            context.close();
        } catch (InterruptedException ex) {
            Logger.getLogger(AppEventInterne.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void AffichageCollections(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            System.out.println("element " + i.next().toString());
        }
    }
}
