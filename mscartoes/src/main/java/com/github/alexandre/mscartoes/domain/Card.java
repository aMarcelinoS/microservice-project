package com.github.alexandre.mscartoes.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@Getter @Setter
public class Card {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal limit;
    private BigDecimal income;

}
