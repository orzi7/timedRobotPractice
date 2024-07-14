package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;


public class Robot extends TimedRobot {

  private double towardSpeed;
  private double turnSpeed;

  private Joystick joystick;

  private TalonSRX firstMotorRight;
  private TalonSRX secondMotorRight;

  private TalonSRX firstMotorLeft;
  private TalonSRX secondMotorLeft;

  @Override
  public void robotInit() {
    joystick = new Joystick(0);

    firstMotorRight = new TalonSRX(3);
    secondMotorRight = new TalonSRX(4);

    secondMotorRight.setInverted(true);    
    firstMotorRight.setInverted(true);


    firstMotorRight.follow(secondMotorRight);

    firstMotorLeft = new TalonSRX(1);
    secondMotorLeft = new TalonSRX(2);

    firstMotorLeft.follow(secondMotorLeft);
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

    towardSpeed = joystick.getRawAxis(3);    
    turnSpeed = joystick.getRawAxis(2);

    if (Math.abs(turnSpeed) > 0.05) {
      secondMotorRight.set(ControlMode.PercentOutput, -turnSpeed);
      secondMotorLeft.set(ControlMode.PercentOutput, turnSpeed);
    }

    else if (Math.abs(towardSpeed) > 0.05) {
      secondMotorRight.set(ControlMode.PercentOutput, towardSpeed);
      secondMotorLeft.set(ControlMode.PercentOutput, towardSpeed);
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
