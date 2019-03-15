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

            CompteCourant compteCourant = new CompteCourant(0, 200, today, 0, 100, 1000, false);
            context.addCompteCourant(compteCourant);

            CompteEpargne compteEpargne = new CompteEpargne(0, 1000, today, 0, 0.07f, TypeEpargne.LIVRET_A);
            context.addCompteEpargne(compteEpargne);

            compteCourant.setSolde(-100);
            System.out.println("Après décrément du compte courant");
            System.out.println("liste compte courant :");
            AffichageCollections(context.getCompteCourants());
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
            AffichageCollections(context.getOperations());

            compteCourant.debiter(50);
            System.out.println("Après débit du compte courant");
            System.out.println("liste compte courant :");
            AffichageCollections(context.getCompteCourants());
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
            AffichageCollections(context.getOperations());

            compteCourant.setSeuilMin(200);
            System.out.println("Après changement seuil minimum");
            System.out.println("liste compte courant :");
            AffichageCollections(context.getCompteCourants());
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
            AffichageCollections(context.getOperations());

            compteCourant.setSeuilMin(50);
            System.out.println("Après changement seuil minimum");
            System.out.println("liste compte courant :");
            AffichageCollections(context.getCompteCourants());
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
            AffichageCollections(context.getOperations());

            compteCourant.crediter(40);
            System.out.println("Après crédit du compte courant");
            System.out.println("liste compte courant :");
            AffichageCollections(context.getCompteCourants());
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
            AffichageCollections(context.getOperations());


            Thread.sleep(100);
            System.out.println("Calcul taux d'intérêts");
            System.out.println("liste compte epargne :");
            AffichageCollections(context.getCompteEpargnes());
            System.out.println("liste opérations :");
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
