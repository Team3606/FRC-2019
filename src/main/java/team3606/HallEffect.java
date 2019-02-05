package team3606;
//NOT USED
import edu.wpi.first.wpilibj.DigitalInput;

public class HallEffect{
    //make a digital port object
    public DigitalInput port;
    
    //constructor
    public HallEffect(int p)
    {
        //port
        port = new DigitalInput(p);
    }

    //check if it is active
    public boolean Check()
    {
        //return the state of the port
        return !port.get();
    }

}