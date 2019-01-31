package team3606;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//class for communicating with the pixy line reader
public class Pixy{    
    //make a digital port object
    SerialPort Port;
    //constructor
    public Pixy(int p)
    {
        //TODO set right baud rate
        //open the port
        switch(p)
        {
            case 0:
            Port = new SerialPort(9600, SerialPort.Port.kUSB);
            break;
            case 1:
            Port = new SerialPort(9600, SerialPort.Port.kUSB1);
            break;
            case 2:
            Port = new SerialPort(9600, SerialPort.Port.kUSB2);
            break;
        }
    }
    //check if it is active
    public int[] Read()
    {
        //make a string to hold information
        String message = new String();
        //return the state of the port
        message = Port.readString();
        //check to see if the message has the correct syntax
        
        if(message.length() < 0 && message.charAt(0) != (199))
        {
            SmartDashboard.putBoolean("Pixy Connection", false);
            int array[] = {0,0,-1};
            return array;
        }else{
            SmartDashboard.putBoolean("Pixy Connection", true);
            //split up the string
            int d = 0;
            //makes strings to store data
            String x = "", y = "" ,z = "";
            //devide up the information
            for(int f=1 ; f < message.length() &&  message.charAt(f) != 'p'; f++)
            {
                //move to the next interget
                if(message.charAt(f) == 123)
                {
                    d++;
                    f++;
                }
                switch(d)
                {
                    case(0)://its part of the x vlue
                    x+= message.charAt(f);
                    break;
                    case(1)://its part of the y vlue
                    y+= message.charAt(f);
                    break;
                    case(2)://its part of the z vlue
                    z+= message.charAt(f);
                    break;
                }
            }
            //convert and return it 
            int array[] = {Integer.parseInt(x),Integer.parseInt(y),Integer.parseInt(z)};
            return array;   
        }
    }
}