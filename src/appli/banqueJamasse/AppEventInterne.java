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
        CompteCourant compteCourant = new CompteCourant(0, 100, today, 0, 100, 1000, false);
        context.addCompteCourant(compteCourant);

    }

    static void AffichageCollections(Collection c) {
        Iterator i = c.iterator();
        while (i.hasNext()) {
            System.out.println("element " + i.next().toString());
        }
    }
}
