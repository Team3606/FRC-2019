package team3606;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;


public class XBoxController 
{
	// assign the id numbers for the analog ports on the joystick
	int id_LeftXAxis = 0;
	int id_LeftYAxis = 1;
	int id_LeftTrigger = 2;
	int id_RightTrigger = 3;
	int id_RightXAxis = 4;
	int id_RightYAxis = 5;
	
	// assign the id numbers for the analog ports on the joystick
	int id_A_Button = 1;
	int id_B_Button = 2;
	int id_X_Button = 3;
	int id_Y_Button = 4;
	int id_LeftBumper = 5;
	int id_RightBumper = 6;
	int id_SelectButton = 7;
	int id_StartButton = 8;

	public Joystick Controller;
	
	Button test;
	
	public XBoxController(int joystick_USB_port) 
	{
		Controller = new Joystick(joystick_USB_port);
	}

	public double LeftXAxis (){
		
		return Controller.getRawAxis(id_LeftXAxis);
	}
	public double LeftYAxis (){
		
		return Controller.getRawAxis(id_LeftYAxis);
	}
	public double RightXAxis (){
		
		return Controller.getRawAxis(id_RightXAxis);
	}
	public double RightYAxis (){
		
		return Controller.getRawAxis(id_RightYAxis);
	}
	public double LeftTrigger (){
		
		return Controller.getRawAxis(id_LeftTrigger);
	}
	public double RightTrigger (){
		
		return Controller.getRawAxis(id_RightTrigger);
	}
	public boolean A_Button (){
		
		return Controller.getRawButton(id_A_Button);
	}
	public boolean B_Button (){
		
		return Controller.getRawButton(id_B_Button);
	}
	public boolean X_Button (){
		
		return Controller.getRawButton(id_X_Button);
	}
	public boolean Y_Button (){
		
		return Controller.getRawButton(id_Y_Button);
	}
	public boolean LeftBumper (){
		
		return Controller.getRawButton(id_LeftBumper);
	}
	public boolean RightBumper (){
		
		return Controller.getRawButton(id_RightBumper);
	}
	public boolean SelectButton (){
		
		return Controller.getRawButton(id_SelectButton);
	}
	public boolean StartButton (){
		
		return Controller.getRawButton(id_StartButton);
	}
	
	public boolean RawButton(int x)
	{
		return Controller.getRawButton(x);
	}

	public int ButtonByName(char button)
	{
		if(button == 'a' || button == 'A')
		{
			return id_A_Button;
		} else if (button == 'b' || button == 'B') 
		{
			return id_B_Button;
		} else if (button == 'x' || button == 'X') 
		{
			return id_X_Button;
		} else if (button == 'y' || button == 'Y') 
		{
			return id_Y_Button;
		}

		// TODO - Finish this

		return 0;
	}

}
