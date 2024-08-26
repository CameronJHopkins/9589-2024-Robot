package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Drive;

public class TurboTurn extends Command {

    private Drive drive;
    
    public TurboTurn(Drive drive) {

       this.drive = drive;
       addRequirements();

    }

    @Override
    public void initialize() {

     }

    @Override
    public void execute(){
	    
        drive.TurboTurn();
	
    }
    
    @Override
    public boolean isFinished() {
	    
        return false;

    }

    @Override
    public void end(boolean interrupted) {
	    
        drive.brake();

    }
}
