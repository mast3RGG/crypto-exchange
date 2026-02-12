package com.exchange.core.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "wallets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wallet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asset_symbol" , nullable = false)
    private Asset asset;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "wallet")
    private List<Transaction> transactions;

    @Column(name = "balance" , precision = 19 , scale = 8)
    private BigDecimal balance;

    @Column(name = "locked_money", precision = 19 , scale = 8)
    private BigDecimal lockedMoney;



}
