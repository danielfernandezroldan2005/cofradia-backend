package com.api.inventary_and_loans.repositories;

import com.api.inventary_and_loans.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    // We have some methods such as
    // save(), findAll(), findById(), deleteById().
}
