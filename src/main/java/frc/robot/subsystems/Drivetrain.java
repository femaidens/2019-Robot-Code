
package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveTeleop;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */

public class Drivetrain extends Subsystem {
	public static AnalogGyro gyro = new AnalogGyro(1);
	// Put methods for controlling this subsystem
	// here. Call these from Commands
	// Initialize CANTalons
	  public static TalonSRX frontLeft = new TalonSRX(9);
	  public static TalonSRX rearLeft = new TalonSRX(7);
	  public static TalonSRX frontRight = new TalonSRX(1);
	  public static TalonSRX rearRight = new TalonSRX(2);

	  public static Joystick driveJoystick = new Joystick(RobotMap.driveJoyPort);
	  
	 
	  //public static PowerDistributionPanel PDP = new PowerDistributionPanel(35);
	

	// Initializing encoder

	//public static Encoder encoderLeft = new Encoder(RobotMap.encPort1, RobotMap.encPort2, true,
			//Encoder.EncodingType.k1X);
	//public static Encoder encoderRight = new Encoder(RobotMap.encPort3, RobotMap.encPort4, false,
			//Encoder.EncodingType.k1X);
	
	public static double constant = 8.6;

	public Drivetrain() {
		//encoderLeft.setMaxPeriod(2);
		//encoderRight.setMaxPeriod(2);
		/*frontRight.enableCurrentLimit(true);
		rearRight.enableCurrentLimit(true);
		frontLeft.enableCurrentLimit(true);
		rearLeft.enableCurrentLimit(true);
		
		frontRight.configContinuousCurrentLimit(35,0); //90 is a placeholder for time in milliseconds
		rearRight.configContinuousCurrentLimit(35,0); 
		frontLeft.configContinuousCurrentLimit(35,0);
		rearLeft.configContinuousCurrentLimit(35,0);*/ 
	}

	// Teleop
	public static void drive() {
		double leftVal = OI.driveJoystick.getRawAxis(1);
		double rightVal = OI.driveJoystick.getRawAxis(5);
		 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
		System.out.println("Gyro: "+ gyro.getAngle());
		frontRight.set(ControlMode.PercentOutput,rightVal);
		rearRight.set(ControlMode.PercentOutput,rightVal);
		frontLeft.set(ControlMode.PercentOutput,-leftVal);
		rearLeft.set(ControlMode.PercentOutput,-leftVal);	
	}
	
	public static void driveSlow() {
		double leftVal = OI.driveJoystick.getRawAxis(1);
		double rightVal = OI.driveJoystick.getRawAxis(5);
		 //System.out.println("leftVal: " + encoderLeft.get() + " rightVal: " + encoderRight.get());
		//System.out.println("Gyro: "+ gyro.getAngle());
		frontRight.set(ControlMode.PercentOutput,rightVal*0.75);
		rearRight.set(ControlMode.PercentOutput,rightVal*0.75);
		frontLeft.set(ControlMode.PercentOutput,-leftVal*0.75);
		rearLeft.set(ControlMode.PercentOutput,-leftVal*0.75);
		//System.out.println("PDP current" + PDP.getCurrent(35));
	}
	
	// auton
	public static void drive(double l, double r) {
		frontRight.set(ControlMode.PercentOutput,-r);
		rearRight.set(ControlMode.PercentOutput,-r);
		frontLeft.set(ControlMode.PercentOutput,l);
		rearLeft.set(ControlMode.PercentOutput,l);
	}

	public void turnDegrees(double degrees) {
		gyro.reset();
		if (degrees > 0) {
			if (gyro.getAngle() != degrees){
				while (gyro.getAngle() < degrees) {
					System.out.println("turning right");
					frontRight.set(ControlMode.PercentOutput,0.25);
					rearRight.set(ControlMode.PercentOutput,0.25);
					frontLeft.set(ControlMode.PercentOutput,0.25);
					rearLeft.set(ControlMode.PercentOutput,0.25);
				/*rightMotors.set(-0.25);
				leftMotors.set(0.25);*/
				}
			}
			else if (gyro.getAngle() == degrees){
				System.out.println("stop bitch");
				frontRight.set(ControlMode.PercentOutput,0.0);
				rearRight.set(ControlMode.PercentOutput,0.0);
				frontLeft.set(ControlMode.PercentOutput,0.0);
				rearLeft.set(ControlMode.PercentOutput,0.0);
			}
		} 
		else{
			if (gyro.getAngle() != degrees){
				while (gyro.getAngle() > degrees) {
					System.out.println("turning left");
					frontRight.set(ControlMode.PercentOutput,-0.25);
					rearRight.set(ControlMode.PercentOutput,-0.25);
					frontLeft.set(ControlMode.PercentOutput,-0.25);
					rearLeft.set(ControlMode.PercentOutput,-0.25);
				}
			}
				/*rightMotors.set(0.25);
				leftMotors.set(0.25);*/
			else if (gyro.getAngle() == degrees){
				System.out.println("stopping bitches left and right");
				frontRight.set(ControlMode.PercentOutput,0.0);
				rearRight.set(ControlMode.PercentOutput,0.0);
				frontLeft.set(ControlMode.PercentOutput,0.0);
				rearLeft.set(ControlMode.PercentOutput,0.0);
			}
		}
	}
		//REMEMBER TO PUT THIS IN 2019
		public static void stopAlign(){
			frontRight.set(ControlMode.PercentOutput,0.0);
			rearRight.set(ControlMode.PercentOutput,0.0);
			frontLeft.set(ControlMode.PercentOutput,0.0);
			rearLeft.set(ControlMode.PercentOutput,0.0);
		}

		public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			setDefaultCommand(new DriveTeleop());
	
		}
	}

	
	

	/*public void autoAlign() { 
		while ((!AutoAlign.done) &&(Robot.midX < 285 || Robot.midX > 315)) { 
			if (Robot.midX < 285) { 
				frontRight.set(ControlMode.PercentOutput,-0.125);
				rearRight.set(ControlMode.PercentOutput,-0.125); 
				frontLeft.set(ControlMode.PercentOutput,-0.125); 
				rearLeft.set(ControlMode.PercentOutput,-0.125);
				System.out.println("<285"); //turns left 
			} else if (Robot.midX > 315) {
				frontRight.set(ControlMode.PercentOutput,0.125); 
				rearRight.set(ControlMode.PercentOutput,0.125); 
				frontLeft.set(ControlMode.PercentOutput,0.125);
				rearLeft.set(ControlMode.PercentOutput,0.125);
				//turns right 
				System.out.println(">315"); } 
			else { 
				break; 
			}
			 System.out.println("autoaligning, mid X = " + Robot.midX); //this will keep running if the midX is not in within 305 and 335 }
		}
	 
	  
	  frontRight.set(ControlMode.PercentOutput,0); rearRight.set(ControlMode.PercentOutput,0); frontLeft.set(ControlMode.PercentOutput,0); rearLeft.set(ControlMode.PercentOutput,0);
	  return; 
	  
	}*/
	

/*
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.OI;
import com.revrobotics.CANEncoder;
// USE THE XBOX CONTROLLER CLASS
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem{
<<<<<<< HEAD
=======

	
public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);
public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);
public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);
public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);

//hall sensors
//public static Counter leftHall = new Counter(1);
//public static Counter rightHall = new Counter(2);
>>>>>>> 4deac8f2fb2291def56de5cfa40c93a1d8b70b5e

	
<<<<<<< HEAD
	public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);

	//hall sensors
	//public static Counter leftHall = new Counter(1);
	//public static Counter rightHall = new Counter(2);

	public static AnalogGyro gyro = new AnalogGyro(0);

	public static CANEncoder frontRightHall = frontRight.getEncoder();
	public static CANEncoder rearRightHall = rearRight.getEncoder();
	public static CANEncoder frontLeftHall = frontLeft.getEncoder();
	public static CANEncoder rearLeftHall = rearLeft.getEncoder();

	public static double radius = 8;
	public static double gear_ratio = 50/12;
	public static double constant = gear_ratio*Math.pow(radius, 2)*Math.PI;


	public Drivetrain(){
		
	}	

	public static void driveTeleop(){

		double leftSpeed = OI.driveJoystick.getRawAxis(1);
		double rightSpeed = OI.driveJoystick.getRawAxis(5);
		frontLeft.set(leftSpeed);
		rearLeft.set(leftSpeed);
		frontRight.set(rightSpeed); 
		rearRight.set(rightSpeed);
	}
	public static void turnDegrees(double degrees){
=======
}	

public static void driveTeleop(){

	double leftSpeed = OI.driveJoystick.getRawAxis(1);
	double rightSpeed = OI.driveJoystick.getRawAxis(5);
	frontLeft.set(leftSpeed);
	rearLeft.set(leftSpeed);
	frontRight.set(rightSpeed); 
	rearRight.set(rightSpeed);
}
//hello8

 while(leftSpeed != 0 || rightSpeed != 0){
	if(leftSpeed != 0)
		System.out.println("Left motor driving");
	if(rightSpeed != 0)
		System.out.println("Right motor driving"); 
	else
		System.out.println("Not moving");
}
		
	public void turnDegrees(double degrees){
>>>>>>> 4deac8f2fb2291def56de5cfa40c93a1d8b70b5e
		gyro.reset();
		if (degrees > 0) {
			while (gyro.getAngle() < degrees) {
				frontRight.set(-0.25);
				rearRight.set(-0.25);
				frontLeft.set(0.25);
				rearLeft.set(0.25);
			}
		} 
		else {
			while (gyro.getAngle() > degrees) {
				frontRight.set(0.25);
				rearRight.set(0.25);
				frontLeft.set(-0.25);
				rearLeft.set(-0.25);
			}
		}
	}

<<<<<<< HEAD
	public static void drive(double l, double r){
		frontLeft.set(l);
		rearLeft.set(l);
		frontRight.set(r); 
		rearRight.set(r);
	} 
	
	public void initDefaultCommand(){
		//setDefaultCommand(new DriveTeleop());
		//System.out.println("teleopping");
	}
=======
public void driveAuton(double l, double r){
frontLeft.set(l);
rearLeft.set(l);
frontRight.set(r); 
rearRight.set(r);
} 

public void initDefaultCommand(){
	//setDefaultCommand(new DriveTeleop());
	//System.out.println("teleopping");
}
>>>>>>> 4deac8f2fb2291def56de5cfa40c93a1d8b70b5e
}
*/
