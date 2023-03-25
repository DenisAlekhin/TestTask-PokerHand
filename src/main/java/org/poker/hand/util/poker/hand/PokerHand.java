package org.poker.hand.util.poker.hand;

import org.poker.hand.util.card.Card;

import java.util.List;


public record PokerHand(List<Card> hand) {
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\"");
        for(int i = 0; i < hand.size(); i++) {
            builder.append(hand.get(i));
            if(i != hand.size() - 1) {
                builder.append(" ");
            }
        }
        builder.append("\"");
        return builder.toString();
    }
}
