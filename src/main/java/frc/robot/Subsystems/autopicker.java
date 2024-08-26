package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.robotcontainer;
import frc.robot.Autos.blitzgrieg;
import frc.robot.Autos.drivestraight;
import frc.robot.Autos.fireatwill;
import frc.robot.Autos.hitandrun;
import frc.robot.Autos.nicht;

public class autopicker {
	
    static Drive drivesubsystem = new Drive();
    static Shooter shootersubsystem = new Shooter();
    static Newmatics newmaticssubsystem = new Newmatics();
    static General generalsubsystem = new General();

    private static SendableChooser<SequentialCommandGroup> Autopicker = new SendableChooser<>();
    
    static robotcontainer Container = new robotcontainer(shootersubsystem, newmaticssubsystem, drivesubsystem, generalsubsystem);
           
    public static void Shuffleboard(Newmatics newmatics){

        ShuffleboardTab mainTab = Shuffleboard.getTab("Main");
  
        mainTab.add("AutoMode", autopicker.getAutoChooser()).withSize(2, 1).withPosition(0, 0);
        // mainTab.addDouble( "Pressure",Newmatics.Pshhhhhhh::getPressure).withSize(1,1).withPosition(0,1);
        // mainTab.addDouble("Current", Newmatics.Pshhhhhhh::getCurrent).withSize(1,1).withPosition(1, 1);
        // mainTab.addBoolean("Active", Newmatics.Pshhhhhhh::isEnabled).withSize(1, 1).withPosition(2, 1);
        // mainTab.addBoolean("Pressure Has Exceeded 8.3 Bar", Newmatics.Pshhhhhhh::getPressureSwitchValue).withSize(2, 1).withPosition(2, 0);
        mainTab.addCamera("Skooble POV", "USB Camera 0", "null").withSize(4, 4).withPosition(4, 0);
	
    }


    public static void AutoModeSelector(SendableChooser<SequentialCommandGroup> autoChooser, robotcontainer Container, Shooter shootersubsystem, Drive drivesubsystem, General generalSubsystem) {
           
        Autopicker.setDefaultOption("picktheauto", nicht(Container, drivesubsystem));
        Autopicker.addOption("Go straight", drivestraight(Container, drivesubsystem));
        Autopicker.addOption("Hit and run", hitandrun(drivesubsystem, shootersubsystem));
        Autopicker.addOption("Shoot", fireatwill(Container, shootersubsystem));
        Autopicker.addOption("Drive all the way to the other side of the field and explode", Blitzgrieg(drivesubsystem, generalSubsystem));

    }
    

    public static SendableChooser<SequentialCommandGroup> getAutoChooser( ) {

        return Autopicker;

    }

    private static SequentialCommandGroup nicht(robotcontainer Container, Drive drivesubsystem) {

        return new nicht(Container, drivesubsystem, shootersubsystem);

    }

    private static SequentialCommandGroup drivestraight(robotcontainer Container, Drive driveSubsystem) {

        return new drivestraight(Container, driveSubsystem, shootersubsystem);

    }

    private static SequentialCommandGroup fireatwill(robotcontainer Container, Shooter shootersubsystem) {

        return new fireatwill(Container, shootersubsystem);

    }

    private static SequentialCommandGroup hitandrun(Drive drivesubsystem, Shooter shootersubsystem) {

        return new hitandrun(drivesubsystem, shootersubsystem);

    }

    private static SequentialCommandGroup Blitzgrieg(Drive drivesubsystem, General generalsubsystem) {

        return new blitzgrieg(Container, drivesubsystem, generalsubsystem);
	
    }
}
