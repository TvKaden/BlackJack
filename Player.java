import java.util.ArrayList;
import java.util.Scanner;

// import javax.smartcardio.Card;

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
        System.out.println("Current hand value: "+getHandValue());
        System.out.println("What would you like to do "+name+"?(hit or stay) ");
        String userInput = input.nextLine();

        if(userInput.equals("hit"))
        {
            hit(deck);
            if(bustOrNah().equals("isFine"))
            {
                playTurn(deck);
            }
        }
        else if(userInput.equals("stay")){}
        else if(userInput.equals("67"))
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
        this.hand.add(getCard(deck));
        System.out.println(this.hand.get(this.hand.size()-1));   
    }

    public int getHandValue()
    {
        int handVal = 0;
        for(int i=0;i<this.hand.size();i++)
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

    public Card getCard(Deck deck)
    {
        return deck.getTopCard();
    }

    public String getName()
    {
        return this.name;
    }

    public void betMoney(double val)
    {
        this.money = this.money-val;
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

    public Card returnCards()
    {
        Card topCard = this.hand.get(0);
        this.hand.remove(0);  
        return topCard;
    }

}