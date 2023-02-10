package com.example.kabutops_trumps.repositories;

import com.example.kabutops_trumps.models.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, Long> {


}
