package com.interview.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    void shuffleOnceTest() {
        //Deck without shuffle
        Card[] cards = new Card[Suite.values().length * FaceValue.values().length];
        for (int i = 0; i < Suite.values().length * FaceValue.values().length; i++) {
            cards[i] = deck.dealOneCard();
        }
        deck = new Deck();
        //Deck with shuffle
        deck.shuffle();
        Card[] cardsNew = new Card[Suite.values().length * FaceValue.values().length];
        for (int i = 0; i < Suite.values().length * FaceValue.values().length; i++) {
            cardsNew[i] = deck.dealOneCard();
        }
        assertFalse(Arrays.equals(cardsNew, cards));
    }

    @Test
    void shuffleRemainingTest() {
       //deal without shuffle
        Card[] cards = new Card[Suite.values().length * FaceValue.values().length];
        for (int i = 0; i < Suite.values().length * FaceValue.values().length - 13; i++) {
            cards[i] = deck.dealOneCard();
        }
        int j = 0;
        Card[] diamondCard = new Card[13];
        for(FaceValue faceValue : FaceValue.values()){
            diamondCard[j++] = new Card(Suite.DIAMOND,faceValue);
        }
        //shuffle remaining diamond cards
        deck.shuffle();
        Card[] cardsNew = new Card[13];
        for (int i = 0; i < 13; i++) {
            cardsNew[i] = deck.dealOneCard();
        }
        assertFalse(Arrays.equals(cardsNew, diamondCard));
    }

    /**
     * Testing deal 52 cards and more than 52 cards
     */
    @Test
    void dealOneCardDeck() {
        //
        for (int i = 0; i < Suite.values().length * FaceValue.values().length; i++) {
            Card card = deck.dealOneCard();
            assertNotNull(card);
        }
        Card card = deck.dealOneCard();
        assertNull(card);
    }

    @Test
    void reset() {
        for (int i = 0; i < Suite.values().length * FaceValue.values().length; i++) {
            Card card = deck.dealOneCard();
            assertNotNull(card);
        }
        deck.reset();
        Card card = deck.dealOneCard();
        assertNotNull(card);
    }
}