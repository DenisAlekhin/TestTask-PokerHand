package org.poker.hand.comparator;

import org.poker.hand.util.card.Card;
import org.poker.hand.util.card.CardValue;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
public class CardValueComparator implements Comparator<Card> {
    private static Map<CardValue, Integer> cardStrength;
    static {
        cardStrength = new HashMap<>();
        cardStrength.put(CardValue.TWO, 2);
        cardStrength.put(CardValue.THREE, 3);
        cardStrength.put(CardValue.FOUR, 4);
        cardStrength.put(CardValue.FIVE, 5);
        cardStrength.put(CardValue.SIX, 6);
        cardStrength.put(CardValue.SEVEN, 7);
        cardStrength.put(CardValue.EIGHT, 8);
        cardStrength.put(CardValue.NINE, 9);
        cardStrength.put(CardValue.TEN, 10);
        cardStrength.put(CardValue.JACK, 11);
        cardStrength.put(CardValue.QUEEN, 12);
        cardStrength.put(CardValue.KING, 13);
        cardStrength.put(CardValue.ACE, 14);
    }

    @Override
    public int compare(Card c1, Card c2) {
        if(!(cardStrength.containsKey(c1.value()) && cardStrength.containsKey(c2.value()))) {
            throw new IllegalArgumentException("Wrong arguments");
        }
        return cardStrength.get(c1.value()) - cardStrength.get(c2.value());
    }

}
