package com.example.kabutops_trumps.repositories;

import com.example.kabutops_trumps.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

}
