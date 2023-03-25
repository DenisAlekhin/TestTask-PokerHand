package org.poker.hand.comparator;


import lombok.RequiredArgsConstructor;
import org.poker.hand.service.HandStrengthService;
import org.poker.hand.util.poker.hand.HandCombination;
import org.poker.hand.util.poker.hand.HandStrength;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class PokerHandComparator implements Comparator<PokerHand> {
    private final HandStrengthService handStrengthService;

    private static Map<HandCombination, Integer> handCombinationStrength;
    static {
        handCombinationStrength = new HashMap<>();
        handCombinationStrength.put(HandCombination.HIGH_CARD, 2);
        handCombinationStrength.put(HandCombination.PAIR, 3);
        handCombinationStrength.put(HandCombination.TWO_PAIRS, 4);
        handCombinationStrength.put(HandCombination.THREE_OF_A_KIND, 5);
        handCombinationStrength.put(HandCombination.STRAIGHT, 6);
        handCombinationStrength.put(HandCombination.FLUSH, 7);
        handCombinationStrength.put(HandCombination.FULL_HOUSE, 8);
        handCombinationStrength.put(HandCombination.FOUR_OF_A_KIND, 9);
        handCombinationStrength.put(HandCombination.STRAIGHT_FLUSH, 10);
    }
    
    
    @Override
    public int compare(PokerHand p1, PokerHand p2) {
        HandStrength handStrengthP1 = handStrengthService.getHandStrength(p1);
        HandStrength handStrengthP2 = handStrengthService.getHandStrength(p2);

        if(!(handCombinationStrength.containsKey(handStrengthP1.handCombination()) &&
                handCombinationStrength.containsKey(handStrengthP2.handCombination()))) {
            throw new IllegalArgumentException("Wrong arguments");
        }

        if(Objects.equals(handStrengthP1.handCombination(), handStrengthP2.handCombination())) {
            return handStrengthP1.topCard().compareTo(handStrengthP2.topCard());
        } else {
            return handCombinationStrength.get(handStrengthP1.handCombination()) -
                    handCombinationStrength.get(handStrengthP2.handCombination());
        }
    }


}
