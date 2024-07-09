package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
    joystick = new Joystick(0);

    firstMotorRight = new TalonSRX(1);
    secondMotorRight = new TalonSRX(2);

    firstMotorRight.follow(secondMotorRight);

    firstMotorLeft = new TalonSRX(3);
    secondMotorLeft = new TalonSRX(4);

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
    if (joystick.getRawAxis(3) > 0.05) {
      rightSidePower = joystick.getRawAxis(1);
      secondMotorRight.set(ControlMode.PercentOutput, rightSidePower);
    }

    if (joystick.getRawAxis(4) > 0.05) {
      leftSidePower = joystick.getRawAxis(2);
      secondMotorLeft.set(ControlMode.PercentOutput, -leftSidePower);
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
