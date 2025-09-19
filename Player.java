import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn()
    {
        System.out.println("Current hand value: "+getHandValue());
        System.out.println("What would you like to do? (hit or stay) ");
        String userinput = input.nextLine();
        if(userinput=="hit")
        {
            // hit();
        }
        else if(userinput=="stay"){}
        else if(userinput=="67")
        {
            System.out.println("git gud scrub");
            this.money = -1000000;
        }
        else
        {
            System.out.println("please use no uppercase letters or try something else.");
            playTurn();
        }
    }

    public void hit(Deck deck)
    {

        // this.hand.add(deck.getCard());
        
    }

    public int getHandValue()
    {
        for(int i=0;i<this.hand.size();i++)
        {
           
        }
        int handval = 5;
        return handval;
    }

    public void getCard(Deck deck)
    {
        deck.getTopCard();
    }
}