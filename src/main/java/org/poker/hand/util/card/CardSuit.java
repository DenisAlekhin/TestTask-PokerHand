package org.poker.hand.util.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum CardSuit {
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D'),
    CLUBS('C');

    private final Character cardSuit;

    public static CardSuit byValue(char value) {
        for(CardSuit s: values()) {
            if(Objects.equals(s.cardSuit, value)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Wrong value");
    }
}
