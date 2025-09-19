package org.bank.entite;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.Instant;
import java.util.UUID;

public class Transaction {
    private UUID id;
    private Instant timestamp;
    private String accountId;
    private BigDecimal amount;
    private String counterpartyAccountId;
    private String description;

    public Transaction(UUID id, Instant timestamp, String accountId, BigDecimal amount, String counterpartyAccountId, String description) {
        this.id = id;
        this.timestamp = timestamp;
        this.accountId = accountId;
        this.amount = amount;
        this.counterpartyAccountId = counterpartyAccountId;
        this.description = description;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getCounterpartyAccountId() {
        return counterpartyAccountId;
    }
    public void setCounterpartyAccountId(String counterpartyAccountId) {
        this.counterpartyAccountId = counterpartyAccountId;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
