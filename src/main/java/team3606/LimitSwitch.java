package team3606;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//class for making limit switches
public class LimitSwitch{    
    //make a digital input object
    DigitalInput Port;
    //constructor
    public LimitSwitch(int p)
    {
        //init the digital input
        Port= new DigitalInput(p);
    }
    //checking the state of the port 
    public boolean CheckState()
    {
        //return the state of the port
        return Port.get();
    }
}
