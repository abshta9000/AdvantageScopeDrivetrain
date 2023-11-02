// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive extends SubsystemBase {
  private CANSparkMax  frontright;
  private CANSparkMax  frontleft;
  private CANSparkMax  backright;
  private CANSparkMax  backleft;
  private DifferentialDrive difDrive;

  /** Creates a new Drive. */
  public Drive() {

    frontright = new CANSparkMax(DriveConstants.frontrightID,MotorType.kBrushless);
    frontleft = new CANSparkMax(DriveConstants.frontleftID,MotorType.kBrushless);
    backright = new CANSparkMax(DriveConstants.backrightID,MotorType.kBrushless);
    backleft = new CANSparkMax(DriveConstants.backleftID,MotorType.kBrushless);
    
    backright.follow(frontright);
    backleft.follow(frontleft);

    frontleft.setInverted(true);
    backleft.setInverted(true);

    difDrive = new DifferentialDrive(frontleft, frontright);
  }

  public void arcadeDrive(double speed, double rotation){
    difDrive.arcadeDrive(-speed, -rotation);
    //System.out.println("drive arcade " + speed);
    //System.out.println(frontleft.get());
    //difDrive.feed();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
