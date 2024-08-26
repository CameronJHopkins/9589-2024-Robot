package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.util.sendable.SendableRegistry;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Contants.DriveConstants;

public class Drive extends SubsystemBase{

    static WPI_TalonSRX leftMotor = new WPI_TalonSRX(DriveConstants.leftmotor);
    static WPI_TalonSRX rightMotor = new WPI_TalonSRX(DriveConstants.rightmotor);
    static WPI_TalonSRX followLeftMotor = new WPI_TalonSRX(DriveConstants.leftmotorfollow);
    static WPI_TalonSRX followRightMotor = new WPI_TalonSRX(DriveConstants.rightmotorfollow);
    static DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotor::set, rightMotor::set);
    static XboxController controller = new XboxController(0);
    
    public static void prepareDrive(){

        leftMotor.setInverted(true);
        followLeftMotor.follow(leftMotor);
        followRightMotor.follow(rightMotor);

    }

    public static void differentialStart(){

        SendableRegistry.addChild(m_robotDrive, leftMotor);
        SendableRegistry.addChild(m_robotDrive, rightMotor);
    
    }

    public static void startDrive(){

        m_robotDrive.arcadeDrive(controller.getRawAxis(1), controller.getRawAxis(4));

    }

    public void brake(){
        
        leftMotor.set(0);
        rightMotor.set(0);
        CommandScheduler.getInstance().cancelAll();
    
    }

    public void autopilot(){

        leftMotor.set(-0.2);
        rightMotor.set(-0.2);

    }

    public void autopilotback(){

        leftMotor.set(0.2);
        rightMotor.set(0.2);

    }

    public void autopilotleft(){

        leftMotor.set(0.3);
        rightMotor.set(-0.3);

    }
        
    public void autopilotright(){

        leftMotor.set(-0.3);
        rightMotor.set(0.3);

    }

    public void TurboBoost(){

        leftMotor.set(-10);
        rightMotor.set(-10);

    }

    public void TurboTurn(){

        leftMotor.set(-10);
        rightMotor.set(10);

    }

}
