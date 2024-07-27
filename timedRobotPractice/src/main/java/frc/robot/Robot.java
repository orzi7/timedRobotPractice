package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.GlobalConstants.*;


public class Robot extends TimedRobot {

  private double towardSpeed;
  private double turnSpeed;

  private Joystick driverJoystick;

  private TalonSRX firstMotorRight;
  private TalonSRX secondMotorRight;

  private TalonSRX firstMotorLeft;
  private TalonSRX secondMotorLeft;

  @Override
  public void robotInit() {
    driverJoystick = new Joystick(JoystickConstants.joystickPort);

    firstMotorRight = new TalonSRX(MotorConstants.firstMotorRightPort);
    secondMotorRight = new TalonSRX(MotorConstants.secondMotorRightPort);

    firstMotorRight.follow(secondMotorRight);
    
    firstMotorRight.setNeutralMode(NeutralMode.Brake);
    secondMotorRight.setNeutralMode(NeutralMode.Brake);
    
    
    firstMotorLeft = new TalonSRX(MotorConstants.firstMotorLeftPort);
    secondMotorLeft = new TalonSRX(MotorConstants.secondMotorLeftPort);

    firstMotorLeft.setInverted(true);
    secondMotorLeft.setInverted(true);

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

    towardSpeed = driverJoystick.getRawAxis(JoystickConstants.YAxis);    
    turnSpeed = driverJoystick.getRawAxis(JoystickConstants.XAxis);


    if (Math.abs(turnSpeed) > 0.05 || Math.abs(towardSpeed) > 0.05) {
      if (Math.abs(turnSpeed) > 0.05) {
        secondMotorRight.set(ControlMode.PercentOutput, turnSpeed);
        secondMotorLeft.set(ControlMode.PercentOutput, -turnSpeed);
      }
      else if (Math.abs(towardSpeed) > 0.05) {
        secondMotorRight.set(ControlMode.PercentOutput, towardSpeed);
        secondMotorLeft.set(ControlMode.PercentOutput, towardSpeed);
      }
      else {
        secondMotorRight.set(ControlMode.PercentOutput, 0);
        secondMotorLeft.set(ControlMode.PercentOutput, 0);
      }
    }
    else if (driverJoystick.getRawButton(JoystickConstants.RTButton) || driverJoystick.getRawButton(JoystickConstants.LTButton)) {
      if (driverJoystick.getRawButton(JoystickConstants.RTButton)) {
        secondMotorRight.set(ControlMode.PercentOutput, towardSpeed);
      }
      else if (driverJoystick.getRawButton(JoystickConstants.LTButton)) {
        secondMotorLeft.set(ControlMode.PercentOutput, towardSpeed);
      }
      else {
        secondMotorRight.set(ControlMode.PercentOutput, 0);
        secondMotorLeft.set(ControlMode.PercentOutput, 0);
      }
    }
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
