package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.lib.util.Toggler;

public class Intake  {
    public DcMotor leftIntake;
    public DcMotor rightIntake;
    public Servo dropdown;
    public final double INTAKE_SPEED = 0.75;
    public String intakeState;
    Toggler intakeTog = new Toggler(2);
    public Intake (HardwareMap IntakeMap){
        leftIntake = IntakeMap.dcMotor.get("leftIntake");
        rightIntake = IntakeMap.dcMotor.get("rightIntake");
        dropdown = IntakeMap.servo.get("dropdown");
    }
    public void turnOnIntake (boolean reverse){
        if (reverse){
            intakeState = "On Forword";
            leftIntake.setPower(INTAKE_SPEED);
            rightIntake.setPower(-INTAKE_SPEED);
        }
        else {
            intakeState = "On Backward";
            leftIntake.setPower(-INTAKE_SPEED);
            rightIntake.setPower(INTAKE_SPEED);
        }
    }

    public void turnOffIntake(){
        intakeState = "Off";
        leftIntake.setPower(0);
        rightIntake.setPower(0);
    }

    public void runIntake (boolean powerSwitch, boolean reverse){
        intakeTog.changeState(powerSwitch);
        switch (intakeTog.currentState()){
            case 0:
                turnOffIntake();
            case 1:
                turnOnIntake(reverse);
        }
    }
}
