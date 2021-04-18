import java.awt.Robot;
import java.awt.AWTException;

public class RobotPlus extends Robot 
{
    // Constructors
    /* 
    Robot requires to catch an AWTException upon instantiating.
    "throws AWTException" allows exception handling to be passed to
    whatever initialises RobotPlus. 
    Fitting because RobotPlus is an extension of Robot.
    */
    public RobotPlus() throws AWTException { super(); }

    public RobotPlus(int millisecond) throws AWTException { 
        super();
        super.setAutoDelay(millisecond);
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
    }

    public void mouseClick(int button){
        super.mousePress(button); super.mouseRelease(button);
    }

    public void keyTap(int keycode, int repeat){
        for(int i=0; i<repeat; i++){ keyTap(keycode); }
    }

    public void mouseClick(int button, int repeat){
        for(int i=0; i<repeat; i++){ mouseClick(button); }
    }
    
    private int min_to_repeat(int min){ 
        return (int)( (double)(min * 60000) / (double)getActionDelay() ); }

    private int repeat_to_min(int repeat){ 
        return (int)( (double)( repeat*getActionDelay() ) / (double)60000 ) ; }

    public void keyTapTimed(int keycode, int minute){
        int repeat = min_to_repeat(minute);
        //System.out.println(repeat);
        for(int i=0; i<repeat; i++){ keyTap(keycode); }
    }

    public void mouseClickTimed(int button, int minute){
        int repeat = min_to_repeat(minute);
        for(int i=0; i<repeat; i++){ mouseClick(button); }
    }

    
}