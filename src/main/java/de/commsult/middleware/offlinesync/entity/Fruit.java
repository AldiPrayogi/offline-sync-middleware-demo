package de.commsult.middleware.offlinesync.entity;

import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fruits")
@Getter
@Setter
public class Fruit {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fruit_id", updatable = false, nullable = false)
	private UUID fruitID;

	@CreationTimestamp
	@Column(name = "created_at", updatable = false, nullable = false)
	protected OffsetDateTime createdAt = OffsetDateTime.now();

	@UpdateTimestamp
	@Column(name = "modified_at")
	protected OffsetDateTime modifiedAt;

    @Column(name = "fruit_name", nullable = false)
    private String fruitName;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "expiration_date", nullable = false)
    private OffsetDateTime expirationDate;

    @Column(name = "sync_version", nullable = false)
    private int syncVersion;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
