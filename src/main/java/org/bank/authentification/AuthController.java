package org.bank.authentification;

import java.util.Scanner;
import org.bank.compte.CompteController;

public class AuthController {
    private final AuthService authService;
    private final Scanner scanner = new Scanner(System.in);
    private CompteController compteController;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("0. Exit");

            System.out.print("Choix: ");
            int choice = readInt();

            switch (choice) {
                case 1 -> handleRegister();
                case 2 -> handleLogin();
                case 3 -> authService.logout();
                case 0 -> {
                    System.out.println("Au revoir !");
                    return;
                }
                default -> System.out.println("Choix invalide !");
            }
        }
    }

    private void handleRegister() {
        System.out.print("Nom complet: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String pass = scanner.nextLine();

        authService.register(name, email, pass);
    }

    private boolean handleLogin() {
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Mot de passe: ");
        String pass = scanner.nextLine();

        authService.login(email, pass);
        return false;
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrée invalide. Réessayer: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
