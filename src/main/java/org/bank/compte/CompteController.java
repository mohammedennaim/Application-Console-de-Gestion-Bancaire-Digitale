package org.bank.compte;

import org.bank.authentification.AuthController;
import org.bank.authentification.AuthService;
import org.bank.entite.Compte;

import java.math.BigDecimal;
import java.util.Scanner;

public class CompteController {
    private final CompteService compteService;
    private final AuthService authService;
    private final AuthController authController;
    private final Scanner scanner = new Scanner(System.in);

    public CompteController(AuthService authService, AuthController authController) {
        CompteRepository repository = new CompteRepository();
        this.compteService = new CompteService(repository);
        this.authService = authService;
        this.authController = authController;
    }

    public void showMenu() {
        int choix;
        do {
            System.out.println("\n==== MENU COMPTE ====");
            System.out.println("1. Afficher mes comptes");
            System.out.println("2. Créer un compte");
            System.out.println("3. Afficher solde d’un compte");
            System.out.println("4. Ajouter à un compte");
            System.out.println("5. Retirer d’un compte");
            System.out.println("6. Bloquer un compte");
            System.out.println("0. Exit");
            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // éviter bug scanner

            switch (choix) {
                case 1 -> compteService.afficherTous();
                case 2 -> {
                    compteService.create();
                    System.out.println("✅ Compte créé !");
                }
                case 3 -> afficherSolde();
                case 4 -> ajouter();
                case 5 -> retirer();
                case 6 -> bloquerCompte();
                case 0 -> System.out.println("Au revoir!");
                default -> System.out.println("❌ Option invalide!");
            }
        } while (choix != 0);
    }

    private void afficherSolde() {
        System.out.print("➡️ Entrez l’ID du compte : ");
        String id = scanner.nextLine();
        Compte compte = compteService.getById(id);

        if (compte != null) {
            System.out.println("💰 Solde du compte " + compte.getAccountId() + " : " + compte.getBalance());
        } else {
            System.out.println("❌ Compte introuvable !");
        }
    }

    private void ajouter() {
        System.out.print("➡️ Entrez l’ID du compte : ");
        String id = scanner.nextLine();
        Compte compte = compteService.getById(id);

        if (compte == null) {
            System.out.println("❌ Compte introuvable !");
            return;
        }

        System.out.print("Montant à ajouter : ");
        BigDecimal montant = scanner.nextBigDecimal();

        if (montant.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("❌ Montant invalide !");
            return;
        }

        BigDecimal nouveauSolde = compte.getBalance().add(montant);
        compteService.updateSolde(compte, nouveauSolde);

        System.out.println("✅ Nouveau solde : " + nouveauSolde);
    }

    private void retirer() {
        System.out.print("➡️ Entrez l’ID du compte : ");
        String id = scanner.nextLine();
        Compte compte = compteService.getById(id);

        if (compte == null) {
            System.out.println("❌ Compte introuvable !");
            return;
        }

        System.out.print("Montant à retirer : ");
        BigDecimal montant = scanner.nextBigDecimal();

        if (montant.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("❌ Montant invalide !");
            return;
        }

        if (montant.compareTo(compte.getBalance()) > 0) {
            System.out.println("❌ Solde insuffisant !");
            return;
        }

        BigDecimal nouveauSolde = compte.getBalance().subtract(montant);
        compteService.updateSolde(compte, nouveauSolde);

        System.out.println("✅ Nouveau solde : " + nouveauSolde);
    }

    private void bloquerCompte() {
        System.out.print("➡️ Entrez l’ID du compte : ");
        String id = scanner.nextLine();
        Compte compte = compteService.getById(id);

        if (compte != null) {
            compteService.block(compte);
            System.out.println("✅ Compte bloqué !");
        } else {
            System.out.println("❌ Compte introuvable !");
        }
    }
}
