package appli.banqueJamasse.objets;

import appli.banqueJamasse.type.TypeOperation;

import java.util.Date;

public class Operation {

    private int idOperation;
    private Date dateOperation;
    private float montant;
    private TypeOperation typeOperation;
    private Compte compte;

    public Operation(int idOperation, Date dateOperation, float montant, TypeOperation typeOperation, Compte compte) {
        this.idOperation = idOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
        this.compte = compte;
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", typeOperation=" + typeOperation +
                ", compte=" + compte +
                '}';
    }
}
