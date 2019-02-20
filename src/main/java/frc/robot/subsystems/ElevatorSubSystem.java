/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.Map;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.command.Subsystem;

//import com.sun.tools.sjavac.Log.Level;

//import robotmap
import frc.robot.RobotMap;
//dashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * system for the elevator
 */
public class ElevatorSubSystem extends Subsystem 
{
  //TODO set switch level
  double switchLevel;

  //TODO set level heights level heights
  double Heights[] = {(12*4),12.5,12+7,(12*3),(6*12)+3,24+3.25,(4+12)+7.5,(12*7)+10};
  //level names
  String CurrentLevelName = "";
  String SetLevelName = "";

  //make a storage varable for the mode
  String mode = "Manual";

  //save the mode for when you go into manual
  String save = "";

  //make a varable to hold the direction the Dpad is being pressed
  String DPad = "none";

  //make a bool for manual
  boolean Manual = false;

  //controller values
  boolean Pressed = false;

  //current level
  int CurrentLevel = 0;

  //level to go to
  int SetLevel = 0;

  //make  a bool to see if the Elevator was going up
  boolean up;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  RobotMap Map;
  public ElevatorSubSystem(RobotMap m) 
  {
    Map = m;
    Pressed = false;
    SetLevel = 0;
    CurrentLevel = 0;
  }
  
  public void Teleop()
  {
    //check if the right trigger is pressed
    if(Map.controllerTwo.RightTrigger() > 0.9)
    {
      //set the bool up to treu
      up = true;
      //check to make sure you arnt hitting the top
      if(Map.topElevatorSwitch.CheckState())
      {
        //go up
        Map.leftElevator.set(-0.3);
        Map.rightElevator.set(0.3);
      }
      //else check to see if the left is being pressed
    }else if(Map.controllerTwo.LeftTrigger() > 0.9)
    {
      //set going up to false
      up = false;
      //ccheck to see if its hitting the bottem
      if(Map.topElevatorSwitch.CheckState())
      {
        //go down
        Map.leftElevator.set(0.3);
        Map.rightElevator.set(-0.3);
      }
    }else{
      //check if you were going up
      if(up)
      {
        //hold the elevator to keep it from falling
        Map.leftElevator.set(-0.1);
        Map.rightElevator.set(0.1);
      }else{
        //else you were going down anyway so let it fall
        Map.leftElevator.set(0);
        Map.rightElevator.set(0);

      }
    }

  }

  //is this even needed?
  @Override
  public void initDefaultCommand() 
  {
  }
}
 