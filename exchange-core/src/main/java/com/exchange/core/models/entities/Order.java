package com.exchange.core.models.entities;

import com.exchange.core.models.enums.OrderSide;
import com.exchange.core.models.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @Column (name = "pair" , nullable = false)
    private String pair;

    @Enumerated(EnumType.STRING)
    @Column(name = "side" , nullable = false)
    private OrderSide side;

    @Column(name = "price" , nullable = false , precision =  19, scale = 8)
    private BigDecimal price;

    @Column(name = "amount" , nullable = false , precision =  19, scale = 8)
    private BigDecimal amount;

    @Column(name = "filled" , nullable = false , precision =  19, scale = 8)
    private BigDecimal filled;

    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false)
    private OrderStatus status;


    @CreationTimestamp
    @Column(name = "created_at" , nullable = false , updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
