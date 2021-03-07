package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;

public class Capstone {
    Servo gate;
    Servo lock;
    Servo cradle;

    public String capstoneStatus;

    Toggler capstoneToggler = new Toggler(4);

    public Capstone(HardwareMap capstoneMap) {
        gate = capstoneMap.servo.get("gate");
        lock = capstoneMap.servo.get("lock");
        cradle = capstoneMap.servo.get("cradle");
    }

    public enum Gate_Positions {
        CLOSED, OPEN
    }

    public enum Lock_Positions {
        DOWN, UP
    }

    public enum Cradle_Positions {
        HOLD, RELEASE
    }

    //Test for these settings
    public double[] GATE_POSITIONS = {0.1, 0.9};
    public double[] LOCK_POSITIONS = {0.1, 0.9};
    public double[] CRADLE_POSITIONS = {0.1, 0.9};

    public void setGate(Gate_Positions gatePosition) {
        gate.setPosition(GATE_POSITIONS[gatePosition.ordinal()]);
    }

    public void setLock(Lock_Positions lockPosition) {
        lock.setPosition(LOCK_POSITIONS[lockPosition.ordinal()]);
    }

    public void setCradle(Cradle_Positions cradlePosition) {
        cradle.setPosition(CRADLE_POSITIONS[cradlePosition.ordinal()]);
    }

    public void setCapstoneState(boolean capstoneStateInput) {
        capstoneToggler.changeState(capstoneStateInput);
        if (capstoneToggler.currentState() == 0) { // Normal
            gate.setPosition(GATE_POSITIONS[Gate_Positions.OPEN.ordinal()]);
            lock.setPosition(LOCK_POSITIONS[Lock_Positions.UP.ordinal()]);
            cradle.setPosition(CRADLE_POSITIONS[Cradle_Positions.HOLD.ordinal()]);
            capstoneStatus = "Normal";
        } else if (capstoneToggler.currentState() == 1) { // Trap the skystone
            gate.setPosition(GATE_POSITIONS[Gate_Positions.CLOSED.ordinal()]);
            lock.setPosition(LOCK_POSITIONS[Lock_Positions.UP.ordinal()]);
            cradle.setPosition(CRADLE_POSITIONS[Cradle_Positions.HOLD.ordinal()]);
            capstoneStatus = "Skyblock Trapped";
        } else if (capstoneToggler.currentState() == 2) { // Remove the capstone lock
            gate.setPosition(GATE_POSITIONS[Gate_Positions.CLOSED.ordinal()]);
            lock.setPosition(LOCK_POSITIONS[Lock_Positions.DOWN.ordinal()]);
            cradle.setPosition(CRADLE_POSITIONS[Cradle_Positions.HOLD.ordinal()]);
            capstoneStatus = "Capstone Lock Down";
        } else { // Release the capstone
            gate.setPosition(GATE_POSITIONS[Gate_Positions.CLOSED.ordinal()]);
            lock.setPosition(LOCK_POSITIONS[Lock_Positions.DOWN.ordinal()]);
            cradle.setPosition(CRADLE_POSITIONS[Cradle_Positions.RELEASE.ordinal()]);
            capstoneStatus = "Capstone Released";
        }
    }

}
