package com.example.kabutops_trumps.repositories;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Ownership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByOwnershipsAccountAndOwnershipsInDeckTrue(Account account);

    List<Card> findByOwnershipsAccount(Account account);

}
