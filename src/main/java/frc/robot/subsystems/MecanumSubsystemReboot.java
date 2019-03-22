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

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class MecanumSubsystemReboot extends Subsystem 
{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  
  //Declare motors with their ports
  private static final int kFrontLeftChannel = 0;
  private static final int kRearLeftChannel = 1;
  private static final int kFrontRightChannel = 2;
  private static final int kRearRightChannel = 3;

  private MecanumDrive mecanumDrive;

  RobotMap map;
  public MecanumSubsystemReboot(RobotMap m)
  {
    map = m;
    // TODO make sure that these controllers are correct
    PWMVictorSPX frontLeft = new PWMVictorSPX(kFrontLeftChannel);
    PWMVictorSPX rearLeft = new PWMVictorSPX(kRearLeftChannel);
    PWMVictorSPX frontRight = new PWMVictorSPX(kFrontRightChannel);
    PWMVictorSPX rearRight = new PWMVictorSPX(kRearRightChannel);

    frontLeft.setInverted(true);
    rearLeft.setInverted(true);
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    //frontLeft.setInverted(true);
    //rearLeft.setInverted(true);

    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
 
  } 

  public void drive()
  {
    //mecanumDrive.driveCartesian(map.controllerOne.RightXAxis()/2, map.controllerOne.LeftYAxis()/2, map.controllerOne.LeftXAxis()/2, 0);
    if(map.controllerOne.A_Button())
    {
      mecanumDrive.driveCartesian((-map.controllerOne.LeftXAxis()/4), map.controllerOne.LeftYAxis()/4, (-map.controllerOne.RightXAxis()/4))/*this is the correction for left to right ->-(map.controllerOne.LeftXAxis()*0.2), 0)*/;
    }else 
      mecanumDrive.driveCartesian((-map.controllerOne.LeftXAxis()/2), map.controllerOne.LeftYAxis()/2, (-map.controllerOne.RightXAxis()/2))/*this is the correction for left to right ->-(map.controllerOne.LeftXAxis()*0.2), 0)*/;
  
  }
}
