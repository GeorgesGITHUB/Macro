import java.awt.Robot;
import java.awt.AWTException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class RobotPlus extends Robot 
{
    LocalTime time;
    // Constructors
    /* 
    Robot requires to catch an AWTException upon instantiating.
    "throws AWTException" allows exception handling to be passed to
    whatever initialises RobotPlus. 
    Fitting because RobotPlus is an extension of Robot.
    */
    public RobotPlus() throws AWTException { super(); time = LocalTime.now();}

    public RobotPlus(int millisecond) throws AWTException { 
        super();
        super.setAutoDelay(millisecond);
        time = LocalTime.now();
    }

    // Class functions
    public void setActionDelay(int millisecond){
        super.setAutoDelay(millisecond);
    }

    public int getActionDelay(){
        return super.getAutoDelay();
    }

    public void keyTap(int keycode){
        super.keyPress(keycode); super.keyRelease(keycode);
        println("Key Tapped");
    }

    public void mouseClick(int button){
        super.mousePress(button); super.mouseRelease(button);
        println("Mouse Clicked");
    }

    public void keyTap(int keycode, int repeat){
        for(int i=0; i<repeat; i++){
            keyTap(keycode);
            String msg = "Key Taps Remaining :"+Integer.toString(repeat-i);
            println(msg);
        }
    }

    public void mouseClick(int button, int repeat){
        for(int i=0; i<repeat; i++){ 
            mouseClick(button);
            String msg = "Mouse Clicks Remaining :"+Integer.toString(repeat-i);
            println(msg);
        }
    }
    
    public void keyTapTimed(int keycode, int minute){
        long target = System.nanoTime() + TimeUnit.MINUTES.toNanos(minute);
        println(target); //DEBUG
        while( target > System.nanoTime() ){ 
            println("while condition met"); //DEBUG
            keyTap(keycode); }
    }

    public void mouseClickTimed(int button, int minute){
        LocalTime target = time.plusMinutes(minute);
        while( LocalTime.now().compareTo(target)<0 ){ mouseClick(button); }
    }

    // For code readability
    static void println(Object o){ System.out.println(o);}
    static void print(Object o){ System.out.print(o);}
    static void println(){ System.out.println();}

    
}