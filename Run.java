import java.util.Scanner;
import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Dealer dealer = new Dealer();
        ArrayList<Double> bets = new ArrayList<>();

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
        System.out.println("How many people are playing? (1-4) ");
        int userInputUno = input.nextInt();
        input.nextLine();
        if(userInputUno<5&&userInputUno>0){
        for(int i=0;i<userInputUno;i++)
        {
            int playerNum = i+1;
            System.out.println("What is the name of player "+playerNum+"? ");
            String userInput = input.nextLine();
            Player playerGuy = new Player(userInput);
            players.add(playerGuy);
        }
        }
        else
        {
            System.out.println("Goodbye");
        }

        boolean gameState=false;
        while (gameState==false)
        {
            for(int i=0;i<players.size();i++)
            {
                System.out.println("How much would you like to bet "+players.get(i).getName()+"? ");
                double userBet = input.nextInt();
                input.nextLine();
                players.get(i).betMoney(userBet);
                bets.add(userBet);
            }
            for(int i=0;i<userInputUno;i++)
                {
                    players.get(i).hit(deck);
                    players.get(i).hit(deck);
                }
            dealer.hit(deck);
            dealer.hit(deck);
            dealer.ShowCard();
            for(int i=0;i<userInputUno;i++)
            {
                if(players.get(i).getHandValue()<21)
                {
                    players.get(i).playTurn(deck);
                }
                else
                {
                    System.out.println(players.get(i).getName()+" bust");
                }
            }
            dealer.playTurn(deck);
            System.out.println("Dealers hand is "+dealer.getHandValue());
            for(int i=0; i<players.size();i++)
            {
                System.out.println(players.get(i).getName()+" hand is "+players.get(i).getHandValue());
            }
            for(int i=0;i<userInputUno;i++)
            {
                double winnings = 0;
                if(dealer.getHandValue()>22)
                {
                    if(players.get(i).getHandValue()<22)
                        {
                            winnings = bets.get(i)*2;
                            System.out.println(players.get(i).getName()+" Won");
                        }
                    else
                        {
                            System.out.println(players.get(i).getName()+" Lost");
                        }   
                }
                else 
                {
                    if(players.get(i).getHandValue()>dealer.getHandValue())
                        {
                            winnings = bets.get(i)*2;
                            System.out.println(players.get(i).getName()+" Won");
                        }
                    else if(players.get(i).getHandValue()==dealer.getHandValue())
                        {
                            winnings = bets.get(i);
                            System.out.println(players.get(i).getName()+" Tied");
                        }
                    else
                        {

                            System.out.println(players.get(i).getName()+" Lost");
                        }   
                }
            }
            System.out.println("Would you like to continue? (y/n) ");
            String userIn = input.nextLine();
            if(userIn.equals("n"))
            {
                gameState=true;
            }
            else if(userIn.equals("y"))
            {
                for(int i=0;i<players.size();i++)
                {
                    deck.getCardsBack(players.get(i));      
                }
                deck.getCardsBack(dealer);      
                deck.shuffle();   
            }
            else
            {
                for(int i=0;i<players.size();i++)
                {
                    deck.getCardsBack(players.get(i));      
                }
                deck.getCardsBack(dealer);      
                deck.shuffle(); 
            }
        }
    }
}
