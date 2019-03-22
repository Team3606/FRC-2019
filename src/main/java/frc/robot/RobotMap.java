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
//cameras
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.*;

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
  public Spark LeftClawMotor;
  public Spark RightClawMotor;

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
    //compressor.stop();
    //set automatic
    compressor.setClosedLoopControl(true);
    //compressor.start();

    //TODO set solinoid ports
    clawSolenoid = new DoubleSolenoid(0, 1);

    //SET CONTROLLER PORTS
    controllerOne = new XBoxController(0);
    controllerTwo = new XBoxController(1);
  

    //TODO set claw motor ports
      
    LeftClawMotor = new Spark(6);
    RightClawMotor = new Spark(7);

    //set limit switches 
    //claw switches
    BottemClawSwitch = new LimitSwitch(1);
    TopClawSwitch = new LimitSwitch(0);
    
    //elevador switches
    BottemElevadorSwitch = new LimitSwitch(2);
    TopElevadorSwitch = new LimitSwitch(3);

    //set elevador motors
    LeftElevador = new PWMVictorSPX(8);
    RightElevador = new PWMVictorSPX(9);

  }
}
