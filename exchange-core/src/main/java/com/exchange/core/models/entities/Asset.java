package com.exchange.core.models.entities;

import com.exchange.core.models.enums.AssetsType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "assets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Asset {
    @Id
    @Column(name = "symbol")
    private String symbol;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AssetsType type;

    @OneToMany(mappedBy = "asset")
    private List<Wallet> walletList;


    @Column(name = "decimal_precision" , nullable = false)
    private int decimalPrecision;

}
