package org.bank.entite;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class Compte {
    private String accountId;
    private UUID ownerUserId;
    private BigDecimal balance;
    private Instant createdAt;
    private boolean active;

    public Compte(String accountId, UUID ownerUserId, BigDecimal balance, Instant createdAt, Boolean isActive) {
        this.accountId = accountId;
        this.ownerUserId = ownerUserId;
        this.balance = balance;
        this.createdAt = createdAt;
        this.active = isActive;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public UUID getOwnerUserId() {
        return ownerUserId;
    }
    public void setOwnerUserId(UUID ownerUserId) {
        this.ownerUserId = ownerUserId;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

}
