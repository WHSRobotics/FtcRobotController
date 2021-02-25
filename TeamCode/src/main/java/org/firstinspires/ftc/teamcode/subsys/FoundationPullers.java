package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class FoundationPullers {
    Servo leftHook;
    Servo rightHook;
    public FoundationPullers(HardwareMap foundationPullerMap){
        leftHook = foundationPullerMap.servo.get("leftHook");
        rightHook = foundationPullerMap.servo.get("rightHook");
    }
    public enum Puller_Positions{
        UP, DOWN
    }
    //Test for settings
    public double[] PULLER_POSITIONS = {0.1, 0.5};
    public void setFoundationPuller(Puller_Positions pullerPosition){
        leftHook.setPosition(PULLER_POSITIONS[pullerPosition.ordinal()]);
        rightHook.setPosition(PULLER_POSITIONS[pullerPosition.ordinal()]);
    }
}
