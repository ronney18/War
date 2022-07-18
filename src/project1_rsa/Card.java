
package project1_rsa;

public class Card 
{
    //Store the face to a variable
    private int face;
    //Store the suit to a variable
    private String suit;

    //Creating a Card constructor
    public Card(int face, String suit) 
    {
        //Assign the face to the face variable of this class
        this.face = face;
        //Assign the suit to the suit variable of this class
        this.suit = suit;
    }
    
    //Getting the face of the card
    public int getFace() 
    {
        //Return the face to the user
        return face;
    }

    //Setting the face of the card
    public void setFace(int face) 
    {
        //Set the face to the face variable of this class
        this.face = face;
    }

    //Getting the suit of the card
    public String getSuit() 
    {
        //Return the suit to the user
        return suit;
    }

    //Setting the suit of the card
    public void setSuit(String suit) 
    {
        //Set the suit to the suit variable of this class
        this.suit = suit;
    }
    
    //Displaying the content of the card
    @Override
    public String toString()
    {
        //Declare a string variable
        String s;
        
        //Checking the conditions for faces
        switch (face) 
        {
            //If the face is equal to 11
            case 11:
                //Assign the Jack of a specific suit to the string variable
                s = "Jack of " + suit;
                break;
            //If the face is equal to 12
            case 12:
                //Assign the Queen of a specific suit to the string variable
                s = "Queen of " + suit;
                break;
            //If the face is equal to 13
            case 13:
                //Assign the King of a specific suit to the string variable
                s = "King of " + suit;
                break;
            //If the face is equal to 14
            case 14:
                //Assign the Ace of a specific suit to the string variable
                s = "Ace of " + suit;
                break;
            //For the rest of the case
            default:
                //Assign the face number of a specific suit to the string variable
                s = face + " of " + suit;
                break;
        }
        //Return the content of the face and suit of the card to the user 
        return s;
    }
}
