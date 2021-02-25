package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Capstone {
    Servo gate;
    Servo lock;
    Servo cradle;
    public Capstone(HardwareMap capstoneMap){
        gate = capstoneMap.servo.get("gate");
        lock = capstoneMap.servo.get("lock");
        cradle = capstoneMap.servo.get("cradle");
    }
    public enum Gate_Positions{
        CLOSED, OPEN
    }
    public enum Lock_Positions{
        DOWN, UP
    }
    public enum Cradle_Positions{
        HOLD, RELEASE
    }

    //Test for these settings
    public double[] GATE_POSITIONS = {0.1, 0.9};
    public double[] LOCK_POSITIONS = {0.1, 0.9};
    public double[] CRADLE_POSITIONS = {0.1, 0.9};

    public void setGate(Gate_Positions gatePosition){
        gate.setPosition(GATE_POSITIONS[gatePosition.ordinal()]);
    }
    public void setLock(Lock_Positions lockPosition){
        lock.setPosition(LOCK_POSITIONS[lockPosition.ordinal()]);
    }
    public void setCradle(Cradle_Positions cradlePosition){
        cradle.setPosition(CRADLE_POSITIONS[cradlePosition.ordinal()]);
    }
}
