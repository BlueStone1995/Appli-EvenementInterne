package appli.banqueJamasse;

import java.beans.PropertyChangeListener;
import java.util.*;

public class BanqueContext {

    final private Map<Integer, Operation> operation = new HashMap<>();
    final private Map<Integer, CompteEpargne> compteEpargne = new HashMap<>();
    final private Map<Integer, CompteCourant> compteCourant = new HashMap<>();
    final private PropertyChangeListener epargne = new EpargneListener(this);
    final private PropertyChangeListener alimentation = new AlimentationListener(this);


    public BanqueContext() {
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
        compteCourant.put(c.getIdCompte(), c);
    }

    public void addCompteEpargne(CompteEpargne c) {
        c.addPropertyChangeListener("epargne", epargne);
        compteEpargne.put(c.getIdCompte(), c);
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

}
