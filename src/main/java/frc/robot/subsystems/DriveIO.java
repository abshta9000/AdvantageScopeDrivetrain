// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public interface DriveIO {
  /** Creates a new DriveIO. */
  public static class DriveIOInputs implements LoggableInputs {

    public double tempAvg = 0.0;
    public double appliedvoltsAvg = 0.0;
    
    public double rightPos = 0.0;
    public double leftPos = 0.0;

    @Override
    public void toLog(LogTable table) {
      table.put("Average Drive Temperature", tempAvg);
      table.put("Average Applied Drive Voltage", appliedvoltsAvg);
      table.put("Right Position", rightPos);
      table.put("Left Position", leftPos);
      
    }

    @Override
    public void fromLog(LogTable table) {
      tempAvg = table.getDouble("Average Drive Temperature", tempAvg);
      appliedvoltsAvg = table.getDouble("Average Applied Drive Voltage", appliedvoltsAvg);
      rightPos = table.getDouble("Right Position", rightPos);
      leftPos = table.getDouble("Left Position", leftPos);
      
    }
  }

  public default void updateInputs(DriveIOInputs inputs) {}

  public default void setTemp(double tempAvg){}

  public default void setVolts(double appliedvoltsAvg){}

  public default void setPos(double rightPos, double leftPos){}
}
