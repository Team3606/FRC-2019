/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Button;
import team3606.XBoxController;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
  // Definition for our two controlers
  XBoxController driverController = new XBoxController(0);
  XBoxController gunnerController = new XBoxController(1);

  // Test case - can be removed when first real button is active
  Button testButton = new JoystickButton(driverController.Controller, driverController.ButtonByName('a'));

  // Constructor for OI instance
  // Define what each button does by putting "new CommandName" as argument
  // You have three options:
  // 1. whenPressed() - Starts the command when the button is pressed, finished with isFinished
  // 2. whileHeld() - Runs the command while the button is down, interupts when the button is released
  // 3. whenReleased() - Starts the command when the button is released, finished with isFinished
  public OI()
  {
     // Test case - can be removed when first real button is active
    testButton.whenPressed(new ExampleCommand());
  }
}
