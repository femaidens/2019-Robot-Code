/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



/**
 * Add your docs here.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public Limelight(){
  }
  
  // makes a cell to store whether target has been obtained 
  NetworkTableEntry tv = table.getEntry("tv");
  
  // makes a cell for distance from “target�?
  NetworkTableEntry tx = table.getEntry("tx");

  // makes a cell for skew
  NetworkTableEntry ts = table.getEntry("ts");

  //makes a cell doe percent image
  //NetworkTableEntry ta = table.getEntry("ta");
  
  public boolean objectSighted(){
    if (tv.getDouble(0.0) == 1){
      return true;
  }
  return false;
  }
  
  public double getTx(){
    if(objectSighted())
      return tx.getDouble(0.0);
    else
      return 0;
  }

  public double getTs(){
    if(objectSighted())
      return ts.getDouble(0.0);
    else
      return 0;
  }
  
  /*public double getDistance(){
    double area = ta.getDouble(0.0);
    // some random calculations to get distance ratio
    return distance;
  }  */

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
