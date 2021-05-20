import java.awt.AWTException;
import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class Driver 
{
    public static void main(String args[]){
    
        // RobotPlus requires AWTException to be handled
        RobotPlus bot =null;
        try { bot = new RobotPlus(200); }
        catch (AWTException e) { 
            println("RobotPlus failed to initialise");
            System.exit(-1);
        }

        Scanner input = new Scanner(System.in);

        String msg = "* " + "Welcome to Macro" + " *";
        for(int i=0; i<msg.length()+4; i++){print("*");}
        println();
        print(msg);
        println();
        for(int i=0; i<msg.length()+4; i++){print("*");}
        println();

        println("Enter number of minutes to swipe for: ");
        int minute = Integer.parseInt(input.nextLine());
        println("Entered Successfully");

        println("Left Click");
        bot.mouseClick(InputEvent.BUTTON1_MASK);
        println("Starting key taps");
        
        bot.keyTapTimed(KeyEvent.VK_RIGHT, minute);
        
    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}
}