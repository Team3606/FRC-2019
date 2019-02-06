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
//import hall effect
import team3606.HallEffect;
//ultrasonic
import edu.wpi.first.wpilibj.Ultrasonic;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around. it also provides controllers for shared use in subsystems
 */
public class RobotMap 
{
  //pnumatics
  //compressor
  public Compressor compressor;

  //make objet for the claw
  public DoubleSolenoid clawSolenoid;

  //controllers
  public XBoxController controllerOne;
  public XBoxController controllerTwo;

  //ultrasonic sensor
	public Ultrasonic Ultra;

  //hall effect sensor
  public HallEffect HallEffectSensors[];

  //motor for elevator
  public PWMVictorSPX Elevator;
  
  //connect to arduion for line reader
  RobotMap()
  {
    //set compressor port
    compressor = new Compressor(0);

    //set automatic
    compressor.setClosedLoopControl(false);

    //TODO set solinoid ports
    clawSolenoid = new DoubleSolenoid(1, 2);

    //SET CONTROLLER PORTS
    controllerOne = new XBoxController(0);
    controllerTwo = new XBoxController(1);
    
    //TODO set elevtor motor ports
    Elevator = new PWMVictorSPX(4);

    //TODO Set ultrasonic sensor port
    Ultra = new Ultrasonic(1,1);
    
  }
}
