
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/*
 * File: CardPanel.java
 * Description: This class displays the Card Images or Strings.
 *  It provides methods to update the cards to be shown and a paint method
 *  to update the graphics for this panel.
 */

public class CardPanel extends JPanel {
    
    private Image cardBack;
    private Card card1, card2, card3;
    private boolean cardsDealt = false;
    
    public CardPanel() {}
   
    public CardPanel(Image back)
    {
        cardBack = back;
    }
    
    public void updateCards (Card c1, Card c2, Card c3)
    {
        card1 = c1;
        card2 = c2;
        card3 = c3;
    }
    
    public void updateDealStatus(boolean d)
    {
        cardsDealt = d;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
                
        if (cardsDealt == true) // needed to ensure card objects are not null
        {
           if(card1.isFaceUp())
            {
                // draw card
                g.drawString(card1.toString(), 50, 100);
                g.drawImage(card1.toImage(), 50, 100, this);
            }
            else
                g.drawImage(cardBack, 50, 100, this);

            
            if(card2.isFaceUp())
             {
                // draw card
                g.drawString(card2.toString(), 800, 100);
                g.drawImage(card2.toImage(), 800, 100, this);

            }
            else
                g.drawImage(cardBack, 800, 100, this);
            
            if(card3.isFaceUp())
            {
                // draw card
                g.drawString(card3.toString(), 400, 100);
                g.drawImage(card3.toImage(), 400, 100, this);

            }
            else
                g.drawImage(cardBack, 400, 100, this);

            
        }
         
    }
}
