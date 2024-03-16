package com.github.alexandre.mscartoes.application.dto;

import com.github.alexandre.mscartoes.domain.Card;
import com.github.alexandre.mscartoes.domain.enums.FlagCard;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class CardDto {

    private String name;
    private FlagCard flagCard;
    private BigDecimal cardLimit;
    private BigDecimal income;

    public CardDto() {
    }

    public CardDto(Card obj) {
        this.name = obj.getName();
        this.flagCard = obj.getFlagCard();
        this.income = obj.getIncome();
        this.cardLimit = obj.getCardLimit();
    }
}
