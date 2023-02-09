package com.example.kabutops_trumps.repositories;

import com.example.kabutops_trumps.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
