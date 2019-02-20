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
 * Subsystem for the mecanum drive system. Call drive functions from related commands
 */
public class MecanumSubsystem extends Subsystem 
{

  //Declare motors with their ports
  private static final int kFrontLeftChannel = 0;
  private static final int kRearLeftChannel = 1;
  private static final int kFrontRightChannel = 2;
  private static final int kRearRightChannel = 3;

  //Local reference to robot map
  RobotMap map;
  public MecanumSubsystem(RobotMap m)
  {
    map = m;
    // TODO make sure that these controllers are correct
    PWMVictorSPX frontLeft = new PWMVictorSPX(kFrontLeftChannel);
    PWMVictorSPX rearLeft = new PWMVictorSPX(kRearLeftChannel);
    PWMVictorSPX frontRight = new PWMVictorSPX(kFrontRightChannel);
    PWMVictorSPX rearRight = new PWMVictorSPX(kRearRightChannel);

    //invert the drive
    frontLeft.setInverted(true);
    rearLeft.setInverted(true);
    frontRight.setInverted(true);
    rearRight.setInverted(true);

    //make the new macanum drive
    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
 
  } 

  private MecanumDrive mecanumDrive;

  //Hardcoded to use the joypad that will be defined in OI. Maybe pass instead?
  public void drive()
  {
    //actualy run the drive
    mecanumDrive.driveCartesian((-map.controllerOne.LeftXAxis()/2), map.controllerOne.LeftYAxis()/2, (-map.controllerOne.RightXAxis()/2)/*this is the correction for left to right ->-(map.controllerOne.LeftXAxis()*0.2)*/, 0);
  }

  //not used, unsure if needed or not
  @Override
  public void initDefaultCommand() 
  {
  }
}
