package com.example.kabutops_trumps.repositories;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnershipRepository extends JpaRepository<Ownership, Long> {

    List<Ownership> findByAccountAndInDeckTrue(Account account);
}
