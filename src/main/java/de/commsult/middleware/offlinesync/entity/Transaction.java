package de.commsult.middleware.offlinesync.entity;

import de.commsult.middleware.offlinesync.enums.TransactionStatus;
import de.commsult.middleware.offlinesync.enums.TransactionType;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @JsonProperty("transaction_id")
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private UUID transactionID;

    // @JsonProperty("fruit_id")
    @Column(name = "fruit_id", updatable = false, nullable = false)
    private UUID fruitID;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Column(name = "type", nullable = false)
    private TransactionType type;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    // @JsonProperty("transaction_date")
    @Column(name = "transaction_date", updatable = false, nullable = false)
    protected Instant transactionDate;

}
