/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import javax.lang.model.util.ElementScanner6;

//import robotmap
import frc.robot.RobotMap;
//dashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * system for the elevator
 */
public class ElevatorSubSystem extends Subsystem 
{
  //controller values
  boolean Pressed = false;

  //current level
  int CurrentLevel = 0;

  //level to go to
  int SetLevel = 0;

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
    //controller
    if(Map.controllerTwo.LeftYAxis() > 0.2)     //check if its being pressed up
    {
      //check to see if the controller is already pressed
      if(!Pressed)
      {
        //if not incrament the set value
        SetLevel++;
      }
      Pressed = true;
    }else if(Map.controllerTwo.LeftYAxis() < -0.2)     //check if its being pressed downn
    {
      //check to see if the controller is already pressed
      if(!Pressed)
      {
        //if not deincrament the set value
        SetLevel++;
      }
      Pressed = true;
    }else{//nothing is being pressed that we care about so change pressed to false
      Pressed = false;
    }

    //TODO implement sensors



    //is it below
    if(CurrentLevel < SetLevel)
    {
      Map.Elevator.set(0.2);
      SmartDashboard.putBoolean("DB/LED 0", false);
    }
    //is it above
    if(CurrentLevel > SetLevel)
    {
      Map.Elevator.set(-0.2);
      SmartDashboard.putBoolean("DB/LED 0", false);
    }
    //is it at the set level
    if(CurrentLevel == SetLevel)
    {
      Map.Elevator.set(0.0);
      SmartDashboard.putBoolean("DB/LED 0", true);
    } 

    //display values
    SmartDashboard.putString("DB/String 0", "CurrentLevel");
    SmartDashboard.putString("DB/String 1", "SetLevel");
    
    SmartDashboard.putString("DB/String 5", Integer.toString(CurrentLevel));
    SmartDashboard.putString("DB/String 6", Integer.toString(SetLevel));

  }

  @Override
  public void initDefaultCommand() 
  {
  }
}
