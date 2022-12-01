// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {

  CANSparkMax leftMotor1 = new CANSparkMax(Constants.DriveTrainConstants.CANID1, 
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(Constants.DriveTrainConstants.CANID2, 
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor3 = new CANSparkMax(Constants.DriveTrainConstants.CANID3, 
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor1 = new CANSparkMax(Constants.DriveTrainConstants.CANID4, 
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(Constants.DriveTrainConstants.CANID5, 
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor3 = new CANSparkMax(Constants.DriveTrainConstants.CANID6, 
      CANSparkMaxLowLevel.MotorType.kBrushless);

  RelativeEncoder leftEncoder = leftMotor2.getEncoder();
  RelativeEncoder rightEncoder = rightMotor2.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftMotor1, leftMotor2, leftMotor3);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightMotor1, rightMotor2, rightMotor3);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    leftMotor1.restoreFactoryDefaults();
    leftMotor2.restoreFactoryDefaults();
    leftMotor3.restoreFactoryDefaults();
    rightMotor1.restoreFactoryDefaults();
    rightMotor2.restoreFactoryDefaults();
    rightMotor3.restoreFactoryDefaults();

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    leftMotor3.follow(leftMotor1);
    rightMotor3.follow(rightMotor1);

    rightControllerGroup.setInverted(false);
    leftControllerGroup.setInverted(true);
  }
   
  public void driveWithJoysticks(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
