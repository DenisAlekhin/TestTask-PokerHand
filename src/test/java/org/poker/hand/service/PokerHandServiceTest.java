package org.poker.hand.service;

import org.junit.jupiter.api.Test;
import org.poker.hand.util.card.CardSuit;
import org.poker.hand.util.card.CardValue;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class PokerHandServiceTest {
    @Autowired
    private PokerHandService pokerHandService;

    @Test
    public void emptyArgumentExceptionTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> pokerHandService.parsePokerHand(""));
        assertEquals(PokerHandService.WRONG_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    public void wrongArgumentExceptionTest(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> pokerHandService.parsePokerHand("2H 3H 4H 5H 6H 7H"));
        assertEquals(PokerHandService.WRONG_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    public void correctSortedPokerHandTest() {
        PokerHand pokerHand = pokerHandService.parsePokerHand("2H 3S 4C QH AD");

        assertEquals(pokerHand.hand().get(0).value(), CardValue.TWO);
        assertEquals(pokerHand.hand().get(0).suit(), CardSuit.HEARTS);

        assertEquals(pokerHand.hand().get(1).value(), CardValue.THREE);
        assertEquals(pokerHand.hand().get(1).suit(), CardSuit.SPADES);

        assertEquals(pokerHand.hand().get(2).value(), CardValue.FOUR);
        assertEquals(pokerHand.hand().get(2).suit(), CardSuit.CLUBS);

        assertEquals(pokerHand.hand().get(3).value(), CardValue.QUEEN);
        assertEquals(pokerHand.hand().get(3).suit(), CardSuit.HEARTS);

        assertEquals(pokerHand.hand().get(4).value(), CardValue.ACE);
        assertEquals(pokerHand.hand().get(4).suit(), CardSuit.DIAMONDS);
    }

    @Test
    public void sortPokerHandTest() {
        PokerHand pokerHand = pokerHandService.parsePokerHand("3S AD 2H QH 4C");

        assertEquals(pokerHand.hand().get(0).value(), CardValue.TWO);
        assertEquals(pokerHand.hand().get(0).suit(), CardSuit.HEARTS);

        assertEquals(pokerHand.hand().get(1).value(), CardValue.THREE);
        assertEquals(pokerHand.hand().get(1).suit(), CardSuit.SPADES);

        assertEquals(pokerHand.hand().get(2).value(), CardValue.FOUR);
        assertEquals(pokerHand.hand().get(2).suit(), CardSuit.CLUBS);

        assertEquals(pokerHand.hand().get(3).value(), CardValue.QUEEN);
        assertEquals(pokerHand.hand().get(3).suit(), CardSuit.HEARTS);

        assertEquals(pokerHand.hand().get(4).value(), CardValue.ACE);
        assertEquals(pokerHand.hand().get(4).suit(), CardSuit.DIAMONDS);
    }
}