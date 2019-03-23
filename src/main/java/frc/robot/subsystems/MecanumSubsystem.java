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
 
public class MecanumSubsystem extends Subsystem 
{

  //Declare motors with their ports
  private static final int kFrontLeftChannel = 2;
  private static final int kRearLeftChannel = 3;
  private static final int kFrontRightChannel = 1;
  private static final int kRearRightChannel = 0;

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

    // Invert the left side motors.
    // You may need to change or remove this to match your robot.
    frontLeft.setInverted(true);
    rearLeft.setInverted(true);

    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
 
  }

  private MecanumDrive mecanumDrive;

  //Hardcoded to use the joypad that will be defined in OI. Maybe pass instead?
  public void drive()
  {
    //mecanumDrive.driveCartesian(map.controllerOne.LeftXAxis()/2, map.controllerOne.LeftYAxis()/2, map.controllerOne.RightXAxis()/2, 0.0);
    if(map.controllerOne).A_Button())
    {
      mecanumDrive.driveCartesian((map.controllerOne.LeftTrigger()/2*-1)+(map.controllerOne.RightTrigger()/2), map.controllerOne.LeftYAxis()/2, map.controllerOne.LeftXAxis()/2, map.gyro.getAngle());
    }else
      mecanumDrive.driveCartesian((map.controllerOne.LeftTrigger()/2*-1)+(map.controllerOne.RightTrigger()/2), map.controllerOne.LeftYAxis()/2, map.controllerOne.LeftXAxis()/2, map.gyro.getAngle());
  
  }

  @Override
  public void initDefaultCommand() 
  {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
*/