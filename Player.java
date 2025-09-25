import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn(Deck deck)
    {
        String teString = "String";
        System.out.println("Current hand value: "+getHandValue());
        System.out.println("What would you like to do "+name+"?(hit or stay) ");
        String userInput = input.nextLine();

        if(userInput=="hit")
        {
            hit(deck);
            if(bustOrNah()=="isFine")
            playTurn(deck);
        }
        else if(userInput=="stay"){}
        else if(userInput=="String")
        {
            System.out.println("git gud scrub");
            this.money = -1000000;
            System.out.println(money);
        }
        else
        {
            System.out.println("please use no uppercase letters or try something else.");
            playTurn(deck);
        }
    }

    public void hit(Deck deck)
    {

        // this.hand.add(getCard(deck));
        
    }

    public int getHandValue()
    {
        int handVal = 0;
        for(int i=0;i<this.hand.size()-1;i++)
        {
            if(this.hand.get(i).getface()=="A")
            {
                int handVal1 = handVal+1;
                int handVal2 = handVal+11;
                if(handVal2>21)
                {
                    handVal = handVal1;
                }
                else if(handVal2==21)
                {
                    handVal = handVal2;
                }
                else
                {
                    handVal = handVal2;
                }
            }
            else
            {
                handVal += this.hand.get(i).getvalue();
            }
        }
        return handVal;
    }

    public void getCard(Deck deck)
    {
        deck.getTopCard();
    }

    public String getName()
    {
        return this.name;
    }

    public String bustOrNah()
    {
        if(getHandValue()>21)
        {
            return "Bust";
        }
        else if(getHandValue()==21)
        {
            return "Winning";
        }
        else
        {
            return "isFine";
        }
    }
}