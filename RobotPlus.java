import java.awt.Robot;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;

public class RobotPlus 
{
    //instance variables
    boolean debug=false;
    Robot robot=null;

    // Constructor
    //Robot instantiation requires to catch an AWTException
    public RobotPlus(int mode) throws AWTException {
        robot = new Robot();
        debug = ( mode == -1 ) ? true : false;
    }

    public long duration(int time, String unit){
        //More options available in TimeUnit Class
        switch(unit)
        {
            case "seconds":
                return System.nanoTime() + TimeUnit.SECONDS.toNanos(time);
            case "minutes":
                return System.nanoTime() + TimeUnit.MINUTES.toNanos(time);
            case "hours":
                return System.nanoTime() + TimeUnit.HOURS.toNanos(time);
            default:
                println("unable to handle given unit in RobotPLus.duration \nLikely Syntax Error\nReturning 0");
                return 0;
        }
    }
//Keyboard functions
    public void keyTap(int keycode){
        robot.keyPress(keycode); robot.keyRelease(keycode);
    }

    public void keyTap(int keycode, int repeat){
        for(int i=0; i<repeat; i++){
            keyTap(keycode);
        }
    }

    public void keyTapTimed(int keycode, int time, String unit){
        long target = duration(time, unit);
        while( target > System.nanoTime() ){ keyTap(keycode); }
    }

//Mouse functions
    public void mouseClick(int button){
        robot.mousePress(button); robot.mouseRelease(button);
    }

    public void mouseClick(int button, int repeat){
        for(int i=0; i<repeat; i++){ 
            mouseClick(button);
        }
    }

    public void mouseClickTimed(int button, int time, String unit){
        long target = duration(time, unit);
        while( target > System.nanoTime() ){ mouseClick(button); }
    }

    //Frequently Used Functions
    public void leftMouseClick(){ mouseClick(KeyEvent.BUTTON1_MASK);}
    public void rightArrowPress(){ keyTap(KeyEvent.VK_RIGHT);}
    public void leftMouseClick(int button, int time, String unit){ mouseClickTimed(KeyEvent.BUTTON1_MASK, time, unit);}
    public void rightArrowPress(int button, int time, String unit){ keyTapTimed(KeyEvent.VK_RIGHT, time, unit);}

//Parent Getters Setters
    public void setActionDelay(int millisecond){ robot.setAutoDelay(millisecond); }
    public int getActionDelay(){ return robot.getAutoDelay(); }

//Syntax Beautifier Code
    static void println(Object o){ System.out.println(o);}
    static void println(){ System.out.println();}
    static void print(Object o){ System.out.print(o);}

}