import java.awt.Robot;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.Point;

import java.awt.Point;
import java.awt.MouseInfo;
import java.awt.PointerInfo;

public class RobotPlus extends Robot
{
    //instance variables
    boolean debug=false;

    // Constructor
    //Robot instantiation requires to catch an AWTException
    public RobotPlus() throws AWTException {
        super();
        super.setAutoDelay(150);
    }
    public RobotPlus(int mode) throws AWTException {
        super();
        super.setAutoDelay(150);
        debug = ( mode == -1 ) ? true : false;
    }

    //Frequently Used Functions
    public int[] getMouseXY(){
        Point p = MouseInfo.getPointerInfo().getLocation();
        return new int[]{p.x, p.y};
    }

    public void wait(int time, String unit){
        long target = duration(time, unit);
        while( target > System.nanoTime() ){} //waiting
    }

    public void leftMouseClick(){ mouseClick(KeyEvent.BUTTON1_MASK);}
    
    public void rightArrowPress(){ keyTap(KeyEvent.VK_RIGHT);}
    
    public void leftMouseClick(int time, String unit){ mouseClickTimed(KeyEvent.BUTTON1_MASK, time, unit);}
    
    public void rightArrowPress(int time, String unit){ keyTapTimed(KeyEvent.VK_RIGHT, time, unit);}
    
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
        super.keyPress(keycode); super.keyRelease(keycode);
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
        super.mousePress(button); super.mouseRelease(button);
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


//Parent Getters Setters
    public void setActionDelay(int millisecond){ super.setAutoDelay(millisecond); }
    public int getActionDelay(){ return super.getAutoDelay(); }

//Syntax Beautifier Code
    static void println(Object o){ System.out.println(o);}
    static void println(){ System.out.println();}
    static void print(Object o){ System.out.print(o);}

}