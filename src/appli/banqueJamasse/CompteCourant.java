package appli.banqueJamasse;

import java.util.Date;

public class CompteCourant extends Compte {

    private int idCompteEpargne;
    private float seuilMin;
    private float seuilMax;
    private boolean autorisationDecouvert;

    public CompteCourant(int idCompte, float solde, Date dateOuverture, int idCompteEpargne, float seuilMin, float seuilMax, boolean autorisationDecouvert) {
        super(idCompte, solde, dateOuverture);
        this.idCompteEpargne = idCompteEpargne;
        this.seuilMin = seuilMin;
        this.seuilMax = seuilMax;
        this.autorisationDecouvert = autorisationDecouvert;
    }

    public int getIdCompteEpargne() {
        return idCompteEpargne;
    }

    public void setIdCompteEpargne(int idCompteEpargne) {
        this.idCompteEpargne = idCompteEpargne;
    }

    public float getSeuilMin() {
        return seuilMin;
    }

    public void setSeuilMin(float seuilMin) {
        this.seuilMin = seuilMin;
    }

    public float getSeuilMax() {
        return seuilMax;
    }

    public void setSeuilMax(float seuilMax) {
        this.seuilMax = seuilMax;
    }

    public boolean isAutorisationDecouvert() {
        return autorisationDecouvert;
    }

    public void setAutorisationDecouvert(boolean autorisationDecouvert) {
        this.autorisationDecouvert = autorisationDecouvert;
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "idCompteEpargne=" + idCompteEpargne +
                ", seuilMin=" + seuilMin +
                ", seuilMax=" + seuilMax +
                ", autorisationDecouvert=" + autorisationDecouvert +
                ", idCompte=" + idCompte +
                ", solde=" + solde +
                ", dateOuverture=" + dateOuverture +
                '}';
    }
}
