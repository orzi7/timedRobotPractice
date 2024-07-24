// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.GlobalConstants.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private TalonSRX firstMotorRight;
  private TalonSRX secondMotorRight;

  private TalonSRX firstMotorLeft;
  private TalonSRX secondMotorLeft;

  private DigitalInput rightBeamBreak;
  private DigitalInput leftBeamBreak;

  private boolean leftBeamBreakPosition;
  private boolean rightBeamBreakPosition;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    firstMotorRight = new TalonSRX(MotorConstants.firstMotorRightPort);
    secondMotorRight = new TalonSRX(MotorConstants.secondMotorRightPort);

    firstMotorRight.setInverted(true);
    secondMotorRight.setInverted(true);
    
    firstMotorRight.follow(secondMotorRight);

    firstMotorRight.setNeutralMode(NeutralMode.Brake);
    secondMotorRight.setNeutralMode(NeutralMode.Brake);


    firstMotorLeft = new TalonSRX(MotorConstants.firstMotorLeftPort);
    secondMotorLeft = new TalonSRX(MotorConstants.secondMotorLeftPort);

    firstMotorLeft.follow(secondMotorLeft);

    firstMotorLeft.setNeutralMode(NeutralMode.Brake);
    secondMotorLeft.setNeutralMode(NeutralMode.Brake);

    rightBeamBreak = new DigitalInput(BeamBreakConstants.rightBeamBreakChannel);
    leftBeamBreak = new DigitalInput(BeamBreakConstants.leftBeamBreakChannel);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {

  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {

  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    rightBeamBreakPosition = rightBeamBreak.get();
    leftBeamBreakPosition = leftBeamBreak.get();
    
    if (rightBeamBreakPosition) {
      secondMotorRight.set(ControlMode.PercentOutput, 0);
    }
    else {
      secondMotorRight.set(ControlMode.PercentOutput, MotorConstants.motorPower);
    }

    if (leftBeamBreakPosition) {
      secondMotorLeft.set(ControlMode.PercentOutput, 0);
    }
    else {
      secondMotorLeft.set(ControlMode.PercentOutput, MotorConstants.motorPower);
    }
    SmartDashboard.putBoolean("right Beam Break position", rightBeamBreakPosition);
    SmartDashboard.putBoolean("left Beam Break position", leftBeamBreakPosition);
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
