/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
//import robotmap
import frc.robot.RobotMap;
//serial
import edu.wpi.first.wpilibj.SerialPort.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class LineAlignmentSubSystem extends Subsystem 
{
    //make a robotmap
    RobotMap map;

    //serial port for arduino
    SerialPort sensor;
    LineAlignmentSubSystem(RobotMap m, Port p)
    {
        //TODO find out baud rate and port
        sensor = new SerialPort(1100, p);
        //set the robot map
        map = m;
    }

    public void Teleop()
    {

    }

    @Override
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
