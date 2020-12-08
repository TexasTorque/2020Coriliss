package org.texastorque.subsystems;

import org.texastorque.constants.Input;
import edu.wpi.first.wpilibj.PWMSparkMax;
import org.texastorque.torquelib.util.GenericController;

public class Shooter {
    private static volatile Shooter instance;
    GenericController controller = new GenericController(1, 0.1);
    PWMSparkMax SHOOT_LEFT = new PWMSparkMax(Input.SHOOTER_LEFT);
    PWMSparkMax SHOOT_RIGHT = new PWMSparkMax(Input.SHOOTER_RIGHT);
    PWMSparkMax SHOOT_LOAD = new PWMSparkMax(Input.SHOOTER_LOADER);

    public void run(){
        if(controller.getRightTrigger()){
            SHOOT_RIGHT.set(.8);
            SHOOT_LEFT.set(-.8);
            SHOOT_LOAD.set(.4);
        } else {
            SHOOT_RIGHT.set(0);
            SHOOT_LEFT.set(0);
            SHOOT_LOAD.set(0);
        }
    }
    
    public static Shooter getInstance(){
        if (instance == null){
            synchronized(Shooter.class){
                if (instance == null)
                    instance = new Shooter();
            }
        }
        return instance;
    }
}
