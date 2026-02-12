package com.exchange.core.models.entities;

import com.exchange.core.models.enums.AssetsType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.type.descriptor.jdbc.JsonAsStringJdbcType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @Column(name = "amount" , nullable = false , precision = 19, scale = 8)
    private BigDecimal amount;

    @CreationTimestamp
    @Column(name = "created_at" , nullable = false , updatable = false)
    private LocalDateTime createdAt;
    
}
