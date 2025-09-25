public class Dealer extends Player
{
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

}