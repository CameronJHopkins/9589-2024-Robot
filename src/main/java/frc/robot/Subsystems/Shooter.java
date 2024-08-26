package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Contants.ShooterConstants;

public class Shooter extends SubsystemBase {

    static CANSparkMax primer = new CANSparkMax(ShooterConstants.Primer, MotorType.kBrushless);
    static CANSparkMax launcher = new CANSparkMax(ShooterConstants.Launcher, MotorType.kBrushless);

    public static void AShooter() {

        primer.setInverted(false);
        launcher.setInverted(false);
	
    }
           
    public void fire(double speed){            

        launcher.set(speed);
        primer.set(speed);
    }
           
    public void armtorpedoes(){
           
        launcher.set(0);
        primer.set(1);       
    }
           
    public void Intake(){
           
        launcher.set(-0.4);
        primer.set(-0.4);
    }
     
    public void armphasers() {
           
        primer.set(0.4);
        launcher.set(0);
           
    }
           
    public void arret(){
           
       launcher.set(0);
       primer.set(0);
           
    }
        
}


