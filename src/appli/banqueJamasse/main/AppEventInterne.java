package appli.banqueJamasse.main;

import appli.banqueJamasse.context.BanqueContext;
import appli.banqueJamasse.objets.CompteCourant;
import appli.banqueJamasse.objets.CompteEpargne;
import appli.banqueJamasse.type.TypeEpargne;

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

        compteCourant.debiter(50);
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

        compteCourant.setSeuilMin(50);
        System.out.println("Après changement seuil minimum");
        System.out.println("liste compte courant :");
        AffichageCollections(context.getCompteCourants());
        System.out.println("liste compte epargne :");
        AffichageCollections(context.getCompteEpargnes());

        compteCourant.setSolde(40);
        System.out.println("Après décrément du compte courant");
        System.out.println("liste compte courant :");
        AffichageCollections(context.getCompteCourants());
        System.out.println("liste compte epargne :");
        AffichageCollections(context.getCompteEpargnes());
        System.out.println("liste opérations :");
        AffichageCollections(context.getOperations());
    }

    static void AffichageCollections(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            System.out.println("element " + i.next().toString());
        }
    }
}
