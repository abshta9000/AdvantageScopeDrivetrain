// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;

import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.inputs.*;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.drive.DriveIO.DriveIOInputs;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */

  //copied from example, not sure whether is needed just in case
  private final DriveIO io;
  private final DriveIOInputs inputs = new DriveIOInputs();

  public Drive(DriveIO ioP) {this.io = ioP;}

  @Override
  public void periodic() {
    io.updateInputs(inputs);
    Logger.getInstance().processInputs("Drive", (LoggableInputs) inputs);
  }

  
  public void arcadeCommand(double left, double right){
    //im prettry sure square inputs just makes teh controller more sensitive to low inputs, turning off for now
    var speeds = DifferentialDrive.arcadeDriveIK(left, right, false);
    System.out.println(left);
    io.setVoltage(speeds.left * DriveConstants.rRotRateTOVolt, speeds.right * DriveConstants.rRotRateTOVolt);
  }
}
