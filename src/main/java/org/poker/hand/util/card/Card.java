package org.poker.hand.util.card;

public record Card(CardValue value, CardSuit suit) {
    @Override
    public String toString() {
        return value.getCardValue().toString() + suit.getCardSuit().toString();
    }
}
