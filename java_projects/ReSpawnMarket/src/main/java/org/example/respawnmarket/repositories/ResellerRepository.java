package org.example.respawnmarket.repositories;

import com.google.common.base.Optional;
import org.example.respawnmarket.entities.ResellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResellerRepository extends JpaRepository<ResellerEntity, Integer>
{
    // SELECT * FROM reseller WHERE username = ? LIMIT 1;
    Optional<ResellerEntity> findByUsername(String username);
}
