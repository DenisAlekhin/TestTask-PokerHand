package org.poker.hand.comparator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.poker.hand.service.PokerHandService;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@Slf4j
class PokerHandComparatorTest {
    @Autowired
    private PokerHandService pokerHandService;
    @Autowired
    private PokerHandComparator pokerHandComparator;

    @Test
    public void pokerHandSortTest() {
        List<PokerHand> pokerHands = new ArrayList<>();
        pokerHands.add(pokerHandService.parsePokerHand("2H 3H 4H 5H 6H"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 2H 3S 3H QD"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 2H 3S QH KD"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 3H JS QH KD"));
        pokerHands.add(pokerHandService.parsePokerHand("7D 7H KH KS KD"));
        pokerHands.add(pokerHandService.parsePokerHand("QS QH QD KH AD"));
        pokerHands.add(pokerHandService.parsePokerHand("6H AH AC AD AS"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 3H 4S 6H 7D"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 2H 3S QH QD"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 3H QS QH KD"));
        pokerHands.add(pokerHandService.parsePokerHand("2D 3H QS KH AD"));
        pokerHands.add(pokerHandService.parsePokerHand("2H 3H 4H 5H 9H"));
        pokerHands.add(pokerHandService.parsePokerHand("2D QS QH QD 6H"));

        Collections.sort(pokerHands, pokerHandComparator);

        for(int i = 0; i < pokerHands.size(); i++) {
            log.info("pokerHands[" + i + "]: " + pokerHands.get(i));
        }
    }
}