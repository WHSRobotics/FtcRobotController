package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;

public class FoundationPullers {
    Servo leftHook;
    Servo rightHook;

    Toggler pullerPositionToggler = new Toggler(2);

    public String foundationPullerStatus;

    public FoundationPullers(HardwareMap foundationPullerMap) {
        leftHook = foundationPullerMap.servo.get("leftHook");
        rightHook = foundationPullerMap.servo.get("rightHook");
    }

    public enum Puller_Positions {
        UP, DOWN
    }

    //Test for settings
    public double[] PULLER_POSITIONS = {0.1, 0.5};

    public void setFoundationPuller(Puller_Positions pullerPosition) {
        leftHook.setPosition(PULLER_POSITIONS[pullerPosition.ordinal()]);
        rightHook.setPosition(PULLER_POSITIONS[pullerPosition.ordinal()]);
    }

    // TeleOp Methods
    public void toggleFoundationPullerPos(boolean pullerUpDownInput) {
        pullerPositionToggler.changeState(pullerUpDownInput);
        if (pullerPositionToggler.currentState() == 0) {
            leftHook.setPosition(PULLER_POSITIONS[Puller_Positions.UP.ordinal()]);
            rightHook.setPosition(PULLER_POSITIONS[Puller_Positions.UP.ordinal()]);
            foundationPullerStatus = "Pullers Up";
        } else {
            leftHook.setPosition(PULLER_POSITIONS[Puller_Positions.DOWN.ordinal()]);
            rightHook.setPosition(PULLER_POSITIONS[Puller_Positions.DOWN.ordinal()]);
            foundationPullerStatus = "Pullers Down";
        }
    }



}
