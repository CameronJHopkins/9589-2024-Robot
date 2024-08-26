package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;

public class warning extends Command{
	
    private int count = 30;

    public warning() {

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
	    
        return count <= 0; 

    }

    @Override
    public void end(boolean interrupted) {

        System.out.println("Self Destruct Sequence Has Been Aborted");

    }
}
