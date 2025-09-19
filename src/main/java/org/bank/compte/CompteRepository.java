package org.bank.compte;

import org.bank.entite.Compte;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CompteRepository {
    private final Set<Compte> comptes = new HashSet<>();

    // Ajouter un compte
    public void save(Compte compte) {
        comptes.add(compte);
    }

    // Récupérer tous les comptes
    public Set<Compte> findAll() {
        return comptes;
    }

    // Trouver un compte par ID
    public Optional<Compte> findById(String accountId) {
        return comptes.stream()
                .filter(c -> c.getAccountId().equals(accountId))
                .findFirst();
    }

    // Supprimer un compte
    public void delete(Compte compte) {
        comptes.remove(compte);
    }
}
