package com.github.alexandre.mscartoes.application;

import com.github.alexandre.mscartoes.application.dto.CardDto;
import com.github.alexandre.mscartoes.domain.Card;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface CardService {

    @Transactional
    Card save(CardDto cardDto);
    Card findById(Long id);
    Optional<List<Card>> getListCardsForIncome(Long income);
}
