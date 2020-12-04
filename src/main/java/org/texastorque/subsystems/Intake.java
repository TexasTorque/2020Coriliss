package org.texastorque.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import org.texastorque.constants.Input;
import org.texastorque.torquelib.util.GenericController;

public class Intake {
    private static volatile Intake instance;
    GenericController controller = new GenericController(0, 0.1);
    PWMSparkMax IN = new PWMSparkMax(Input.INTAKE);
    PWMSparkMax e_r = new PWMSparkMax(Input.RIGHT_ELEVATOR);
    PWMSparkMax e_l = new PWMSparkMax(Input.LEFT_ELEVATOR);
    
    public void run() {
        if(controller.getLeftTrigger()){
            IN.set(.5);
            e_r.set(.3);
            e_l.set(.3);        
        } 
    }

    public static Intake getInstance(){ // should be abstracted
        if (instance == null){
            synchronized(Intake.class){
                if (instance == null)
                    instance = new Intake();
            }
        }
        return instance;
    }
}