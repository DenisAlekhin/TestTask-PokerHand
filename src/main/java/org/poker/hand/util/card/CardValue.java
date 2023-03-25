package org.poker.hand.util.card;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum CardValue {
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    TEN('T'),
    JACK('J'),
    QUEEN('Q'),
    KING('K'),
    ACE('A');

    private final Character cardValue;

    public static CardValue byValue(char value) {
        for(CardValue v: values()) {
            if(Objects.equals(v.cardValue, value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Wrong value");
    }
}
