/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
//import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import frc.robot.OI;
import team3606.XBoxController;
//import robotmap
import frc.robot.RobotMap;
//dashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * system for the elevator
 */
public class ElevatorSubSystem extends Subsystem 
{
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
  }
  
  public void Teleop()
  {
    //TODO implement sensors



    //is it below
    if(CurrentLevel < SetLevel)
      Map.Elevator.set(0.2);
    //is it above
    if(CurrentLevel > SetLevel)
      Map.Elevator.set(-0.2);
    //is it at the set level
    if(CurrentLevel == SetLevel)
      Map.Elevator.set(0.0);

    //display values
    SmartDashboard.putString("DB/String 0", "CurrentLevel");
    SmartDashboard.putString("DB/String 1", "SetLevel");
    
    SmartDashboard.putString("DB/String 5", string(CurrentLevel));
    SmartDashboard.putString("DB/String 6", string(SetLevel));

  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
