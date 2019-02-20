/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import static org.junit.Assume.assumeNoException;

//ultrasonic

//import java
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.*;
//import frc.robot.OI;
import team3606.XBoxController;
//import  limit switches
import team3606.LimitSwitch;
//import hall effect
import team3606.HallEffect;//ultrasonic
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around. it also provides controllers for shared use in subsystems
 */
public class RobotMap 
{
  /*--------pnumatics--------*/
  //compressor
  public Compressor compressor;
  //make solonoid for the claw
  public DoubleSolenoid clawSolenoid;
  
  /*--------CONTROLLERS--------*/
  //controllers
  public XBoxController controllerOne;
  public XBoxController controllerTwo;

  /*--------MOTORS--------*/
  //makemotors for claw
  public Spark clawMotor;
  //motors for elevator
  public PWMVictorSPX leftElevator;
  public PWMVictorSPX rightElevator;

  /*--------SWITCHES--------*/
  //limit switches for claw
  public LimitSwitch bottomClawSwitch;
  public LimitSwitch topClawSwitch;
  //limit switches for Elevator
  public LimitSwitch bottomElevatorSwitch;
  public LimitSwitch topElevatorSwitch;
  
  //connect to arduion for line reader
  RobotMap()
  {
    /*--------pnumatics--------*/
    //set compressor port
    compressor = new Compressor(0);
    compressor.setClosedLoopControl(true);
    //TODO set solinoid ports
    clawSolenoid = new DoubleSolenoid(0, 1);
    /*--------CONTROLLERS--------*/
    controllerOne = new XBoxController(0);
    controllerTwo = new XBoxController(1);
    /*--------MOTORS--------*/
    clawMotor = new Spark(6);
    //set Elevator motors
    leftElevator = new PWMVictorSPX(8);
    rightElevator = new PWMVictorSPX(9);
    /*--------SWITCHES--------*/
    //claw switches
    bottomClawSwitch = new LimitSwitch(1);
    topClawSwitch = new LimitSwitch(0);
    //Elevator switches
    bottomElevatorSwitch = new LimitSwitch(2);
    topElevatorSwitch = new LimitSwitch(3);
  }
}
