/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli.evenementinterne;

import java.beans.PropertyChangeListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *
 * @author carine
 */
public class AppContext {
    
     final private Map<Integer, Produit> produits=new HashMap<>();
     final private Map<Integer,CommandeReappro> reappros=new HashMap<>();
     final private PropertyChangeListener reappro=new RuptureStockListener (this);
    
     
     public AppContext () {    
    }
   
   public void addCommandeReappro(CommandeReappro e) {
       reappros.put(e.getId_reappro(),e);
   }
   
   public Integer getMaxIdReappro (){
       if (!reappros.isEmpty()) {
           Set<Integer> s=reappros.keySet();
       return (Collections.max(s));
       } else return 0;
       
   }
   
   public Integer getMaxIdProduit (){
       if (!produits.isEmpty()) {
           Set<Integer> s=produits.keySet();
           return (Collections.max(s));
       } else return 0;
       
   }
   
   public void addProduit (Produit e ) {
       e.addPropertyChangeListener("stock", reappro);
       e.addPropertyChangeListener("seuilRupture", reappro);
       produits.put(e.getId_produit(),e);
   }
   
   public Produit getProduit (Integer id) {
       return produits.get(id);
   }
   
   public Collection<Produit> getProduits () {
       return produits.values();
   }
   public Collection<CommandeReappro> getCommandeReappros () {
       return reappros.values();
   }

}
