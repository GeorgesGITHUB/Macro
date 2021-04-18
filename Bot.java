/*

OLD VERSION
PLEASE TRASH

*/

import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.util.Scanner;

public class Bot
{
    static Robot bot;
    public static void main(String args[]){
        try 
        {   bot = new Robot(); 
            bot.setAutoDelay(240);
            System.out.println("Bot class instantiated"); 
        }
        catch (AWTException e) { e.printStackTrace(); }


        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of right swipes");
        int repeats = new Integer(input.nextLine());

        System.out.println("Left Click");
        click(InputEvent.BUTTON1_MASK);

        System.out.println("Right Key X times");
        pressRepeat(KeyEvent.VK_RIGHT, repeats);

        
    }

    //Class Methods

    //keycode takes from KeyEvent library (keyboard)
    static void press(int keycode){
        bot.keyPress(keycode); bot.keyRelease(keycode);
    }

    //button takes from InputEvent library (Mouse)
    static void click(int button){
        bot.mousePress(button); bot.mouseRelease(button);
    }

    static void pressRepeat(int keycode, int repeat){
        for(int x=0; x<repeat; x++)
        {
            String msg = "Key press remaining : " + (repeat-x);
            System.out.println(msg);

            bot.keyPress(keycode); bot.keyRelease(keycode);
        } 
    }

    //BROKEN
    static void pressTimedRepeat(int keycode, int mins){
        int repeat = (mins*60000) / bot.getAutoDelay();
        pressRepeat(keycode, repeat);
    }
}