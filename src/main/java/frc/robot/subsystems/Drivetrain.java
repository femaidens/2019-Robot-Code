
package frc.robot.subsystems;

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
}
