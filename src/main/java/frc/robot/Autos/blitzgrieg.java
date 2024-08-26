package frc.robot.Autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.robotcontainer;
import frc.robot.Commands.SelfDestructSequence;
import frc.robot.Commands.autopilot;
import frc.robot.Subsystems.Drive;
import frc.robot.Subsystems.General;

public class blitzgrieg extends SequentialCommandGroup {
    
    private final Drive driveSubsystem;
    private final General generalSubsystem;
    public blitzgrieg (robotcontainer robot, Drive driveSubsystem, General generalSubsystem){
   
        this.driveSubsystem = driveSubsystem;
        this.generalSubsystem = generalSubsystem;
     
     	System.out.println("Warning - Self Destruct Imminent.  Clear a blast radius of at least 30 Metres.");

        addCommands(new autopilot(driveSubsystem).withTimeout(10).andThen(new SelfDestructSequence(generalSubsystem)));
    }
}
