/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* open Source Software - may be modified and shared by FRC teams. The code   */
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
  //make an object for robot map
  RobotMap Map;
  //Store the state of the claw 
  boolean open;
  //store the value of where the claw should be
  double speed = 0.0;
  //store max speeds
  double maxReverse = 0.0;
  double maxForward = 0.0;

  public ClawSystem(RobotMap m) 
  {
    //store robot map
    Map = m;
    //set the claw to close
    open = false;

    //set the max speeds
    maxReverse = -1;
    maxForward = 1;
  }

  //teleop functions
  public void Teleop()
  {
    //is the person pressing up?
    if(Map.controllerTwo.Controller.getPOV()==0)
    {
      //increment speed
      speed = 0.25;
    //else is john pressing down?
    }else if(Map.controllerTwo.Controller.getPOV()==180)
    {
        //deincrement speed
        speed = -0.25;
    }
    
    /*------Display-----*/
    //speed
    SmartDashboard.putNumber("Clawspeed", speed);
    //top switch
    SmartDashboard.putBoolean("Touching Top?", !Map.topClawSwitch.CheckState());
    //bottom switch
    SmartDashboard.putBoolean("Touching Bottom?", !Map.bottomClawSwitch.CheckState());
    /*----speed control----*/
    //check if speed is more than max
    if(speed > maxForward)
    {
      //set it to max
      speed =maxForward;
    //check if speed is more then max reverse
    }else if(speed < maxReverse)
    {
      //set it to max reverse
      speed = maxReverse;
    }
    //set the speed
    Map.clawMotor.set(speed);

    /*----Acuator----*/
    //is it being oppened?
    if(Map.controllerTwo.RightBumper())//is the right bumber pressed
    {
      //open claw
      Map.clawSolenoid.set(DoubleSolenoid.Value.kForward);
      //set open to true
      open = true;
    //is it being closed
    }else if(Map.controllerTwo.LeftBumper()) //is the Left bumper set?
    {
      //close claw
      Map.clawSolenoid.set(DoubleSolenoid.Value.kReverse);
      //set open to false
      open = false;
    }
    //display claw state
    SmartDashboard.putBoolean("Is Claw open", open);
  }
  
  @Override
  public void initDefaultCommand() 
  {
  }
}
