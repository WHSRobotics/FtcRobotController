package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Outtake {
    DcMotorEx leftSlides;
    DcMotorEx rightSlides;
    Servo elbow;
    Servo wrist;

    public Outtake(HardwareMap outtakeMap){
        leftSlides = outtakeMap.get(DcMotorEx.class, "leftSlides");
        rightSlides = outtakeMap.get(DcMotorEx.class, "rightSlides");
        elbow = outtakeMap.servo.get("elbow");
        wrist = outtakeMap.servo.get("wrist");
    }

    public enum Slide_Positions{
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    }

    public enum Elbow_Positions{
        READY, HOLDING, RELEASING
    }
    public enum Wrist_Positions{
        OPEN, CLOSED
    }
}
