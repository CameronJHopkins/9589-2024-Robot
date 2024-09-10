package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Newmatics extends SubsystemBase {

    static Compressor Pshhhhhhh = new Compressor(PneumaticsModuleType.REVPH);
    
    public void Arise() {

        Pshhhhhhh.enableAnalog(70, 120);
	
    }
    
    public void nopshhh(){

        Pshhhhhhh.disable();

    }
}
