// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DrivetrainSubsystem extends SubsystemBase {


  VictorSP leftMotor1 = new VictorSP(0);
  VictorSP leftMotor2 = new VictorSP(0);
  VictorSP rightMotor1 = new VictorSP(0);
  VictorSP rightMotor2 = new VictorSP(0);

  //RelativeEncoder leftEncoder = leftMotor1.getEncoder();
  //RelativeEncoder rightEncoder = rightMotor1.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftMotor1, leftMotor2);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightMotor1, rightMotor2);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup);

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    //leftEncoder.setPosition(0);
    //rightEncoder.setPosition(0);


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
