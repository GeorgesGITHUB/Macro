import java.awt.AWTException;
import java.util.Scanner;
import java.awt.event.KeyEvent;

public class Macro 
{
    public static void main(String args[]) throws AWTException
    {
        DeleteDiscordMSG();
    }

    public static void printMouseXY() throws AWTException
    {
        RobotPlus bot= new RobotPlus();
        println("Getting Mouse Position in 4 Seconds");
        long target = bot.duration(4, "seconds");
        
        while( target > System.nanoTime() ){} //waiting
        
        int[] coordinates = bot.getMouseXY();
        print( coordinates[0] ); print(","); print( coordinates[1] );
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

        int x = 0;
        int y = 0;

        long target = bot.duration(time, "minutes");
        while( target > System.nanoTime() )
        {
            bot.mouseMove(-206,44);
            bot.leftMouseClick();
            bot.keyTap(KeyEvent.VK_ENTER);

            bot.mouseMove(-41,204);
            bot.mouseClick(KeyEvent.BUTTON2_MASK);
            bot.keyTap(KeyEvent.VK_DOWN, 3);
            bot.keyTap(KeyEvent.VK_ENTER, 2);
        }



    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}
}