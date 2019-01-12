/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;

//import frc.robot.OI;
import team3606.XBoxController;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
  //controllers
  public XBoxController controllerOne;
  public XBoxController controllerTwo;

  //spark motors
  /*
  public Spark spark1 = new Spark(10);
  public Spark spark2 = new Spark(11);
  public Spark spark3 = new Spark(12);
  public Spark spark4 = new Spark(13);
  */
  RobotMap()
  {
    controllerOne = new XBoxController(0);
    controllerTwo = new XBoxController(1);
    /*
    spark1.enableDeadbandElimination(true);
    spark2.enableDeadbandElimination(true);
    spark3.enableDeadbandElimination(true);
    spark4.enableDeadbandElimination(true);*/
    
  }
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
