package org.poker.hand.service;


import org.poker.hand.util.card.CardValue;
import org.poker.hand.util.poker.hand.HandCombination;
import org.poker.hand.util.poker.hand.HandStrength;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HandStrengthService {

    public HandStrength getHandStrength(PokerHand pokerHand) {
        if(isStraightFlush(pokerHand)) {
            return getStraightFlushHandStrength(pokerHand);
        } else if(isFourOfAKind(pokerHand)) {
            return getFourOfAKindHandStrength(pokerHand);
        } else if(isFullHouse(pokerHand)) {
            return getFullHouseHandStrength(pokerHand);
        } else if(isFlush(pokerHand)) {
            return getFlushHandStrength(pokerHand);
        } else if(isStraight(pokerHand)) {
            return getStraightHandStrength(pokerHand);
        } else if(isThreeOfAKind(pokerHand)) {
            return getThreeOfAKindHandStrength(pokerHand);
        } else if(isTwoPairs(pokerHand)) {
            return getTwoPairsHandStrength(pokerHand);
        } else if(isPair(pokerHand)) {
            return getPairHandStrength(pokerHand);
        }


        return new HandStrength(HandCombination.HIGH_CARD, pokerHand.hand().get(4).value());
    }

    private boolean isStraightFlush(PokerHand pokerHand) {
        // "2H 3H 4H 5H 6H"
        for(int i = 0; i < pokerHand.hand().size() - 1; i++) {
            if(!(Objects.equals(pokerHand.hand().get(i).value().compareTo(pokerHand.hand().get(i + 1).value()), -1) &&
                    Objects.equals(pokerHand.hand().get(i).suit(), pokerHand.hand().get(i + 1).suit()))) {
                return false;
            }
        }

        return true;
    }

    private HandStrength getStraightFlushHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.STRAIGHT_FLUSH, pokerHand.hand().get(4).value());
    }

    private boolean isFourOfAKind(PokerHand pokerHand) {
        // "5x 5x 5x 5x xx"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value()) &&
                pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value())) {
            return true;
        }

        // "xx Ax Ax Ax Ax"
            if(pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value()) &&
                    pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value()) &&
                    pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        return false;
    }

    private HandStrength getFourOfAKindHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.FOUR_OF_A_KIND, pokerHand.hand().get(2).value());
    }

    private boolean isFullHouse(PokerHand pokerHand) {
        // "2x 2x 3x 3x 3x"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value()) &&
                pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        // "3x 3x 3x Kx Kx"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value()) &&
                pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        return false;
    }

    private HandStrength getFullHouseHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.FULL_HOUSE, pokerHand.hand().get(4).value());
    }

    private boolean isFlush(PokerHand pokerHand) {
        // "xH xH xH xH xH"
        for(int i = 0; i < pokerHand.hand().size() - 1; i++) {
            if(!Objects.equals(pokerHand.hand().get(i).suit(), pokerHand.hand().get(i + 1).suit())) {
                return false;
            }
        }

        return true;
    }

    private HandStrength getFlushHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.FLUSH, pokerHand.hand().get(4).value());
    }

    private boolean isStraight(PokerHand pokerHand) {
        // "2x 3x 4x 5x 6x"
        for(int i = 0; i < pokerHand.hand().size() - 1; i++) {
            if(!Objects.equals(pokerHand.hand().get(i).value().compareTo(pokerHand.hand().get(i + 1).value()), -1)) {
                return false;
            }
        }

        return true;
    }

    private HandStrength getStraightHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.STRAIGHT, pokerHand.hand().get(4).value());
    }

    private boolean isThreeOfAKind(PokerHand pokerHand) {
        // "2x 2x 2x xx xx"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value())) {
            return true;
        }

        // "xx 3x 3x 3x xx"
        if(pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value()) &&
                pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value())) {
            return true;
        }

        // "xx xx 6x 6x 6x"
        if(pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value()) &&
                pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        return false;
    }

    private HandStrength getThreeOfAKindHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.THREE_OF_A_KIND, pokerHand.hand().get(2).value());
    }

    private boolean isTwoPairs(PokerHand pokerHand) {
        // "2x 2x 6x 6x xx"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(2).value().equals(pokerHand.hand().get(3).value())) {
            return true;
        }

        // "2x 2x xx Kx Kx"
        if(pokerHand.hand().get(0).value().equals(pokerHand.hand().get(1).value()) &&
                pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        // "xx 3x 3x Kx Kx"
        if(pokerHand.hand().get(1).value().equals(pokerHand.hand().get(2).value()) &&
                pokerHand.hand().get(3).value().equals(pokerHand.hand().get(4).value())) {
            return true;
        }

        return false;
    }

    private HandStrength getTwoPairsHandStrength(PokerHand pokerHand) {
        return new HandStrength(HandCombination.TWO_PAIRS, pokerHand.hand().get(3).value());
    }

    private boolean isPair(PokerHand pokerHand) {
        // "5x 5x xx xx xx"
        // "xx 5x 5x xx xx"
        // "xx xx 5x 5x xx"
        // "xx xx xx 5x 5x"
        for(int i = 0; i < pokerHand.hand().size() - 1; i++) {
            if(Objects.equals(pokerHand.hand().get(i).value(), pokerHand.hand().get(i + 1).value())) {
                return true;
            }
        }

        return false;
    }

    private HandStrength getPairHandStrength(PokerHand pokerHand) {
        CardValue cardValue = CardValue.TWO;
        for(int i = 0; i < pokerHand.hand().size() - 1; i++) {
            if(Objects.equals(pokerHand.hand().get(i).value(), pokerHand.hand().get(i + 1).value())) {
                cardValue = pokerHand.hand().get(i).value();
            }
        }

        return new HandStrength(HandCombination.PAIR, cardValue);
    }
}
