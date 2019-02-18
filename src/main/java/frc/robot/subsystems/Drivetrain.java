
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.OI;
// USE THE XBOX CONTROLLER CLASS
import frc.robot.RobotMap;

public class Drivetrain extends Subsystem{

	public static CANSparkMax centerLeft = new CANSparkMax(RobotMap.centerLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);	
	public static CANSparkMax frontLeft = new CANSparkMax(RobotMap.frontLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax frontRight = new CANSparkMax(RobotMap.frontRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax centerRight = new CANSparkMax(RobotMap.centerRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax rearRight = new CANSparkMax(RobotMap.rearRightPort, CANSparkMaxLowLevel.MotorType.kBrushless);
	public static CANSparkMax rearLeft = new CANSparkMax(RobotMap.rearLeftPort, CANSparkMaxLowLevel.MotorType.kBrushless);

	public static CANEncoder rearRightHall = new CANEncoder(rearRight);
	public static CANEncoder rearLeftHall = new CANEncoder(rearLeft);

	public static AnalogGyro gyro = new AnalogGyro(RobotMap.gyroPort);
	/*
	//hall sensors
	public static Counter leftHall = new Counter(1);
	public static Counter rightHall = new Counter(2);

	public static AnalogGyro gyro = new AnalogGyro(0);
	*/

	//public static CANEncoder leftHall = new CANEncoder(frontLeft);
	//public static CANEncoder rightHall = new CANEncoder(frontRight);
	public Drivetrain(){
	}	

	public static void driveTeleop(){
		//System.out.println("working");
		double leftSpeed = OI.driveJoystick.getRawAxis(1);
		double rightSpeed = - OI.driveJoystick.getRawAxis(5);
		//double rightSpeed = 1;
		centerLeft.set(leftSpeed);
		frontLeft.set(leftSpeed);
		frontRight.set(rightSpeed);
		centerRight.set(rightSpeed);
		rearLeft.set(leftSpeed);
		rearRight.set(rightSpeed);
	}

	public void driveAuton(double l, double r){
		frontLeft.set(l);
		rearLeft.set(l);
		centerLeft.set(l);
		frontRight.set(r); 
		rearRight.set(r);
		centerRight.set(r);
	}

	public void turnDegrees(double degrees){
		gyro.reset();
		if (degrees > 0) {
			while (gyro.getAngle() < degrees) {
				driveAuton(0.25, -0.25);
			}
		} 
		else {
			while (gyro.getAngle() > degrees) {
				driveAuton(-0.25, 0.25);
			}
		}
	}

	public void initDefaultCommand(){
		setDefaultCommand(new DriveTeleop());
		System.out.println("teleopping");
	}
}
