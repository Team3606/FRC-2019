/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
//import static org.junit.Assume.assumeNoException;

//import java
//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.*;
//import frc.robot.OI;
import team3606.XBoxController;
//import  limit switches
import team3606.LimitSwitch;
//import hall effect
import team3606.HallEffect;
//ultrasonic
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.SerialPort.Port;

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

  //makemotors for claw
  public PWMVictorSPX LeftClawMotor;
  public PWMVictorSPX RightClawMotor;

  //controllers
  public XBoxController controllerOne;
  public XBoxController controllerTwo;

  //ultrasonic sensor
	public AnalogInput Ultra;

  //hall effect sensor
  public HallEffect HallEffectSensors[];

  //motors for elevator
  public PWMVictorSPX LeftElevador;
  public PWMVictorSPX RightElevador;
  
  //limit switches for claw
  public LimitSwitch BottemClawSwitch;
  public LimitSwitch TopClawSwitch;
  
  //limit switches for elevador
  public LimitSwitch BottemElevadorSwitch;
  public LimitSwitch TopElevadorSwitch;
  
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
  
    //TODO Set ultrasonic sensor port
    Ultra = new AnalogInput(2);

    //TODO set claw motor ports
      
    LeftClawMotor = new PWMVictorSPX(6);
    RightClawMotor = new PWMVictorSPX(7);

    //set limit switches 
    //claw switches
    BottemClawSwitch = new LimitSwitch(0);
    TopClawSwitch = new LimitSwitch(1);
    
    //elevador switches
    BottemClawSwitch = new LimitSwitch(6);
    TopClawSwitch = new LimitSwitch(7);

    //set elevador motors
    LeftElevador = new PWMVictorSPX(8);
    RightElevador = new PWMVictorSPX(9);

  }
}
