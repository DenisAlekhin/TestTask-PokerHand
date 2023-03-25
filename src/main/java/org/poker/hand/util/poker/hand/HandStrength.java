package org.poker.hand.util.poker.hand;

import org.poker.hand.util.card.CardValue;

public record HandStrength(HandCombination handCombination, CardValue topCard) {
}
