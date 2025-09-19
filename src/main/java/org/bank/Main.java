package org.bank;

import org.bank.authentification.AuthController;
import org.bank.authentification.AuthService;
import org.bank.compte.CompteController;
import org.bank.compte.CompteService;


public class Main {

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        AuthController authController = new AuthController(authService);

        CompteController compteController = new CompteController(authService,authController);

        authController.showMenu();
    }
}
