package com.github.alexandre.mscartoes.application;

import com.github.alexandre.mscartoes.application.dto.CardDto;
import com.github.alexandre.mscartoes.application.impl.CardServiceImpl;
import com.github.alexandre.mscartoes.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cards")
public class CardResource {

    @Autowired
    private CardServiceImpl service;

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity<CardDto> registryCard(@RequestBody CardDto obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(service.save(obj))
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<Optional<List<Card>>> getCardForIncome(@RequestParam Long income) {
        Optional<List<Card>> listCard = service.getListCardsForIncome(income);
        return ResponseEntity.ok(listCard);
    }
}
