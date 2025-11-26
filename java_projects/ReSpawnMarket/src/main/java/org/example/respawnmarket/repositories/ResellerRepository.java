package org.example.respawnmarket.repositories;

import org.example.respawnmarket.entities.ResellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ResellerRepository extends JpaRepository<ResellerEntity, Integer>
{
    @Query("""
        SELECT r 
        FROM ResellerEntity r 
        WHERE r.username = :username
    """)
    Optional<ResellerEntity> findByUsername(String username);
}
