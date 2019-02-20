package appli.banqueJamasse;

import java.util.Date;

public class Operation {

    private int idOperation;
    private Date dateOperation;
    private float montant;
    private String typeOperation;

    public Operation(int idOperation, Date dateOperation, float montant, String typeOperation) {
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

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
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
