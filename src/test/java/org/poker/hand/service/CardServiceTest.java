package org.poker.hand.service;

import org.junit.jupiter.api.Test;
import org.poker.hand.service.CardService;
import org.poker.hand.util.card.Card;
import org.poker.hand.util.card.CardSuit;
import org.poker.hand.util.card.CardValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CardServiceTest {
    @Autowired
    private CardService cardService;

    @Test
    public void emptyArgumentExceptionTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cardService.parseCard(""));
        assertEquals(CardService.WRONG_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    public void oneArgumentExceptionTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cardService.parseCard("2"));
        assertEquals(CardService.WRONG_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    public void threeArgumentExceptionTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cardService.parseCard("2H2"));
        assertEquals(CardService.WRONG_ARGUMENT_MESSAGE, exception.getMessage());
    }

    @Test
    public void correctCardTest() {
        Card card = cardService.parseCard("2H");

        assertEquals(CardValue.TWO, card.value());
        assertEquals(CardSuit.HEARTS, card.suit());
    }
}