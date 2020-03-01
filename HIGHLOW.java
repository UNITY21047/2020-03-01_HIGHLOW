import java.util.Scanner;
/** 
 * HIGHLOW
 */
public class HIGHLOW 
{

    private int MAX = 0;
    private int GUESS = 0;
    private int NUM = 0;
    private int COUNT = 1;
    private int COUNTAVG = 0;
    private int GAMENUM = 1;

    public void CALLER() 
    {
        Scanner INPUT = new Scanner(System.in);

        int OFFORON = 1; //1 for "ON" 0 for "OFF"
        String ANSWER = " ";
        
        System.out.println("\nWelcome to High Low Game!:\n");

        GETMAX();

        System.out.println("\n---\nStarting Game " + GAMENUM +":\n---");

        while (OFFORON == 1) 
        {
           GETGUESS();

           if (CHECKGUESS() == true) 
           {
                COUNTAVG = COUNTAVG + COUNT;
                System.out.println("\nThat is correct!\n\nIt took you " + COUNT +" guesses to win!\nYou have an average of " + COUNTAVG + " guesses over " + GAMENUM +" games.\n");
                System.out.println("Would you like to play again? (Please say yes or no!)");
                ANSWER = INPUT.nextLine();
                ANSWER = ANSWER.toLowerCase();

                if(ANSWER.equals("yes"))
                {
                    GAMENUM++;
                    COUNTAVG = COUNTAVG + COUNT;
                    COUNT = 1;
                    CALLER();
                }

                else if(ANSWER.equals("no"))
                {
                    OFFORON = 0;
                    System.out.println("\nBye!");
                }
           }
           else if(CHECKGUESS() == false)
           {
                if (GUESS > GETCOMPNUM()) 
                {
                    System.out.println("To high!");
                }
                else if (GUESS < GETCOMPNUM()) 
                {
                    System.out.println("To low!");
                }
                COUNT++;
                GETGUESS();;
           }
        }
    }

    public void GETMAX() 
    {
        Scanner INPUT = new Scanner(System.in);
        System.out.println("What is the maximum value for this game? (1 - ?)");
        MAX = INPUT.nextInt();
    }

    public void GETGUESS() 
    {
        System.out.println("What is your guess (#" + COUNT +"):");
        Scanner INPUT = new Scanner(System.in);
        GUESS = INPUT.nextInt();
    }

    public int RETURNMAX() 
    {
        return MAX;
    }

    public int RETURNGUESS() 
    {
        return MAX;
    }

    public int GETCOMPNUM() 
    {
        NUM = (int) (Math.random() * RETURNMAX()) + 1;
        return NUM;
    }

    public boolean CHECKGUESS() 
    {
        boolean go = true;

        if(RETURNGUESS() == GETCOMPNUM()) 
        {
            go = true;
        }

        else if(RETURNGUESS() != GETCOMPNUM())
        {
            go = false;
        }

        return go;
    }
}