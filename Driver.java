import java.awt.AWTException;
import java.util.Scanner;

public class Driver 
{
    public static void main(String args[]){
    
        RobotPlus bot= new RobotPlus();

        println("Enter number of minutes to swipe for: ");

        Scanner input = new Scanner(System.in);
        int minutes = Integer.parseInt(input.nextLine());
        input=null;

        println("Swiping for " + Integer.toString(minutes) + " minutes");
        
        bot.leftMouseClick();
        bot.rightArrowPress(minutes, "minutes");
        
        println("DONE");
    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}
}