package org.bank.authentification;

import org.bank.entite.User;
import org.bank.compte.CompteController;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class AuthService {

    private final Set<User> users = new HashSet<>();
    private User currentUser;
    AuthController authController = new AuthController(this);
    CompteController compteController = new CompteController(this,authController);

    public boolean register(String fullName, String email, String password) {
        if (password.length() < 6) {
            System.out.println("Mot de passe trop court !");
            return false;
        }

        if (findByEmail(email).isPresent()) {
            System.out.println("Email déjà utilisé !");
            return false;
        }

        User user = new User(UUID.randomUUID(), fullName, email, hashPassword(password));
        users.add(user);

        System.out.println("Inscription réussie !");
        return true;
    }

    public boolean login(String email, String password) {
        Optional<User> userOpt = findByEmail(email);
        if (userOpt.isPresent() && userOpt.get().getPasswordHash().equals(hashPassword(password))) {
            currentUser = userOpt.get();
            System.out.println("Connecté en tant que " + currentUser.getFullName());
            showMenuCompte();
            return true;
        }
        System.out.println("Email ou mot de passe incorrect !");
        return false;
    }

    private void showMenuCompte() {
        compteController.showMenu();
    }


    public void logout() {
        if (currentUser != null) {
            System.out.println("Déconnexion de " + currentUser.getFullName());
            currentUser = null;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    private String hashPassword( String password) {
        return Integer.toHexString(password.hashCode());
    }


}
