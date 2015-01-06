/*
 * File: Deck.java
 * Description: This class uses an array to store 52 Card objects.
 *  It provides methods to shuffle and sort the deck.
 */

import java.awt.*;
import java.applet.Applet;

public class Deck {	

   public static final int NCARDS = 52;	// Class constant

   private Card deck[] = new Card [NCARDS];  // 52 card array
   private int top = 0;                      // Position of top card

   private Image cardBack;     // Deck's image
	
   /**
    * Deck() -- creates a deck of cards.
    * @param app is the applet which called this constructor.
    * @param imgPath -- a string naming the images directory 
    * Note: The applet reference is needed so the applet can
    *   read in the card images. The images are named "back.gif"
    *   for cardBack and then 2C.gif, 3C.gif, ... , aS.gif
    */
   public Deck(Applet a, String imgPath) {
      cardBack = a.getImage( a.getCodeBase(), imgPath + "back.gif");
      a.showStatus("Please wait while card images are loading. ");

      for (int k = 0; k < deck.length; k++) {  // Make the cards
          deck[k] = new Card( k );	
          String s = imgPath + deck[k].toString() + ".gif";
          Image img = a.getImage(a.getCodeBase(), s);
          deck[k].setImage(img);
      }
   } // Deck()

   /**
    * dealOneCard () returns the top card and increments 
    * the instance variable top.
    * @param faceup is true if card should be dealt face up
    * @return Card a reference to a card
    */
   public Card dealOneCard(boolean faceUp)    {
      Card topCard = deck[top];         // Get the top card
      if (faceUp) 			// If face-up deal
         topCard.showCard(true);        //  Turn it face up
      else                              // Else
         topCard.showCard(false);       //  Turn it face down
      top = (top + 1) % NCARDS;		// top is new top card
      return topCard;			// And deal it
   }
	
   /**
    * shuffleDeck() shuffles the deck by repeatedly picking two cards 
    *  at random and swapping their positions in the deck.
    */
   public void shuffleDeck() {

     // *** Add your code here
 
   } // shuffleDeck()
		
   /**
    * getImage() returns the cardBack image.
    */
   public Image getImage() {
     return cardBack;
   }

} // Deck
