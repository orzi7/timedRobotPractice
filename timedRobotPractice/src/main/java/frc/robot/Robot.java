package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.GlobalConstants.*;


public class Robot extends TimedRobot {

  private double leftSidePower;
  private double rightSidePower;

  private Joystick joystick;

  private TalonSRX firstMotorRight;
  private TalonSRX secondMotorRight;

  private TalonSRX firstMotorLeft;
  private TalonSRX secondMotorLeft;

  @Override
  public void robotInit() {
    joystick = new Joystick(JoystickConstants.joystickPort);

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
  }


  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {
  }


  @Override
  public void autonomousPeriodic() {
  }


  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {    
    rightSidePower = joystick.getRawAxis(JoystickConstants.rightYAxis);
    secondMotorRight.set(ControlMode.PercentOutput, rightSidePower);

    leftSidePower = joystick.getRawAxis(JoystickConstants.leftYAxis);
    secondMotorLeft.set(ControlMode.PercentOutput, leftSidePower);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
