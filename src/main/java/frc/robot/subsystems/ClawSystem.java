/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//solinoid 
import edu.wpi.first.wpilibj.DoubleSolenoid;

import edu.wpi.first.wpilibj.command.Subsystem;

//import robotmap
import frc.robot.RobotMap;
//dashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * the Claw system
 */
public class ClawSystem extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //make an object for robot map
  RobotMap Map;

  //Store the state of the claw 
  boolean Open;
  
  //is a button pressed
  boolean Pressed;

  public ClawSystem(RobotMap m) 
  {
    //store robot map
    Map = m;

    //set the claw to close
    Open = false;
    
    //set the buton unpressed
    Pressed = false;
  }

  //teleop functions
  public void Teleop()
  {
    if(Map.controllerTwo.RightBumper())//is the right bumber pressed
    {
      if(!Pressed)
        Open = true;
        Pressed = true;
    }else if(Map.controllerTwo.LeftBumper()) //is the Left bumper set?
    {
      if(!Pressed)
        Open = true;
        Pressed = true;
    }else{
      Pressed = false;
    }

    //check if the claw is set to open
    if(Open)
    {
      //open claw 
      Map.clawSolenoid.set(DoubleSolenoid.Value.kForward);
    }else{
      //close claw
      Map.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    //display claw state
    SmartDashboard.putBoolean("Is Claw Open", Open);
  }
  
  @Override
  public void initDefaultCommand() 
  {
  }
}