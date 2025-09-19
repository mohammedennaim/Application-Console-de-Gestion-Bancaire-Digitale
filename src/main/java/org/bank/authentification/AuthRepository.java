package org.bank.authentification;

import org.bank.entite.User;

import java.util.Optional;

public interface AuthRepository {

    Optional<User> findByEmail(String email);

    void save(User user);
}
