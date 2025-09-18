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
            hit();
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

    public void hit()
    {
        // this.hand.add(getCard)
        
    }

    public int getHandValue()
    {
        int handval = 8;
        return handval;
    }

    public void getCard(Deck deck)
    {
        //do stuff
    }
}