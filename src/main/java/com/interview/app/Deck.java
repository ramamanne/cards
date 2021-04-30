package com.interview.app;

import java.util.Random;

/**
 * Deck class to construct deck of cards
 * shuffle() to shuffle the remaining cards in deck
 * dealOneCard() to get a card from the deck
 * reset() to reset the playing deck
 * @author Rama
 */
public class Deck implements IDeck {
    private final Card[] cardDeck;
    private int numberOfDeals;

    public Deck() {
        this.numberOfDeals = 0;
        //Creating the deck
        this.cardDeck = new Card[Suite.values().length * FaceValue.values().length];
        int i = 0;
        for (Suite suite : Suite.values()) {
            for (FaceValue faceValue : FaceValue.values()) {
                cardDeck[i++] = new Card(suite, faceValue);
            }
        }
    }

    /**
     * Shuffle the remaining cards in the deck
     */
    public void shuffle() {
        Random random = new Random();
        //Shuffle remaining cards
        for (int i = this.numberOfDeals; i < this.cardDeck.length; i++) {
            int swapIndex = random.nextInt(this.cardDeck.length - this.numberOfDeals) + this.numberOfDeals;
            if (swapIndex == i) continue;
            else {
                Card temp = cardDeck[i];
                cardDeck[i] = cardDeck[swapIndex];
                cardDeck[swapIndex] = temp;
            }
        }
    }

    /**
     * Resets the deck to start play again
     */
    public void reset() {
        this.numberOfDeals = 0;
    }

    /**
     * Returns the top card from the deck
     *
     * @return Card
     */
    public Card dealOneCard() {
        if (this.numberOfDeals == Suite.values().length * FaceValue.values().length) {
            return null;
        } else {
            Card card = cardDeck[this.numberOfDeals];
            this.numberOfDeals++;
            return card;
        }
    }
}
