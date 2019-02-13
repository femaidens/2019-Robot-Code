
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

	
public static CANSparkMax frontLeft = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
//public static CANSparkMax frontRight = new CANSparkMax(12, CANSparkMaxLowLevel.MotorType.kBrushless);

//public static CANSparkMax rearLeft = new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless);
//public static CANSparkMax rearRight = new CANSparkMax(13, CANSparkMaxLowLevel.MotorType.kBrushless);
/*
//hall sensors
public static Counter leftHall = new Counter(1);
public static Counter rightHall = new Counter(2);

public static AnalogGyro gyro = new AnalogGyro(0);
*/

public static CANEncoder leftHall = new CANEncoder(frontLeft);
//public static CANEncoder rightHall = new CANEncoder(frontRight);
public Drivetrain(){
}	

public static void driveTeleop(){

	//double leftSpeed = OI.driveJoystick.getRawAxis(1)*0.5;
	double rightSpeed = - OI.driveJoystick.getRawAxis(5);
	frontLeft.set(rightSpeed);
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
	frontLeft.set(l);
	//rearLeft.set(l);
	//frontRight.set(r); 
	//rearRight.set(r);
} 
public void initDefaultCommand(){
	setDefaultCommand(new DriveTeleop());
	//System.out.println("teleopping");
}
}
