package com.github.alexandre.mscartoes.domain;

import com.github.alexandre.mscartoes.domain.enums.FlagCard;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private FlagCard flagCard;
    private BigDecimal income;
    private BigDecimal cardLimit;

    public Card(String name, FlagCard flagCard, BigDecimal income, BigDecimal cardLimit) {
        this.id = id;
        this.name = name;
        this.flagCard = flagCard;
        this.income = income;
        this.cardLimit = cardLimit;
    }
}
