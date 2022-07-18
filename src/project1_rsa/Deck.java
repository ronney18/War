
package project1_rsa;

import java.util.Random;

//The Deck class is inherited from the LinkedStack class
public class Deck extends LinkedStack<Card>
{
    //Creating a Deck constructor
    public Deck()
    {
        //Declare four card variables
        Card myCard1;
        Card myCard2;
        Card myCard3;
        Card myCard4;
        
        //For every face numbers, create 4 cards of that face with four different suits
        for(int i = 2; i <= 14; i++)
        {
            //Create a card of Hearts
            myCard1 = new Card(i, "Hearts");
            //Push the card to the deck stack
            push(myCard1);
            //Create a card of Spades
            myCard2 = new Card(i, "Spades");
            //Push the card to the deck stack
            push(myCard2);
            //Create a card of Clubs
            myCard3 = new Card(i, "Clubs");
            //Push the card to the deck stack
            push(myCard3);
            //Create a card of Diamonds
            myCard4 = new Card(i, "Diamonds");
            //Push the card to the deck stack
            push(myCard4);
        }
    }
    
    public int size()
    {
        //Declare a linked node and initialize it to the top link
        LLNode<Card> current = top;
        //Initialize the counter to 0
        int count = 0;
        //Loop until the next current link is null
        while(current != null)
        {
            //Increment the counter by 1
            count++;
            //Assign the next link to the current link
            current = current.getLink();
        }
        //Return the counter to the user
        return count;
    }
    
    public void shuffle()
    {
        //Create a random number generator
        Random rand = new Random();
        //Initialize the first element to 0
        int firstElement = 0;
        //Initialize the second element to 0
        int secondElement = 0;
        
        //Swap the elements over a thousand times
        for(int i = 0; i < 1000; i++)
        {
            do
            {
                //Assign a random number bounded by the size of the deck to the first element 
                firstElement = rand.nextInt(size());
                //Assign a random number bounded by the size of the deck to the second element
                secondElement = rand.nextInt(size());
                
            //Make sure that the number is not the same
            }while(firstElement == secondElement);
                
            //Swap the first and second element
            swapElements(firstElement, secondElement);
        }
    }
    
    //Drawing a card from the deck
    public Card draw()
    {
        //Assign the top of card to the card variable
        Card card = top();
        //Pop the card from the stack
        pop();
        //Return the card to the user
        return card;
    }
    
    //Swapping the first and second elements
    private void swapElements(int x, int y)
    {
        //Initialize the first node to null
        LLNode<Card> first = null;
        //Initialize the second node to null
        LLNode<Card> second = null;
        //Initialize the counter to 0
        int count = 0;
        
        //Assign top to the current node
        LLNode current = top;
        
        //Finding the first element
        while((current != null) && (count <= x))
        {
            //Assign the current node to the first if x is equal to the counter
            if(count == x)
            {
                //Assign the current node to the first
                first = current;
            }
            //Increment the counter by 1
            count++;
            //Assign the next link to the current link
            current = current.getLink();
        }
        
        //Initialize the counter to 0
        count = 0;
        //Assign top to the current node
        current = top;
        
        //Finding the second element
        while((current != null) && (count <= y))
        {
            //Assign the current node to the second if y is equal to the counter
            if(count == y)
            {
                //Assign the current node to the second
                second = current;
            }
            //Increment the counter by 1
            count++;
            //Assign the next link to the current link
            current = current.getLink();
        }
        //Swap nodes if the first and second node is not null
        if((first != null) && (second != null))
        {
            //Assign the info of the first node to temp
            Card temp = first.getInfo();
            //Set the first node's info to the second node info
            first.setInfo(second.getInfo());
            //Set the second node's info to temp
            second.setInfo(temp);
        }
    }
}
