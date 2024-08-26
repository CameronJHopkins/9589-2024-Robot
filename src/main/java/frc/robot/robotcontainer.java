package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Commands.*;
import frc.robot.Contants.AutoConstants;
import frc.robot.Contants.ControllerConstants;
import frc.robot.Subsystems.*;

public class robotcontainer {
	
  private final CommandXboxController controller = new CommandXboxController(0);
  private final Trigger bigoneontheleft = controller.leftTrigger(ControllerConstants.CallumMFKaiser);
  private final Trigger bigoneontheright = controller.rightTrigger(ControllerConstants.CallumMFKaiser);
  private final Trigger abutton = controller.a();
  private final Trigger bbutton = controller.b();
  private final Trigger xbutton = controller.x();
  private final Trigger ybutton = controller.y();
  private final Trigger Up = controller.povUp();
  private final Trigger Down = controller.povDown();
  private final Trigger Left = controller.povLeft();
  private final Trigger Right = controller.povRight();
  private final Trigger smalloneontheleft = controller.leftBumper();
  private final Trigger smalloneontheright = controller.rightBumper();

  private Shooter shooterSubsystem = new Shooter();
  private Drive driveSubsystem = new Drive();
  private General generalSubsystem = new General();
  private Newmatics newmaticsSubsystem = new Newmatics();

  public robotcontainer(Shooter shooterSubsystem, Newmatics newmaticsSubsystem, Drive driveSubsystem, General generalSubsystem) {

    this.shooterSubsystem = shooterSubsystem;
    this.driveSubsystem = driveSubsystem;
    this.generalSubsystem = generalSubsystem;
    this.newmaticsSubsystem = newmaticsSubsystem;
    configurebindings();
    autopicker.AutoModeSelector(autopicker.getAutoChooser(), this, shooterSubsystem, driveSubsystem, generalSubsystem);

  }


  private void configurebindings() {

      bigoneontheright.onTrue(new armtorpedoes(shooterSubsystem).withTimeout(AutoConstants.PrimerTimer).andThen(new fire(shooterSubsystem, 0.99).withTimeout(AutoConstants.FireTimer).andThen(new arret(shooterSubsystem))));
      bigoneontheleft.onTrue(new Intake(shooterSubsystem).withTimeout(AutoConstants.TakerTimer).andThen(new arret(shooterSubsystem)));
      abutton.whileTrue(new TurboBoost(driveSubsystem).andThen(new brake(driveSubsystem, shooterSubsystem)));
      bbutton.whileTrue(new TurboTurn(driveSubsystem).andThen(new brake(driveSubsystem, shooterSubsystem)));
      smalloneontheleft.onTrue(new brake(driveSubsystem, shooterSubsystem));
      smalloneontheright.onTrue(new armphasers(shooterSubsystem).withTimeout(AutoConstants.PrimerTimer).andThen(new fire(shooterSubsystem, 0.4).withTimeout(AutoConstants.FireTimer)));
      xbutton.whileFalse(new nopshhh(newmaticsSubsystem));
      xbutton.whileTrue(new Arise(newmaticsSubsystem).andThen(new nopshhh(newmaticsSubsystem)));
      Up.onTrue(new autopilot(driveSubsystem).withTimeout(AutoConstants.DriverTimer).andThen(new brake(driveSubsystem, shooterSubsystem)));
      Down.onTrue(new autopilotback(driveSubsystem).withTimeout(AutoConstants.DriverTimer).andThen(new brake(driveSubsystem, shooterSubsystem)));
      Left.onTrue(new autopilotleft(driveSubsystem).withTimeout(AutoConstants.TurnLeftTime).andThen(new brake(driveSubsystem, shooterSubsystem)));
      Right.onTrue(new autopilotright(driveSubsystem).withTimeout(AutoConstants.TurnRightTime).andThen(new brake(driveSubsystem, shooterSubsystem)));
      smalloneontheleft.onTrue(new arret(shooterSubsystem));
      ybutton.whileTrue(new warning().withTimeout(30).alongWith(new brake(driveSubsystem, shooterSubsystem).withTimeout(30).beforeStarting(new SelfDestructSequence(generalSubsystem))));
  
  }
  
  public static SequentialCommandGroup getAutonomousCommand() {

    return autopicker.getAutoChooser().getSelected();
    
  }

}
