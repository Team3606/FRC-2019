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
    if(Map.controllerTwo.Y_Button()&&mode != "Manual")
    {
      if(!Pressed)
      {
        mode = "PanelMode";
        Manual = false;
      }
      Pressed = true;
    }else if(Map.controllerTwo.B_Button()&&mode != "Manual")
    {
      if(!Pressed)
      {
        mode = "BallMode";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.X_Button()&&mode != "Manual")
    {
      if(!Pressed)
      {
        mode = "CargoShip";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.A_Button()&&mode != "Manual")
    {
      if(!Pressed)
      {
        mode = "Reserved";
        Manual = false;
      }
      Pressed = true;
    }else if(Map.controllerTwo.StartButton())// to/from manual
    {
      if(!Pressed)
      {
        if(mode == "Manual")
        {
          mode = save;
        }else 
          save = mode;
          mode = "Manual";
        Manual = false;
      }
      Pressed = true;
    }else if(Map.controllerTwo.Controller.getPOV()==0&&mode != "Manual")     //check if its being pressed up
    {
      if(!Pressed)
      {
        DPad = "Up";
        Manual = false;
      }
      Pressed = true;

    }else if(Map.controllerTwo.Controller.getPOV()==180&&mode != "Manual")     //check if its being pressed down
    {
      if(!Pressed)
      {
        DPad = "Down";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.Controller.getPOV()==270&&mode != "Manual")     //check if its being pressed left
    {
      if(!Pressed)
      {
        DPad = "Left";
        Manual = false;
      }
      Pressed = true;
      
    }else if(Map.controllerTwo.Controller.getPOV()==90&&mode != "Manual")     //check if its being pressed right
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
        SetLevel = 5;
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

    //TODO set up motors
    //is it below
    if(Heights[CurrentLevel] < Heights[SetLevel]&&mode != "Manual" && !Map.TopElevadorSwitch.CheckState())
    {
      Map.LeftElevador.set(0.4);
      Map.LeftElevador.set(-0.4); 
    }
    //is it above
    if(Heights[CurrentLevel] > Heights[SetLevel]&&mode != "Manual"&& !Map.BottemElevadorSwitch.CheckState())
    {
      //Map.LeftElevador.set(-0.4);
      //Map.LeftElevador.set(0.4);
    }
    //use the right up and down if its set to manual
    if(mode == "Manual")
    {
      
      Map.RightElevador.set(Map.controllerTwo.LeftYAxis()/3); 
      Map.LeftElevador.set(-Map.controllerTwo.LeftYAxis()/3); 
    }
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

    //display the height 
    SmartDashboard.putNumber("CurrentHeight", Map.Ultra.getAverageVoltage()/(0.15869139000000002/18));
  }

  @Override
  public void initDefaultCommand() 
  {
  }
}
