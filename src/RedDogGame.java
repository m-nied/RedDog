import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;



public class RedDogGame extends JApplet implements ActionListener
{
    // Constants
    private final int APPLET_WIDTH = 900;
    private final int APPLET_HEIGHT = 350;
    
    //declare Game Objects
    private Deck theDeckOfCards;
    private Card card1, card2, card3;

    //declare Applet components
    private JButton newGameButton, dealButton, hitMeButton;
    private JLabel intialBetLabel, raiseBetLabel, payoutLabel;
    private JTextField intialBetTextField, raiseBetTextField,payoutTextField;
    private JPanel gameButtonPanel,cardPanel, infoPanel;
  
    private boolean cardsDealt = false; // flag to determine if cards dealt


    public void init()
    {
        //instantiate and shuffle deck
        theDeckOfCards = new Deck(this,"../../images/");
        theDeckOfCards.shuffleDeck();

        //setup cards
        card1 = null;
        card2 = null;
        card3 = null;

        //instantiate components
        newGameButton = new JButton("New Game");
        dealButton = new JButton("Deal");
        hitMeButton = new JButton("Hit Me");
        intialBetLabel = new JLabel("Initial Bet");
        raiseBetLabel = new JLabel("Raise Bet");
        payoutLabel = new JLabel("Payout");
        intialBetTextField = new JTextField(12);
        raiseBetTextField = new JTextField(12);
        payoutTextField = new JTextField(12);

        //disable pay TextField
        payoutTextField.setEditable(false);

        //set dealt to false
        hitMeButton.setEnabled(false);
        raiseBetTextField.setEditable(false);

        //add actionListener to Buttons
        newGameButton.addActionListener(this);
        dealButton.addActionListener(this);
        hitMeButton.addActionListener(this);
        raiseBetTextField.addActionListener(this);

        //add buttons to Panel and add panel to Applet
        gameButtonPanel = new JPanel();
        gameButtonPanel.add(dealButton);
        gameButtonPanel.add(hitMeButton);
        add(gameButtonPanel,BorderLayout.NORTH);

        //add Components to Panel then add Panel to Applet
        infoPanel = new JPanel();
        infoPanel.add(intialBetLabel);
        infoPanel.add(intialBetTextField);
        infoPanel.add(raiseBetLabel);
        infoPanel.add(raiseBetTextField);
        infoPanel.add(payoutLabel);
        infoPanel.add(payoutTextField);
        infoPanel.add(newGameButton);
        add(infoPanel,BorderLayout.SOUTH);
        
        // add card panel
        cardPanel = new CardPanel(theDeckOfCards.getImage());
        add(cardPanel,BorderLayout.CENTER);
        
        //adjust the size of the Applet
        setSize(APPLET_WIDTH, APPLET_HEIGHT);
                
    }
    


    public void actionPerformed(ActionEvent e) 
    {
        //if source is new game button
        if(e.getSource() == newGameButton)
        {
            cardsDealt = false;
            dealButton.setEnabled(true);
           
        }
        //if source is deal
        else if(e.getSource() == dealButton)
        {
            cardsDealt = true;
            
            //deal the cards
            card1 = theDeckOfCards.dealOneCard(true);
            card2 = theDeckOfCards.dealOneCard(true);
            card3 = theDeckOfCards.dealOneCard(false);
            
            // button management based on cards shown...need to update
            hitMeButton.setEnabled(true);
            dealButton.setEnabled(false);
                    
        }//end of deal
        else if(e.getSource() == hitMeButton)
        {  
            card3.showCard(true);
            
            // button management based on result...need to update
            hitMeButton.setEnabled(false);
            dealButton.setEnabled(true);

        }//end if
        
        // update cards and deal status in card panel object
        // cast to CardPanel to allow method call
        ((CardPanel)cardPanel).updateCards(card1, card2, card3);
        ((CardPanel)cardPanel).updateDealStatus(cardsDealt);
        
        
        repaint(); // redraw all graphics (i.e. cards)

    }//actionPerformed

    
}//end class
