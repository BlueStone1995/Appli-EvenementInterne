package appli.banqueJamasse.objets;

import appli.banqueJamasse.type.TypeOperation;

import java.util.Date;

public class Operation {

    private int idOperation;
    private Date dateOperation;
    private float montant;
    private TypeOperation typeOperation;
    private Compte compteDebit;
    private Compte compteCredit;

    public Operation(int idOperation, Date dateOperation, float montant, TypeOperation typeOperation, Compte compteDebit, Compte compteCredit) {
        this.idOperation = idOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
        this.compteCredit = compteCredit;
        this.compteDebit = compteDebit;
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

    public Compte getCompteDebit() {
        return compteDebit;
    }

    public void setCompteDebit(Compte compteDebit) {
        this.compteDebit = compteDebit;
    }

    public Compte getCompteCredit() {
        return compteCredit;
    }

    public void setCompteCredit(Compte compteCredit) {
        this.compteCredit = compteCredit;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", typeOperation=" + typeOperation +
                ", compteDebit=" + compteDebit +
                ", compteCredit=" + compteCredit +
                '}';
    }
}
