package org.bank.compte;

import org.bank.entite.Compte;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class CompteService {
    private final CompteRepository repository;

    public CompteService(CompteRepository repository) {
        this.repository = repository;
    }

    // Crée un nouveau compte avec UUID aléatoire et solde = 0
    public Compte create() {
        String accountId = UUID.randomUUID().toString();
        UUID ownerUserId = UUID.randomUUID();
        BigDecimal solde = BigDecimal.ZERO;

        Compte nouveauCompte = new Compte(
                accountId,
                ownerUserId,
                solde,
                Instant.now(),
                true
        );

        repository.save(nouveauCompte);
        return nouveauCompte;
    }

    // Afficher tous les comptes
    public void afficherTous() {
        repository.findAll().forEach(compte -> {
            System.out.println("Compte ID: " + compte.getAccountId() +
                    " | Propriétaire: " + compte.getOwnerUserId() +
                    " | Solde: " + compte.getBalance() +
                    " | Créé le: " + compte.getCreatedAt() +
                    " | Actif: " + compte.getActive());
        });
    }

    // Récupérer un compte par son ID
    public Compte getById(String accountId) {
        Optional<Compte> compteOpt = repository.findById(accountId);
        return compteOpt.orElse(null);
    }

    // Mettre à jour solde
    public void updateSolde(Compte compte, BigDecimal nouveauSolde) {
        if (compte != null) {
            compte.setBalance(nouveauSolde);
        }
    }

    // Bloquer un compte
    public void block(Compte compte) {
        if (compte != null) {
            compte.setActive(false);
        }
    }
}
