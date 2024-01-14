package com.github.alexandre.mscartoes.infra.repository;

import com.github.alexandre.mscartoes.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByIncomeLessThanEqual(BigDecimal income);
}
