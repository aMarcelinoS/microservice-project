package com.github.alexandre.mscartoes.domain;

import com.github.alexandre.mscartoes.domain.enums.FlagCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private FlagCard flagCard;
    private BigDecimal cardLimit;
    private BigDecimal income;
}
