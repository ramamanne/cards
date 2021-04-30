package com.interview.app;

public class Main {
    public static void main(String[] args) {
        IDeck deck = new Deck();
        deck.shuffle();
        //Deal one card from the deck
        Card firstCard = deck.dealOneCard();
        System.out.println(firstCard);
        //deal 55 cards from deck
        for (int i = 0; i < 55; i++) {
            Card card = deck.dealOneCard();
            if (card == null) {
                System.out.println("Empty Deck Reset to play again");
            } else {
                System.out.println(card);
            }
        }
    }
}
