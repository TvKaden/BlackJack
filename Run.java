import java.util.Scanner;
import java.util.ArrayList;

public class Run {

    public static void main(String[] args) {
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Dealer dealer = new Dealer();
        ArrayList<Integer> bets = new ArrayList<>();

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }
        System.out.println("How many people are playing? (1-4) ");
        int userInputUno = input.nextInt();
        if(userInputUno<5&&userInputUno>0){
        for(int i=0;i<userInputUno;i++)
            {
                int playerNum = i+1;
                System.out.println("What is the name of player "+playerNum+"? ");
                String userInput = input.nextLine();
                Player playerGuy = new Player(userInput);
                players.add(playerGuy);
                // System.out.println("How much would player "+playerNum+" like to bet? ");
                // int userBet = input.nextInt();
                // bets.add(userBet);
            }
        }
        else
        {
            System.out.println("Goodbye");
        }
        for(int i=0;i<userInputUno;i++)
        {
            players.get(i).hit(deck);
            players.get(i).hit(deck);
        }
        boolean gameState=false;
        while (gameState==false)
        {
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
            for(int i=0;i<userInputUno;i++)
            {
                int winnings = 0;
                if(players.get(i).getHandValue()>dealer.getHandValue())
                {
                    winnings = bets.get(i)*2;
                }
                else if(players.get(i).getHandValue()==dealer.getHandValue())
                {
                    winnings = bets.get(i);
                }
                if(players.get(i).getHandValue()<dealer.getHandValue())
                {
                    winnings = bets.get(i)*-1;
                }              
            }
            System.out.println("Would you like to continue? (y/n) ");
            String userIn = input.nextLine();
            if(userIn.equals("n"))
            {
                gameState=true;
            }
            else if(userIn.equals("y")){}
            else{}
        }
    }
}
