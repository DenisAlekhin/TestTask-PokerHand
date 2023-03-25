package org.poker.hand.service;

import org.junit.jupiter.api.Test;
import org.poker.hand.util.card.CardValue;
import org.poker.hand.util.poker.hand.HandCombination;
import org.poker.hand.util.poker.hand.HandStrength;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HandStrengthServiceTest {
    @Autowired
    private HandStrengthService handStrengthService;
    @Autowired
    private PokerHandService pokerHandService;

    @Test
    public void straightFlashTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 3H 4H 5H 6H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.STRAIGHT_FLUSH, handStrength.handCombination());
        assertEquals(CardValue.SIX, handStrength.topCard());
    }
    @Test
    public void notStraightFlashTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 3D 4H 5S 6H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertNotEquals(HandCombination.STRAIGHT_FLUSH, handStrength.handCombination());
    }

    @Test
    public void notSequenceStraightFlashTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 4H 5H 6H 7H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertNotEquals(HandCombination.STRAIGHT_FLUSH, handStrength.handCombination());
    }

    @Test
    public void notSequenceLastElementStraightFlashTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 3H 4H 5H 7H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertNotEquals(HandCombination.STRAIGHT_FLUSH, handStrength.handCombination());
    }

    @Test
    public void fourOfAKindFromBackTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("6H AH AC AD AS");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.FOUR_OF_A_KIND, handStrength.handCombination());
        assertEquals(CardValue.ACE, handStrength.topCard());
    }

    @Test
    public void fourOfAKindFromStartTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("5H 5C 5D 5S AD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.FOUR_OF_A_KIND, handStrength.handCombination());
        assertEquals(CardValue.FIVE, handStrength.topCard());
    }

    @Test
    public void fullHouseTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("7D 7H KH KS KD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.FULL_HOUSE, handStrength.handCombination());
        assertEquals(CardValue.KING, handStrength.topCard());
    }

    @Test
    public void fullHouseReverseTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("7H 7S 7D KD KH");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.FULL_HOUSE, handStrength.handCombination());
        assertEquals(CardValue.KING, handStrength.topCard());
    }

    @Test
    public void flushTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 3H 4H 5H 9H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.FLUSH, handStrength.handCombination());
        assertEquals(CardValue.NINE, handStrength.topCard());
    }

    @Test
    public void straightTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3S 4H 5D 6H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.STRAIGHT, handStrength.handCombination());
        assertEquals(CardValue.SIX, handStrength.topCard());
    }

    @Test
    public void threeOfAKindInCentreTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D QS QH QD 6H");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.THREE_OF_A_KIND, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void threeOfAKindFromLeftTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("QS QH QD KH AD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.THREE_OF_A_KIND, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void threeOfAKindFromRightTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3D QS QH QD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.THREE_OF_A_KIND, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void twoPairsFromLeftTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 2H 3S 3H QD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.TWO_PAIRS, handStrength.handCombination());
        assertEquals(CardValue.THREE, handStrength.topCard());
    }

    @Test
    public void twoPairsFromBothSidesTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 2H 3S QH QD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.TWO_PAIRS, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void twoPairsFromRightTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3H 3S QH QD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.TWO_PAIRS, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void pairFromLeftTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 2H 3S QH KD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.PAIR, handStrength.handCombination());
        assertEquals(CardValue.TWO, handStrength.topCard());
    }

    @Test
    public void pairFromLeftSecondTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3H 3S QH KD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.PAIR, handStrength.handCombination());
        assertEquals(CardValue.THREE, handStrength.topCard());
    }

    @Test
    public void pairFromLeftThirdTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3H QS QH KD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.PAIR, handStrength.handCombination());
        assertEquals(CardValue.QUEEN, handStrength.topCard());
    }

    @Test
    public void pairFromRightTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3H QS KH KD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.PAIR, handStrength.handCombination());
        assertEquals(CardValue.KING, handStrength.topCard());
    }

    @Test
    public void highCardTest(){
        PokerHand pokerHand = pokerHandService.parsePokerHand("2D 3H QS KH AD");
        HandStrength handStrength = handStrengthService.getHandStrength(pokerHand);
        assertEquals(HandCombination.HIGH_CARD, handStrength.handCombination());
        assertEquals(CardValue.ACE, handStrength.topCard());
    }
}