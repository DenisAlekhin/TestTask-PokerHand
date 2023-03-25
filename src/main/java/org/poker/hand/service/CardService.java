package org.poker.hand.service;

import org.poker.hand.util.card.Card;
import org.poker.hand.util.card.CardSuit;
import org.poker.hand.util.card.CardValue;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CardService  {
    public static final String WRONG_ARGUMENT_MESSAGE = "Card can't be created: wrong argument";

    public Card parseCard(String card) {
        if(Objects.isNull(card) || card.length() != 2) {
            throw new IllegalArgumentException(WRONG_ARGUMENT_MESSAGE);
        }
        try{
            return new Card(CardValue.byValue(card.charAt(0)),CardSuit.byValue(card.charAt(1)));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(WRONG_ARGUMENT_MESSAGE);
        }
    }
}
