/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli.evenementinterne;


/**
 *
 * @author carine
 */
public class CommandeReappro {
    private Integer qte;
    private Produit produit;
    private String dateCommande;
    private String commentaire;
    final private Integer id_reappro;

    public CommandeReappro(Integer id_reappro, Integer qte, Produit p, String date, String c) {
        this.id_reappro=id_reappro;
        this.qte=qte;
        this.produit=p;
        this.dateCommande=date;
        this.commentaire=c;
        
    }

    public Integer getId_reappro() {
        return id_reappro;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public String getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(String dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    public String toString() {
        return ("Id CommandeReappro :" + id_reappro +" Nom :" + produit.getNom_produit() +" qte :" + qte + " date :" +dateCommande +" commentaire :" +commentaire );
    }
    
}
