package appli.banqueJamasse;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class AppEventInterne {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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

        compteCourant.setSeuilMin(200);
        System.out.println("Après changement seuil minimum");
        System.out.println("liste compte courant :");
        AffichageCollections(context.getCompteCourants());
        System.out.println("liste compte epargne :");
        AffichageCollections(context.getCompteEpargnes());

    }

    static void AffichageCollections(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            System.out.println("element " + i.next().toString());
        }
    }
}
