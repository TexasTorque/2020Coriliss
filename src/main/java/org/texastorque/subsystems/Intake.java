package org.texastorque.subsystems;

import edu.wpi.first.wpilibj.PWMSparkMax;
import org.texastorque.constants.Input;
import org.texastorque.torquelib.util.GenericController;

public class Intake {
    private static volatile Intake instance;
    GenericController controller = new GenericController(1, 0.1);
    PWMSparkMax IN = new PWMSparkMax(Input.INTAKE);
    PWMSparkMax e_r = new PWMSparkMax(Input.RIGHT_ELEVATOR);
    PWMSparkMax e_l = new PWMSparkMax(Input.LEFT_ELEVATOR);
    
    public void run() {
        if(controller.getLeftTrigger()){
            IN.set(-.5);
        } else {
            IN.set(0);
        }
        
        if(controller.getLeftBump() || controller.getRightTrigger()) {
            e_r.set(-.6);
            e_l.set(.6);
        } else {
            e_r.set(0);
            e_l.set(0);
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
