/*
 *  File: Card.java
 *  Description: This class implements a representation of a
 *   playing card of the sort that would be used in Blackjack,
 *   or Solitaire. A card is represented by an integer that
 *   gives its rank, from 0 to 51. This enables cards easily 
 *   to be sorted. Simple arithmetic can be used to derive a
 *   card's suit (clubs, diamonds, etc.) and face value (ace,
 *   king, etc.) from its rank. Thus rank, suit, and value are
 *   defined as instance variables.
 *
 *  A card is also represented by a String, with CDHS standing
 *   for suit names and 2..A standing for face value. Finally
 *   a card is also represented by two images, one for its face
 *   value, and one for its back. 
 */

import java.awt.*;

public class Card {
     // The following string literals store letters that are used to
     // construct a String representation of the card.

    private final String suitStr = "CDHS";  // C=club,D=diamond,H=heart,S=spade
    private final String valueStr = "??23456789TJQKA";  // 2 through Ace

    public int rank;	 // 0..51
    public int value;	 // face value 2,3,,,10,11(jack),14(ace)
    public int suit;	 // 0=club,1=diamond,2=heart,3=spade
	
    private Image faceImg;       // Face-up image
	
    private boolean faceUp;      // True when face-up
	
    /**
     *  The Card() constructor assigns the card a face value and suit,
     *   and records its rank. Initially the card is face up.
     *  @param rank -- an integer between 0 and 51
     */
    public Card (int rank) {
        this.rank = rank;               
        suit = rank / 13;          // Gives a number between 0..3
        value = 2 + rank % 13;     // Gives a number between 2..14 
        faceUp = true;
    } // Card()
	
    /**
     *  showCard() changes a card's state to faceUp, a boolean
     *  @param up -- true for up and false for down
     */
    public void showCard( boolean up ) {
        faceUp = up;
    } // showCard

    /**
     *  setImage() assigns its parameter as the card's face up image
     *  @param img -- a reference to an Image
     */
    public void setImage (Image img) {
        faceImg = img;		
    } // setImage

    /**
     *  toImage() returns an Image representing the card's state,
     *   either face up or face down.
     *  @return -- an Image giving the card's state
     */
    public Image toImage() {
        if (faceUp) 
            return faceImg;
        else 
            return null;
    }

    /**
     *  isFaceUp() returns a boolean value to represent whether the 
     *   card is either face up or face down.
     *  @return -- a boolean value representing face up or face down
     */
    public boolean isFaceUp()
    {
        return faceUp;
    }

	
    /**
     *  Goal: Return a 2 character representation of the card. For
     *    example, "2c" means 2 of clubs, "jd" is jack of diamonds.
     * Algorithm: the instance variables, suit, and value,
     *  are used as indexes into strings that store the correct letters
     */
    public String toString() {
        return "" +  valueStr.charAt(value) + suitStr.charAt(suit);
    } // toString

} // Card
