package appli.banqueJamasse;

import java.util.Date;

public abstract class Compte extends appli.lib.PropertyChangeSupport {

    protected int idCompte;
    protected float solde;
    protected Date dateOuverture;


    public Compte(int idCompte, float solde, Date dateOuverture) {
        super();
        this.idCompte = idCompte;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        Float oldValue = this.solde;
        this.solde = solde;
        this.firePropertyChange("soldeCourant", oldValue, solde);
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "idCompte=" + idCompte +
                ", solde=" + solde +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
