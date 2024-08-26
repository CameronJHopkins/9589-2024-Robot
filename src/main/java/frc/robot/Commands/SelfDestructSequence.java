package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.General;

public class SelfDestructSequence extends Command {

    private General general;
    
    public SelfDestructSequence(General general) {

        this.general = general;
        addRequirements(this.general); 

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {

        General.SelfDestructSequence();

    }

    @Override
    public boolean isFinished() {

        return false;
	
    }

    @Override
    public void end(boolean interrupted) {

        System.out.println("Self-Destruct Sequence Cancelled");

    }
}
