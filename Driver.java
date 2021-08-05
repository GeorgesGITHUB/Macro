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

        welcomeMSG();

        println("Enter number of minutes to swipe for: ");

        Scanner input = new Scanner(System.in);
        int minute = Integer.parseInt(input.nextLine());


        println("Swiping for " + Integer.toString(minute) + " minutes");
        
        println("Left Click");
        bot.mouseClick(InputEvent.BUTTON1_MASK);
        println("Starting key taps");
        
        bot.keyTapTimed(KeyEvent.VK_RIGHT, minute);
        println("DONE");
        
    }
    
    static void welcomeMSG(){
        String msg = "* " + "Welcome to Macro" + " *";
        for(int i=0; i<msg.length()+4; i++){print("*");}
        println();
        print(msg);
        println();
        for(int i=0; i<msg.length()+4; i++){print("*");}
        println();
        
    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}
}