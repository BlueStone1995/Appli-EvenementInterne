/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli.evenementinterne;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author carine
 */
public class AppliEvenementInterne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AppContext context=new AppContext();
        Produit p =new Produit(20, 1, 10,"ramettes papier A4" );
        context.addProduit(p);
        p.setStock(8);
        System.out.println ("Après rupture de stock");
        System.out.println ("liste produits :");
        AffichageCollections(context.getProduits());
        System.out.println ("liste commandeReappro :");
        AffichageCollections(context.getCommandeReappros());
        p.setStock(6);
        System.out.println ("Après décrément du stock");
        System.out.println ("liste produits :");
        AffichageCollections(context.getProduits());
        System.out.println ("liste commandeReappro :");
        AffichageCollections(context.getCommandeReappros());
        p.setStock (15);
        System.out.println ("Après reappro");
        System.out.println ("liste produits :");
        AffichageCollections(context.getProduits());
        System.out.println ("liste commandeReappro :");
        AffichageCollections(context.getCommandeReappros());
        p.setSeuilRupture (16);
        System.out.println ("Après changement seuil de rupture");
        System.out.println ("liste produits :");
        AffichageCollections(context.getProduits());
        System.out.println ("liste commandeReappro :");
        AffichageCollections(context.getCommandeReappros());
    }
    
static void AffichageCollections (Collection c){
    Iterator i=c.iterator();
    while (i.hasNext()){
        System.out.println ("element "+i.next().toString());
    }
}
}
