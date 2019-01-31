/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import team3606.Pixy;
import team3606.HallEffect;
import edu.wpi.first.cameraserver.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot 
{
  //make a pixy
  Pixy t = new Pixy(0);
  //make the robotmap
  public RobotMap robotMap;
  //make macanical drivesystem
  public MecanumSubsystem mecanumSystem;
  //elevador system
  public ElevatorSubSystem elevadorSystem;

  // TODO - rename
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  //This function is run when the robot is first started up and should be used for any initialization code.
  public void robotInit() 
  {
    //init robot map
    robotMap = new RobotMap();
    //init elevador system
    elevadorSystem = new ElevatorSubSystem(robotMap);
    //init macanum system
    //mecanumSystem = new MecanumSubsystem(robotMap);

    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    //chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() 
  {
    
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() 
  {

  }

  @Override
  public void disabledPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() 
  {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() 
  {
    Scheduler.getInstance().run();
  }

  CameraServer server = CameraServer.getInstance();

  @Override
  public void teleopInit() 
  {
    //server.addAxisCamera("cam0");
    //CameraServer.getInstance().startAutomaticCapture();

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) 
    {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */

  HallEffect test = new HallEffect(1);
  
  @Override
  public void teleopPeriodic() 
  {

    int a[] = t.Read();

    //String mode = Integer.toString(a[0]) + Integer.toString(a[1]) + Integer.toString(a[2]);

    //SmartDashboard.putString("testing arduino", mode);

    SmartDashboard.setDefaultBoolean("test", test.Check());
    Scheduler.getInstance().run();
    
    elevadorSystem.Teleop();
    //mecanumSystem.drive();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() 
  {

  }
}
