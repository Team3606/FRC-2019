/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import team3606.Pixy;
import team3606.HallEffect;
import edu.wpi.cscore.CameraServerJNI;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.MecanumSubsystem;

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  //make the robotmap
  public RobotMap robotMap;
  //make macanical drivesystem
  public MecanumSubsystem mecanumSystem;
  //elevator system
  public ElevatorSubSystem elevatorSystem;
  //claw system
  public ClawSystem clawSystem;

  //make the cam servers
//

  CameraServer camOne;
  CameraServer camTwo;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() 
  {
    //add cameras
    camOne.addAxisCamera("cam0");
    camTwo.addAxisCamera("cam0");
    //start servers
    camOne.getInstance().startAutomaticCapture();
    camTwo.getInstance().startAutomaticCapture();
    //init robot map
    robotMap = new RobotMap();
    //init elevator system
    elevatorSystem = new ElevatorSubSystem(robotMap);
    //init macanum system
    mecanumSystem = new MecanumSubsystem(robotMap);
    //init claw system
    clawSystem = new ClawSystem(robotMap);
  }

  /**
   * This function is called every robot packet
   */
  @Override
  public void robotPeriodic() 
  {
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() 
  {
    //clear everything
    //clear robot map
    robotMap = null;
    //clear elevator system
    robotMap = null;
    //clear macanum system
    robotMap = null;
    //clear claw system
    robotMap = null;

  }

  /** 
   * this runs while its disabled
  */
  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  /**
   * This runs before atonomous
   */
  @Override
  public void autonomousInit() 
  {

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() 
  {
    //init robot map
    robotMap = new RobotMap();
    //init elevator system
    elevatorSystem = new ElevatorSubSystem(robotMap);
    //init macanum system
    mecanumSystem = new MecanumSubsystem(robotMap);
    //init claw system
    clawSystem = new ClawSystem(robotMap);
  }


  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() 
  {
    //run elevator system
    elevatorSystem.Teleop();
    //run macanum system
    mecanumSystem.drive();//operatorInterface.driverController);
    //claw systme
    clawSystem.Teleop();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {

  }
}
