// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.drive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;
import frc.robot.subsystems.drive.DriveIO.DriveIOInputs;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveIOSparkMax implements DriveIO{
  private final CANSparkMax  frontright;
  private final CANSparkMax  frontleft;
  private final CANSparkMax  backright;
  private final CANSparkMax  backleft;
  private final RelativeEncoder rightEncoder;
  private final RelativeEncoder leftEncoder;

  /** Creates a new Drive. */
  public DriveIOSparkMax() {

    frontright = new CANSparkMax(DriveConstants.frontrightID,MotorType.kBrushless);
    frontleft = new CANSparkMax(DriveConstants.frontleftID,MotorType.kBrushless);
    backright = new CANSparkMax(DriveConstants.backrightID,MotorType.kBrushless);
    backleft = new CANSparkMax(DriveConstants.backleftID,MotorType.kBrushless);
    
    rightEncoder = frontright.getEncoder();
    leftEncoder = frontleft.getEncoder();

    frontright.restoreFactoryDefaults();
    frontleft.restoreFactoryDefaults();
    backright.restoreFactoryDefaults();
    backleft.restoreFactoryDefaults();

    frontleft.setInverted(true);

    backright.follow(frontright);
    backleft.follow(frontleft);

    frontright.burnFlash();
    frontleft.burnFlash();
    backright.burnFlash();
    backleft.burnFlash();
  }

  @Override
  public void updateInputs(DriveIOInputs inputs){
    inputs.rightPos = rightEncoder.getPosition();
    inputs.leftPos = leftEncoder.getPosition();
    inputs.appliedvoltsAvg = 0.0;
  }

  @Override
  public void setVoltage(double left, double right){
    frontleft.setVoltage(left);
    frontright.setVoltage(right);
  }

}
