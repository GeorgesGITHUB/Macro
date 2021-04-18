import java.awt.AWTException;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Driver 
{
    public static void main(String args[]){
    
        // RobotPlus requires AWTException to be handled
        RobotPlus bot =null;
        try { bot = new RobotPlus(); }
        catch (AWTException e) { 
            println("RobotPlus failed to initialise");
            System.exit(-1);
        }

        Scanner input = new Scanner(System.in);

        println("Welcome to Macro\n...\n...");

        println("Enter number of minutes swiping right");
        int minute=0;
        boolean exit = true;
        while(exit)
        {
            try{ minute = new Integer(input.nextLine()); exit=false; }
            catch(Exception e){ println("Please try again"); }
        }

        println("Left Click");
        bot.mouseClick(InputEvent.BUTTON1_MASK);
        println("Starting key taps");
        //Broken
        //bot.keyTapTimed(KeyEvent.VK_RIGHT, minute);
        
    }

    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
}