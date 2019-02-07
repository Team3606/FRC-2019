/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

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
  //TODO set level heights level heights
  int Heights[] = {0,1,2,3,4,5,6,7};
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

    //set the level from ultrasonic sensor
    if(Heights[0]+1 > Map.Ultra.getRangeInches()&& Heights[0]-1 < Map.Ultra.getRangeInches())//first level
    {
      CurrentLevel = 1;
    }else if(Heights[1]+1 > Map.Ultra.getRangeInches()&& Heights[1]-1 < Map.Ultra.getRangeInches())//seconed level
    {
      CurrentLevel = 2;
    }else if(Heights[2]+1 > Map.Ultra.getRangeInches()&& Heights[2]-1 < Map.Ultra.getRangeInches())//third level
    {
      CurrentLevel = 3;
    }else if(Heights[3]+1 > Map.Ultra.getRangeInches()&& Heights[3]-1 < Map.Ultra.getRangeInches())//forth level
    {
      CurrentLevel = 4;
    }else if(Heights[4]+1 > Map.Ultra.getRangeInches()&& Heights[4]-1 < Map.Ultra.getRangeInches())//fith level
    {
      CurrentLevel = 5;
    }else if(Heights[5]+1 > Map.Ultra.getRangeInches()&& Heights[5]-1 < Map.Ultra.getRangeInches())//sith level
    {
      CurrentLevel = 6;
    }else if(Heights[6]+1 > Map.Ultra.getRangeInches()&& Heights[6]-1 < Map.Ultra.getRangeInches())//seventh level
    {
      CurrentLevel = 7;
    }else if(Heights[7]+1 > Map.Ultra.getRangeInches()&& Heights[7]-1 < Map.Ultra.getRangeInches())//eighth level
    {
      CurrentLevel = 8;
    }

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
        CurrentLevelName = "pickupball";
      break;
      case 1:
      CurrentLevelName = "pickup panel";
      break;
      case 2:
      CurrentLevelName = "Panel level 1 / cargoship";
      break;
      case 3:
      CurrentLevelName = "Panel level 2";
      break;
      case 4:
      CurrentLevelName = "Panel Level 3";
      break;
      case 5:
      CurrentLevelName = "Ball Level 1";
      break;
      case 6:
      CurrentLevelName = "Ball Level 2";
      break;
      case 7:
      CurrentLevelName = "Ball Level 3";
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

    //display the level 
    SmartDashboard.putNumber("CurrentHeight", Map.Ultra.getRangeInches());
  }

  @Override
  public void initDefaultCommand() 
  {
  }
}
