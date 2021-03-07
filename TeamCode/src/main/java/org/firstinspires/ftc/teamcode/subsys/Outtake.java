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

    public String elbowStatus;
    public String wristStatus;
    public String slidesHeight;

    public Outtake(HardwareMap outtakeMap) {
        leftSlides = outtakeMap.get(DcMotorEx.class, "leftSlides");
        rightSlides = outtakeMap.get(DcMotorEx.class, "rightSlides");
        leftElbow = outtakeMap.servo.get("leftElbow");
        rightElbow = outtakeMap.servo.get("rightElbow");
        wrist = outtakeMap.servo.get("wrist");
    }

    public enum Slide_Positions {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    }

    public enum Elbow_Positions {
        HOLDING, RELEASING
    }

    public enum Wrist_Positions {
        OPEN, CLOSED
    }

    public int[] SLIDE_POSITIONS = {100, 200, 300, 400, 500, 600, 700};
    public double[] ELBOW_POSITIONS = {0.1, 0.9};
    public double[] WRIST_POSITIONS = {0.1, 0.9};

    public void setSlidePositions(Slide_Positions slidePosition) {
        leftSlides.setTargetPosition(SLIDE_POSITIONS[slidePosition.ordinal()]);
        rightSlides.setTargetPosition(-(SLIDE_POSITIONS[slidePosition.ordinal()]));
    }

    public void setElbowPositions(Elbow_Positions elbow_position) {
        leftElbow.setPosition(ELBOW_POSITIONS[elbow_position.ordinal()]);
        rightElbow.setPosition((ELBOW_POSITIONS[elbow_position.ordinal()]) - 0.5);
    }

    public void setWristPositions(Wrist_Positions wristPosition) {
        wrist.setPosition(WRIST_POSITIONS[wristPosition.ordinal()]);
    }

    public void setOuttakeState(boolean outtakeInputInc, boolean outtakeInputDec, boolean slideInput) {
        outtakeTog.changeState(outtakeInputInc, outtakeInputDec);
        slideTog.changeState(slideInput);
        switch (outtakeTog.currentState()) {
            case 0: // Picking up Skystone
                setElbowPositions(Elbow_Positions.HOLDING);
                setWristPositions(Wrist_Positions.OPEN);
                setSlidePositions(Slide_Positions.ONE);
                elbowStatus = "Pulled Back/Holding";
                wristStatus = "Open";
                slidesHeight = "Skystone Pickup";
                break;
            case 1: // Closing wrist
                setElbowPositions(Elbow_Positions.HOLDING);
                setWristPositions(Wrist_Positions.CLOSED);
                setSlidePositions(Slide_Positions.ONE);
                elbowStatus = "Pulled Back/Holding";
                wristStatus = "Closed";
                slidesHeight = "Skystone Pickup";
                break;
            case 2: // Moving Skystone to correct height
                setElbowPositions(Elbow_Positions.HOLDING);
                setWristPositions(Wrist_Positions.CLOSED);
                switch (outtakeTog.currentState()) {
                    case 0: // Picking up Skystone Height
                        setSlidePositions(Slide_Positions.ONE);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Skystone Pickup";
                        break;
                    case 1: // Comment when heights are set
                        setSlidePositions(Slide_Positions.TWO);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 2";
                        break;
                    case 2: // Comment when heights are set
                        setSlidePositions(Slide_Positions.THREE);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 3";
                        break;
                    case 3: // Comment when heights are set
                        setSlidePositions(Slide_Positions.FOUR);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 4";
                        break;
                    case 4: // Comment when heights are set
                        setSlidePositions(Slide_Positions.FIVE);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 5";
                        break;
                    case 5: // Comment when heights are set
                        setSlidePositions(Slide_Positions.SIX);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 6";
                        break;
                    case 6: // Comment when heights are set
                        setSlidePositions(Slide_Positions.SEVEN);
                        elbowStatus = "Pulled Back/Holding";
                        wristStatus = "Closed";
                        slidesHeight = "Height 7";
                        break;
                    default:
                        break;
                }
                break;
            case 3: // Placing Skystone
                setElbowPositions(Elbow_Positions.RELEASING);
                setWristPositions(Wrist_Positions.OPEN);
                elbowStatus = "Extended/Releasing";
                wristStatus = "Open";
                break;
            case 4: // Pulling back elbow
                setElbowPositions(Elbow_Positions.HOLDING);
                elbowStatus = "Pulled Back/Holding";
                break;
        }
    }
}
