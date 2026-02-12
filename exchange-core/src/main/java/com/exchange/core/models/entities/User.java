package com.exchange.core.models.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user"  , cascade =  CascadeType.ALL)
    private List<Wallet> walletList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @Column(name = "username" , unique = true, nullable = false)
    private String username;

    @Size(min = 8)
    @Column (name = "password" , nullable = false)
    private String password;

    @Email
    @Column(name = "email" , nullable = false , unique = true)
    private String email;

    @Column(name = "full_name" , nullable = false)
    private String fullName;

    @Column(name = "phone" , nullable = false)
    private String phone;

    @Column(name = "verified" , nullable = false)
    private boolean verified;


    @CreationTimestamp
    @Column(name = "created_at" , nullable = false , updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Version
    private Long version;

}
