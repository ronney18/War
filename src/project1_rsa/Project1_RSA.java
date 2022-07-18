/*
    Name: Ronney Sanchez
    Date: 2/23/17
    Course: CIS252 Computer Science 2
    Program: Project 1 (War Game)
    Description: This program is a war game between two players. Each player
    puts a card facing down to the table. When the card is flipped the player
    with the highest face gets to discard both cards. The game continues until
    the first player to run out of cards, in which they lose the game.

    Reference:

    website found: http://www.dreamincode.net/forums/topic/33439-a-way-to-delay-output/
    I used a sleep method that delays the output of each players' cards for 1
    second. The sleep method is very useful to keep track of the game process.
*/
package project1_rsa;

public class Project1_RSA 
{
    public static void main(String[] args) throws InterruptedException 
    {
        //Create a new War manager 
        WarManager war = new WarManager();
        //Setup the game with the deck of cards
        war.setup();
        //Play the war game
        war.play();
    }
}

/*
    Completion:
    I spent a lot of time trying to debug my program. I got all my classes and
    my setup done. When I went to test the game. Some of my tests were getting
    locked in to an infinite loop. I went to test my codes for each classes
    for hours and finally, I found the problem within the next two hours. My
    replenish draw stack was the bug in this program. I needed to reverse the 
    discard stack as my draw stack because it was reading the same cards in the
    same order over and over again. When I got that part fixed. My program
    finally worked. It was a relief to get this game working right.
*/
