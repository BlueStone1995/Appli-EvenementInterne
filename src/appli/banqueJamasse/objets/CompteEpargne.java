package appli.banqueJamasse.objets;

import appli.banqueJamasse.type.TypeEpargne;

import java.util.Date;

public class CompteEpargne extends Compte {

    private int idCompteCourant;
    private float txInteret;
    private TypeEpargne type;

    public CompteEpargne(int idCompte, float solde, Date dateOuverture, int idCompteCourant, float txInteret, TypeEpargne type) {
        super(idCompte, solde, dateOuverture);
        this.idCompteCourant = idCompteCourant;
        this.txInteret = txInteret;
        this.type = type;
    }

    public int getIdCompteCourant() {
        return idCompteCourant;
    }

    public void setIdCompteCourant(int idCompteCourant) {
        this.idCompteCourant = idCompteCourant;
    }

    public float getTxInteret() {
        return txInteret;
    }

    public void setTxInteret(float txInteret) {
        this.txInteret = txInteret;
    }

    public TypeEpargne getType() {
        return type;
    }

    public void setType(TypeEpargne type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "idCompteCourant=" + idCompteCourant +
                ", txInteret=" + txInteret +
                ", type='" + type + '\'' +
                ", idCompte=" + idCompte +
                ", solde=" + solde +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
