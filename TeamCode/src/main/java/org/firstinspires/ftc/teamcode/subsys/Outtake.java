package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;

public class Outtake {
    DcMotorEx leftSlides;
    DcMotorEx rightSlides;
    Servo leftElbow;
    Servo rightElbow;
    Servo wrist;

    Toggler outtakeTog = new Toggler(5);
    Toggler slideTog = new Toggler(7);

    public Outtake(HardwareMap outtakeMap){
        leftSlides = outtakeMap.get(DcMotorEx.class, "leftSlides");
        rightSlides = outtakeMap.get(DcMotorEx.class, "rightSlides");
        leftElbow = outtakeMap.servo.get("leftElbow");
        rightElbow = outtakeMap.servo.get("rightElbow");
        wrist = outtakeMap.servo.get("wrist");
    }

    public enum Slide_Positions{
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    }

    public enum Elbow_Positions{
     HOLDING, RELEASING
    }
    public enum Wrist_Positions{
        OPEN, CLOSED
    }
    public int[] SLIDE_POSITIONS = {100, 200, 300, 400, 500, 600, 700};
    public double[] ELBOW_POSITIONS = {0.1, 0.9};
    public double[] WRIST_POSITIONS = {0.1, 0.9};

    public void setSlidePositions(Slide_Positions slidePosition){
        leftSlides.setTargetPosition(SLIDE_POSITIONS[slidePosition.ordinal()]);
        rightSlides.setTargetPosition(-(SLIDE_POSITIONS[slidePosition.ordinal()]));
    }

    public void setElbowPositions(Elbow_Positions elbow_position){
        leftElbow.setPosition(ELBOW_POSITIONS[elbow_position.ordinal()]);
        rightElbow.setPosition((ELBOW_POSITIONS[elbow_position.ordinal()])-0.5);
    }

    public void setWristPositions(Wrist_Positions wristPosition){
        wrist.setPosition(WRIST_POSITIONS[wristPosition.ordinal()]);
    }
    public void setOuttakeState(boolean outtakeInputInc, boolean outtakeInputDec, boolean slideInput){
        outtakeTog.changeState(outtakeInputInc, outtakeInputDec);
        switch(outtakeTog.currentState()){
            case 0:
                setElbowPositions(Elbow_Positions.HOLDING);
                setWristPositions(Wrist_Positions.OPEN);

        }
    }
}
