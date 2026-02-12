package com.exchange.core.repo;

import com.exchange.core.models.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletDao extends JpaRepository<Wallet, Long> {
}
