package com.interview.app;

import java.util.Objects;

/**
 * Card Class represent playing Card
 * @author Rama
 */
public class Card {

    private final Suite suite;
    private final FaceValue faceValue;

    public Card(Suite suite, FaceValue faceValue) {
        this.suite = suite;
        this.faceValue = faceValue;
    }
    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite +
                ", faceValue=" + faceValue +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suite == card.suite && faceValue == card.faceValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suite, faceValue);
    }

}
