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
  
  //store if the claw has a ball or disk
  boolean HoldingItem = false;
  //is a button pressed
  boolean Pressed;

  //is the a key pressed
  boolean aPressed = false;

  //lock pressed?
  boolean ResetPressed = false;

  //store the value of where the claw should be
  double Speed = 0.0;
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

    //SmartDashboard.putBoolean("TopClaw",Map.TopClawSwitch.CheckState());
    //SmartDashboard.putBoolean("BottemClaw",Map.BottemClawSwitch.CheckState());

    //check to make sure the claw isnt touhing the top or bottem
    if(Map.controllerTwo.Controller.getPOV()==0)
    {
      //Speed = 0.25;
      Map.LeftClawMotor.set(0.45);
    }else{
      
      Map.LeftClawMotor.set(0.2);
    }
    //check to make sure the claw isnt touhing the top or bottem
    if(Map.controllerTwo.Controller.getPOV()==180)
    {
        //Speed = -0.25;
        Map.LeftClawMotor.set(-0.25);
    }
  /*  else
    {
      Map.LeftClawMotor.set(0);
    }*/

    if(Map.TopClawSwitch.CheckState())
    {
      //Speed += 0.01;
    }
    
    if(Map.BottemClawSwitch.CheckState())
    {
      //Speed -=0.01;
    }

    if(Speed > 1)
    {
      Speed =1;
    }else if(Speed < -1)
    {
      Speed = -1;
    }
    //display spped
    SmartDashboard.putNumber("Claw Speed", Speed);

    //setSpeed
    //Map.LeftClawMotor.set(Speed);

    //check to see if the person is locking 
    if(Map.controllerTwo.B_Button())
    {
      if(!ResetPressed)
      {
        Speed = 0.0;
      }else{
        ResetPressed=true;
      }
    }else{
      ResetPressed = false;
    }
    //set the speed
    
    
  
    //control the claw acuator
    if(Map.controllerTwo.RightBumper())//is the right bumber pressed
    {
      if(!Pressed)
      {
        Open = true;
        Pressed = true;
      }
    }else if(Map.controllerTwo.LeftBumper()) //is the Left bumper set?
    {
      if(!Pressed)
        {
        Open = false;
        Pressed = true;
        }
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

    /*
    //display if you have the claw in holding mode 
    SmartDashboard.putBoolean("is in holding mode?", HoldingItem);
  
    //check if the person is switching mode
    if(Map.controllerTwo.A_Button())
    {
      if(!aPressed)
      {
        HoldingItem = !HoldingItem;
      }
      aPressed = true;
    }else
      aPressed = false;

      //check what mode its in
      if(HoldingItem)
      {
        Map.LeftClawMotor.set(0.20);
      }*/
  }
  
  @Override
  public void initDefaultCommand() 
  {
  }
}
