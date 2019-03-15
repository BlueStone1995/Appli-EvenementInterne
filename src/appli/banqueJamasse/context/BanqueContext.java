package appli.banqueJamasse.context;

import appli.banqueJamasse.evenement.AjoutInteret;
import appli.banqueJamasse.objets.Compte;
import appli.banqueJamasse.objets.CompteCourant;
import appli.banqueJamasse.objets.CompteEpargne;
import appli.banqueJamasse.objets.Operation;
import appli.banqueJamasse.evenement.AlimentationListener;
import appli.banqueJamasse.evenement.EpargneListener;
import appli.banqueJamasse.type.TypeOperation;

import java.beans.PropertyChangeListener;
import java.util.*;

public class BanqueContext {

    final private Map<Integer, Operation> operation = new HashMap<>();
    final private Map<Integer, CompteEpargne> compteEpargne = new HashMap<>();
    final private Map<Integer, CompteCourant> compteCourant = new HashMap<>();
    final private PropertyChangeListener epargne = new EpargneListener(this);
    final private PropertyChangeListener alimentation = new AlimentationListener(this);
    final private Timer agenda = new Timer("Interet");// pour les événements temporels


    public BanqueContext() {
    }
    public void close() {
        agenda.cancel();
    }

    public void debiter(Compte c, float debit) {
        Date date = new Date();
        c.setSolde(c.getSolde() - debit);
        Operation op = new Operation(this.getMaxIdOperation() + 1, date, -debit, TypeOperation.CB, c, c);
        this.addOperation(op);
    }

    public void crediter(Compte c, Compte d, float credit) {
        if (d.getSolde() < credit) {
            System.out.println("Credit impossible");
        } else {
            Date date = new Date();
            c.setSolde(c.getSolde() + credit);
            d.setSolde(d.getSolde() - credit);

            Operation opCredit = new Operation(this.getMaxIdOperation() + 1, date, credit, TypeOperation.CB, d, c);
            this.addOperation(opCredit);

            Operation opDebit = new Operation(this.getMaxIdOperation() + 1, date, -credit, TypeOperation.CB, c, d);
            this.addOperation(opDebit);
        }
    }

    public Integer getMaxIdCompteCourant() {
        if (!compteCourant.isEmpty()) {
            Set<Integer> s = compteCourant.keySet();
            return (Collections.max(s));
        } else return 0;

    }

    public Integer getMaxIdCompteEpargne() {
        if (!compteEpargne.isEmpty()) {
            Set<Integer> s = compteEpargne.keySet();
            return (Collections.max(s));
        } else return 0;

    }

    public Integer getMaxIdOperation() {
        if (!operation.isEmpty()) {
            Set<Integer> s = operation.keySet();
            return (Collections.max(s));
        } else return 0;

    }

    public void addCompteCourant(CompteCourant c) {
        c.addPropertyChangeListener("solde", alimentation);
        c.addPropertyChangeListener("seuilMin", alimentation);
        c.addPropertyChangeListener("epargne", epargne);
        compteCourant.put(c.getIdCompte(), c);
    }

    public void addCompteEpargne(CompteEpargne c) {
        compteEpargne.put(c.getIdCompte(), c);
        agenda.schedule(new AjoutInteret(c, this), 0, 100);
    }

    public void addOperation(Operation o) {
        operation.put(o.getIdOperation(), o);
    }

    public CompteCourant getCompteCourant(Integer id) {
        return compteCourant.get(id);
    }

    public Collection<CompteCourant> getCompteCourants() {
        return compteCourant.values();
    }

    public CompteEpargne getCompteEpargne(Integer id) {
        return compteEpargne.get(id);
    }

    public Collection<CompteEpargne> getCompteEpargnes() {
        return compteEpargne.values();
    }

    public Operation getOperation(Integer id) {
        return operation.get(id);
    }

    public Collection<Operation> getOperations() {
        return operation.values();
    }

    public Timer getAgenda() {
        return agenda;
    }
}
