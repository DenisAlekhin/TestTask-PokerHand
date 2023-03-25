package org.poker.hand.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.poker.hand.comparator.CardValueComparator;
import org.poker.hand.util.poker.hand.PokerHand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Getter
public class PokerHandService {
    private final CardValueComparator cardValueComparator;
    private final CardService cardService;

    public final static String WRONG_ARGUMENT_MESSAGE = "Hand can't be created: wrong argument";
    private final Integer STRING_HAND_LENGTH = 14; // "2C 3C AC 4C 5C" - length 14

    public PokerHand parsePokerHand(String strHand) {
        if (Objects.isNull(strHand) || strHand.length() != STRING_HAND_LENGTH) {
            throw new IllegalArgumentException(WRONG_ARGUMENT_MESSAGE);
        }
        PokerHand pokerHand = new PokerHand(new ArrayList<>(5));
        Stream.of(strHand.split(" ")).forEach(s -> pokerHand.hand().add(cardService.parseCard(s)));

        pokerHand.hand().sort(cardValueComparator);
        return pokerHand;
    }
}
