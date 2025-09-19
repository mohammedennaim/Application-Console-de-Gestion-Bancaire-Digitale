package org.bank.entite;

import java.util.Objects;
import java.util.UUID;

public class User {
    private static UUID id;
    private static String fullName;
    private static String email;
    private static String passwordHash;

    public User(UUID id, String fullName, String email, String passwordHash) {
        this.id = id;
        this.fullName = fullName;
        this.email = email.toLowerCase();
        this.passwordHash = passwordHash;
    }

    public static UUID getId() { return id; }
    public static String getFullName() { return fullName; }
    public static String getEmail() { return email; }
    public static String getPasswordHash() { return passwordHash; }

    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email.toLowerCase(); }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(email, user.email);
    }

    public int hashCode() {
        return Objects.hash(email);
    }
}
