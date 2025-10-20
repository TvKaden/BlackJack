import java.util.ArrayList;

// import javax.smartcardio.Card;

public class Dealer extends Player
{
    private ArrayList<Card> hand = new ArrayList<>();

    public Dealer()
    {
        super("Robert");
    }

    public void playTurn(Deck deck)
    {
        if(getHandValue()>21)
        {
            System.out.println("The dealer busts");
        }
        if(getHandValue()<16)
        {
            hit(deck);
        }
        else
        {
            System.out.println("The dealers had is "+getHandValue());
        }
    }

    public Card returnCards()
    {
        Card topCard = this.hand.get(0);
        this.hand.remove(0);  
        return topCard;
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

    public void hit(Deck deck)
    {
        this.hand.add(getCard(deck));
    }

    public void ShowCard()
    {
        System.out.println(this.hand.get(this.hand.size()-1));
    }

}