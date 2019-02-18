
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

//public static CANSparkMax centerLeft = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);	
///public static CANSparkMax frontLeft = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);
//public static CANSparkMax frontRight = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);
//public static CANSparkMax centerRight = new CANSparkMax(13, CANSparkMaxLowLevel.MotorType.kBrushless);
public static CANSparkMax rearRight = new CANSparkMax(12, CANSparkMaxLowLevel.MotorType.kBrushless);

public static CANSparkMax rearLeft = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);

public static CANEncoder rearRightHall = new CANEncoder(rearRight);
public static CANEncoder rearLeftHall = new CANEncoder(rearLeft);
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
	//double leftSpeed = OI.driveJoystick.getRawAxis(1)*0.5;
	double rightSpeed = - OI.driveJoystick.getRawAxis(5);
	//double rightSpeed = 1;
	//centerLeft.set(rightSpeed);
	//frontLeft.set(rightSpeed);
	//frontRight.set(rightSpeed);
	//centerRight.set(rightSpeed);
	rearLeft.set(rightSpeed);
	rearRight.set(rightSpeed);
	//System.out.println()
	//rearLeft.follow(centerRight);
	//rearRight.follow(centerRight);
	//frontLeft.set(rightSpeed);
	//frontRight.follow(frontLeft);
	//rearLeft.follow(frontLeft);
	//rearRight.follow(frontLeft);
	//centerLeft.follow(frontLeft);
	//centerRight.follow(frontLeft);
	//frontRight.set(-rightSpeed);
//rearLeft.set(leftSpeed);
//frontRight.set(rightSpeed); 
//rearRight.set(rightSpeed);
}
/*

while(leftSpeed != 0 || rightSpeed != 0){
	if(leftSpeed != 0)
		System.out.println("Left motor driving");
	else if(rightSpeed != 0)
		System.out.println("Right motor driving");
	else
		System.out.println("Not moving");
}


}

	public void turnDegrees(double degrees){
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
*/

public void driveAuton(double l, double r){
	//frontLeft.set(l);
	//rearLeft.set(l);
	//frontRight.set(r); 
	//rearRight.set(r);
} 
public void initDefaultCommand(){
	setDefaultCommand(new DriveTeleop());
	System.out.println("teleopping");
}
}
