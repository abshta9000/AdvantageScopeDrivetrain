// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveCommand extends CommandBase {
  
  private DoubleSupplier speed;
  private DoubleSupplier rotation;
  private Drive drive;

  /** Creates a new DriveCommand. */
  public DriveCommand(DoubleSupplier speed, DoubleSupplier rotation, Drive drive) {
    this.speed = speed;
    this.rotation = rotation;
    this.drive = drive;
    
    addRequirements(drive);
  }
  /**
  public DriveCommand(double leftY, double rightX, Drive drivebaseSubsystem) {
  }
  */
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    //System.out.println("arcade");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
