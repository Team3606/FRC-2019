/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import javax.lang.model.util.ElementScanner6;

import com.sun.tools.sjavac.Log.Level;

//import robotmap
import frc.robot.RobotMap;
//dashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * system for the elevator
 */
public class ElevatorSubSystem extends Subsystem 
{
  //level names
  String CurrentLevelName = "";
  String SetLevelName = "";

  //make a storage varable for the mode
  String mode = "PanelMode";

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
    //check for a switch in modes 
    if(Map.controllerTwo.Y_Button())
    {
      if(!Pressed)
      {
        mode = "PanelMode";
        Manual = false;
      }
      Pressed = true;
    }else if(Map.controllerTwo.B_Button())
    {
      if(!Pressed)
      {
        mode = "BallMode";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.X_Button())
    {
      if(!Pressed)
      {
        mode = "CargoShip";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.A_Button())
    {
      if(!Pressed)
      {
        mode = "Reserved";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.LeftYAxis() < -0.2)     //check if its being pressed up
    {
      if(!Pressed)
      {
        DPad = "Up";
        Manual = false;
      }
      Pressed = true;

    }else if(Map.controllerTwo.LeftYAxis() > 0.2)     //check if its being pressed down
    {
      if(!Pressed)
      {
        DPad = "Down";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.LeftXAxis() > 0.2)     //check if its being pressed left
    {
      if(!Pressed)
      {
        DPad = "Left";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.LeftXAxis() < -0.2)     //check if its being pressed right
    {
      if(!Pressed)
      {
        DPad = "Right";
        Manual = false;
      }
      Pressed = true;
      
    }else{
      //set the direction to none 
      DPad = "none";

      //set pressed to false
      Pressed = false;
    }

    //display the current mode
    SmartDashboard.putString("Current Elevador Mode", mode);

    //TODO get actual level numbers
    //do what ya need to do for the mode
    switch(mode)
    {
      case "PanelMode":
      switch(DPad)
      {
        case "Left":
        SetLevel = 2;
        break;
        case "Up":
        SetLevel = 3;
        break;
        case "Right":
        SetLevel = 4;
        break;
        case "Down":
        SetLevel = 1;
        break;
      }
      break;
      case "BallMode":
      switch(DPad)
      {
        case "Left":
        SetLevel = 3;
        break;
        case "Up":
        SetLevel = 6;
        break;
        case "Right":
        SetLevel = 7;
        break;
        case "Down":
        SetLevel = 0;
        break;
      }
      break;
      case "CargoShip":
      switch(DPad)
      {
        case "Left":
        SetLevel = 2;
        break;
        case "Up":
        SetLevel = 0;
        break;
        case "Right":
        SetLevel = 2;
        break;
        case "Down":
        SetLevel = 1;
        break;
      }
      break;
      case "Reserved":
      switch(DPad)
      {
        case "Left":
        SetLevel = 0;
        break;
        case "Up":
        SetLevel = 0;
        break;
        case "Right":
        SetLevel = 0;
        break;
        case "Down":
        SetLevel = 0;
        break;
      }
      break;
    }

    if(SetLevel < 0)
    {
      SetLevel = 0;
    }
    if(SetLevel > 8)
    {
      SetLevel = 8;
    }
    //TODO implement sensors



    //is it below
    if(CurrentLevel < SetLevel)
    {
      Map.Elevator.set(0.2);
      SmartDashboard.putBoolean("Is current level = to set level", false);
    }
    //is it above
    if(CurrentLevel > SetLevel)
    {
      Map.Elevator.set(-0.2);
      SmartDashboard.putBoolean("Is current level = to set level", false);
    }
    //is it at the set level
    if(CurrentLevel == SetLevel)
    {
      Map.Elevator.set(0.0);
      SmartDashboard.putBoolean("Is current level = to set level", true);
    } 

    //display values

    //display the level name
    switch(CurrentLevel)
    {
      case 0:
        CurrentLevelName = "Level 1";
      break;
      case 1:
      CurrentLevelName = "Level 2";
      break;
      case 2:
      CurrentLevelName = "Level 3";
      break;
      case 3:
      CurrentLevelName = "Level 4";
      break;
      case 4:
      CurrentLevelName = "Level 5";
      break;
      case 5:
      CurrentLevelName = "Level 6";
      break;
      case 6:
      CurrentLevelName = "Level 7";
      break;
      case 7:
      CurrentLevelName = "Level 8";
      break;
    }
    SmartDashboard.putString("CurrentLevel", CurrentLevelName);

    //display the level its set to
    switch(CurrentLevel)
    {
      case 0:
      SetLevelName = "Level 1";
      break;
      case 1:
      SetLevelName = "Level 2";
      break;
      case 2:
      SetLevelName = "Level 3";
      break;
      case 3:
      SetLevelName = "Level 4";
      break;
      case 4:
      SetLevelName = "Level 5";
      break;
      case 5:
      SetLevelName = "Level 6";
      break;
      case 6:
      SetLevelName = "Level 7";
      break;
      case 7:
      SetLevelName = "Level 8";
      break;
    }
    SmartDashboard.putString("SetLevel", SetLevelName);

  }

  @Override
  public void initDefaultCommand() 
  {
  }
}
