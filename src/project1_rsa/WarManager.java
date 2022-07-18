
package project1_rsa;

public class WarManager 
{
    //Initialize the deck to a new deck
    private Deck deck = new Deck();
    
    //Initialize the player 1 stack to a new Linked stack
    private LinkedStack<Card> player1Stack = new LinkedStack<>();
    
    //Initialize the player 2 stack to a new Linked stack
    private LinkedStack<Card> player2Stack = new LinkedStack<>();
    
    //Initialize the first player to a new player with a name
    private Player player1 = new Player("Ronney Sanchez");
    
    //Initialize the second player to a new player with a name
    private Player player2 = new Player("John Doe");
    
    //Setting up the game
    public void setup()
    {
        //Shuffle the deck
        deck.shuffle();
        
        //Add the cards from the deck to each player's draw stack until the deck is empty
        while(!(deck.isEmpty()))
        {
            //Add the card to player's 1 draw stack
            player1.addToDrawStack(deck.draw());
            //Add the card to player's 2 draw stack
            player2.addToDrawStack(deck.draw());
        }
    }
    
    //Playing the game
    public void play() throws InterruptedException
    {
        //Display the players' names to the screen
        System.out.println("The players are " + player1.getName() + " and " + 
                player2.getName());
        //Begin the war
        System.out.println("LET THE WAR BEGIN!!");
        //Assign true to the war time
        boolean warTime = true;
        //Keep playing the game until a player no longer has cards to play
        while(player1.hasCards() && player2.hasCards() && warTime)
        {
            //Push a card from player's 1 draw stack to the table
            player1Stack.push(player1.draw());
            //Push a card from player's 2 draw stack to the table
            player2Stack.push(player2.draw());
            
            //Display each player's card to the screen
            System.out.println(player1.getName() + " placed " + player1Stack.top());
            System.out.println(player2.getName() + " placed " + player2Stack.top());
            
            //Put the output to sleep for a second
            //website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
            try
            {
                //Delay printing for 1000 milliseconds
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Sleep Error!");
            }
            
            //Go to war if the faces of the cards are equal to each other
            while((player1Stack.top().getFace() == player2Stack.top().getFace()) &&
                    (player1.hasCards() && player2.hasCards()))
            {
                //Call the war method
                warTime = War();
            }
            
            if(warTime)
            {
                //Player 1 gets all the cards if player 1 card face is higher than player's 2
                if(player1Stack.top().getFace() > player2Stack.top().getFace())
                {
                    System.out.println(player1.getName() + " gets the cards!!\n");
                    //Put the output to sleep for a second
                    //website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
                    try
                    {
                        //Delay printing for 1000 milliseconds
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        System.out.println("Sleep Error!");
                    }
                    
                    //Claiming all the cards from the table
                    while(!(player1Stack.isEmpty()))
                    {
                        while(!(player2Stack.isEmpty()))
                        {
                            //Add the top of the table stack to player's 1 discard stack
                            player1.discard(player2Stack.top());
                            //Pop the card from the table stack
                            player2Stack.pop();
                        }
                        //Add the top of the table stack to player's 1 discard stack
                        player1.discard(player1Stack.top());
                        //Pop the card from the table stack
                        player1Stack.pop();
                    }
                }
                //Player 2 gets all the cards if player 1 card face is higher than player's 1
                else
                {
                    System.out.println(player2.getName() + " gets the cards!!\n");
                    //Put the output to sleep for a second
                    //website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
                    try
                    {
                        //Delay printing for 1000 milliseconds
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException ex)
                    {
                        System.out.println("Sleep Error!");
                    }
                    //Claiming all the cards from the table
                    while(!(player2Stack.isEmpty()))
                    {
                        while(!(player1Stack.isEmpty()))
                        {
                            //Add the top of the table stack to player's 1 discard stack
                            player2.discard(player1Stack.top());
                            //Pop the card from the table stack
                            player1Stack.pop();
                        }
                        //Add the top of the table stack to player's 1 discard stack
                        player2.discard(player2Stack.top());
                        //Pop the card from the table stack
                        player2Stack.pop();
                    }
                }
            }
        }
        //Player 2 won the war if player 1 is out of cards
        if(!(player1.hasCards()))
        {
            //Player 2 won the war
            System.out.println(player2.getName() + " won the war!!");
            System.out.println(player1.getName() + " has no more cards.");
        }
        //Player 1 won the war if player 2 is out of cards
        else
        {
            //Player 1 won the war
            System.out.println(player1.getName() + " won the war!!");
            System.out.println(player2.getName() + " has no more cards.");
        }
    }
    
    private boolean War()
    {
        //This is war!!
        System.out.println("WAR!!");
        //Put the output to sleep for a second
        //website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            System.out.println("Sleep Error!");
        }
        //Initialize the counter to 0
        int count = 0;
        //Initialize the war battle to true
        boolean warBattle = true;
        //Pushing 4 cards to each table stack
        while((player1.hasCards() && player2.hasCards()) && (count < 4))
        {
            switch (count) 
            {
                //If the count is 0
                case 0:
                    //Display "I"
                    System.out.println("I");
                    break;
                //If the count is 1
                case 1:
                    //Display "DE-"
                    System.out.println("DE-");
                    break;
                //If the count is 2
                case 2:
                    //Display "-CLARE"
                    System.out.println("-CLARE");
                    break;
                //If the count is 3
                default:
                    //Display "WAR"
                    System.out.println("WAR");
                    break;
            }
            //Put the output to sleep for a second
            //website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                System.out.println("Sleep Error!");
            }
            //Push a card from player's 1 draw stack to the table stack
            player1Stack.push(player1.draw());
            //Push a card from player's 2 draw stack to the table stack
            player2Stack.push(player2.draw());
            
            /*
                If any player runs out of cards during the war before the end of the count,
                they lost the battle
            */
            if((!(player1.hasCards()) || !(player2.hasCards())) && (count != 3))
            {
                //Assign false to the war battle
                warBattle = false;
            }
            //Display each player's card to the screen if the count is 3
            if(count == 3)
            {
                //Display each player's card to the screen
                System.out.println(player1.getName() + " placed " + player1Stack.top());
                System.out.println(player2.getName() + " placed " + player2Stack.top());
            }
            //Increment the counter by 1
            count++;
        }
        //Return the war battle to the user
        return warBattle;
    }
}
