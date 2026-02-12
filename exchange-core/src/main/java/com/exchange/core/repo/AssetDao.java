package com.exchange.core.repo;

import com.exchange.core.models.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetDao extends JpaRepository<Asset, Long> {
}
