
package project1_rsa;

public class Player 
{
    //Store the name to a private variable
    private String name;
    //Initialize the draw stack to a new linked stack
    private LinkedStack<Card> drawStack = new LinkedStack<>();
    //Initialize the discard stack to a new linked stack
    private LinkedStack<Card> discardStack = new LinkedStack<>();
    
    //Creating a player constructor
    public Player(String name) 
    {
        //Set the class name to the name variable
        this.name = name;
    }

    //Getting the player's name
    public String getName() 
    {
        //Return the player's name to the user
        return name;
    }

    //Setting the player's name
    public void setName(String name) 
    {
        //Set the player's name to the name variable
        this.name = name;
    }
    
    //Drawing a card
    public Card draw()
    {
        //Declare a card variable
        Card card;
        //Replenish the draw stack if it is empty
        if(drawStack.isEmpty())
        {
            //Replenish the draw stack
            replenishDrawStack();
        }
        //Assign the top of the draw stack to the card
        card = drawStack.top();
        //Pop the card from the draw stack
        drawStack.pop();
        //Return the card to the user
        return card;
    }
    
    //Discarding cards
    public void discard(Card cards)
    {
        //Push the cards to the discard stack
        discardStack.push(cards);
    }
    
    //Adding a card to the draw stack
    public void addToDrawStack(Card card)
    {
        //Push the card to the draw stack
        drawStack.push(card);
    }
    
    //Does the player has cards?
    public boolean hasCards()
    {
        //Return true if the draw or discard stack is not empty, otherwise return false
        return !(drawStack.isEmpty() && discardStack.isEmpty());
    }
    
    //Overiding the player class 
    @Override
    public String toString()
    {
        //Return the name to the user
        return name;
    }
    
    //Replenishing the draw stack
    private void replenishDrawStack()
    {
        if(drawStack.isEmpty())
        {
            //Popping from the discard stack
            while(!(discardStack.isEmpty()))
            {
                //Push the top of the discard stack to the draw stack
                drawStack.push(discardStack.top());
                //Pop the card from the discard stack
                discardStack.pop();
            }
        }
    }
}
