import java.awt.AWTException;
import java.util.Scanner;
import java.awt.event.KeyEvent;

public class Macro 
{
    public static void main(String args[]) throws AWTException
    {
    boolean loop=true;
    while(loop)
    {
        println("Enter number to select the following Macros");
        println("0 : Tinder Auto liker");
        println("1 : Discord Message Deleter");

        Scanner input = new Scanner(System.in);
        int selection = Integer.parseInt(input.nextLine());

        switch(selection)
        {
            case 0 :
                TinderSwiping(); break;
            case 1 :
                DeleteDiscordMSG(); break;
        }

        println("Continue using Macros? (y/n)");
        String answer = input.nextLine();

        if(answer=="y"){loop=true;}
        else if(answer=="n"){loop=false;}
        else {print("unrecognized command, ending program");loop=false;}
    }
    }


    public static void TinderSwiping() throws AWTException
    {
        RobotPlus bot= new RobotPlus();

        println("How many minutes of Tinder Swiping?");

        Scanner input = new Scanner(System.in);
        int minutes = Integer.parseInt(input.nextLine());
        input=null;
        
        bot.leftMouseClick();
        bot.rightArrowPress(minutes, "minutes");
        
        println("DONE");
    }

    public static void DeleteDiscordMSG() throws AWTException
    {
        RobotPlus bot= new RobotPlus();

        println("How many minutes of discord message deleting?");

        Scanner input = new Scanner(System.in);
        int time = Integer.parseInt(input.nextLine());
        input=null;

        long target = bot.duration(time, "minutes");
        while( target > System.nanoTime() )
        {
            bot.mouseMove(-206,44);
            bot.leftMouseClick();
            bot.keyTap(KeyEvent.VK_ENTER);

            bot.wait(1, "seconds");
            bot.mouseMove(-41,204);
            bot.mouseClick(KeyEvent.BUTTON3_MASK);
            bot.keyTap(KeyEvent.VK_DOWN, 3);
            bot.keyTap(KeyEvent.VK_ENTER, 2);
        }
    }

    public static void printMouseXY() throws AWTException
    {
        RobotPlus bot= new RobotPlus();
        println("Getting Mouse Position in 4 Seconds");

        // long target = bot.duration(4, "seconds");
        // while( target > System.nanoTime() ){} //waiting

        bot.wait(4, "seconds");
        int[] coordinates = bot.getMouseXY();
        print( coordinates[0] ); print(","); print( coordinates[1] );
    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}
}