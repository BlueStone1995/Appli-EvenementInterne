package appli.banqueJamasse.objets;

import appli.banqueJamasse.type.TypeOperation;

import java.util.Date;

public class Operation {

    private int idOperation;
    private Date dateOperation;
    private float montant;
    private TypeOperation typeOperation;

    public Operation(int idOperation, Date dateOperation, float montant, TypeOperation typeOperation) {
        this.idOperation = idOperation;
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.typeOperation = typeOperation;
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

    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", dateOperation=" + dateOperation +
                ", montant=" + montant +
                ", typeOperation='" + typeOperation + '\'' +
                '}';
    }
}
