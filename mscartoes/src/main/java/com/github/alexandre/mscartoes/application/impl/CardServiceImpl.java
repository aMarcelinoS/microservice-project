package com.github.alexandre.mscartoes.application.impl;

import com.github.alexandre.mscartoes.application.CardService;
import com.github.alexandre.mscartoes.application.impl.exceptions.ObjectNotFoundException;
import com.github.alexandre.mscartoes.domain.Card;
import com.github.alexandre.mscartoes.infra.repository.CardRepository;
import com.github.alexandre.mscartoes.application.impl.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository repository;

    @Override
    public Card save(Card card) {
        if(repository.findById(card.getId()).isPresent()){
           throw new DataIntegrityViolationException("Cartão já existente na base de dados!");
        }
        return repository.save(card);
    }

    @Override
    public Card findById(Long id) {
        Optional<Card> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cartão não existe na base de dados!"));
    }

    @Override
    public Optional<List<Card>> ListCardsForIncome(Long income) {
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);

        return Optional.ofNullable(repository.findByIncomeLessThanEqual(incomeBigDecimal));
    }
}
