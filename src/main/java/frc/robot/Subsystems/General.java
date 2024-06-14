package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class General extends SubsystemBase {
    public static void general() {
    }

    public static void SelfDestructSequence(){
            initiateSelfDestructSequence();
        }
    private static void initiateSelfDestructSequence() {
        if (Drive.controller.getLeftBumperPressed()==false || Drive.controller.getYButtonPressed() == true){
            System.out.println("Self-destruct sequence initiated!");
            Drive.followLeftMotor.setInverted(true);
            Drive.followRightMotor.setInverted(true);
            Drive.leftMotor.set(10000);
            Drive.rightMotor.set(10000);
            Shooter.primer.set(10000);
            Shooter.launcher.set(10000);
            // Newmatics.Pshhhhhhh.enableAnalog(10000, 10000);
        }
        else {
            System.out.println("Self Destruct Sequence Aborted");
        }
    }
}
