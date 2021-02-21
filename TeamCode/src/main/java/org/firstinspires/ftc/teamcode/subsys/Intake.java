package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Intake  {
    public DcMotor leftIntake;
    public DcMotor rightIntake;
    public Servo dropdown;
    public final double INTAKE_SPEED = 0.75;
    public Intake (HardwareMap IntakeMap){
        leftIntake = IntakeMap.dcMotor.get("leftIntake");
        rightIntake = IntakeMap.dcMotor.get("rightIntake");
        dropdown = IntakeMap.servo.get("dropdown");
    }
    public void setIntakeSpeed (boolean reverse){
        if (reverse){
            leftIntake.setPower(INTAKE_SPEED);
            rightIntake.setPower(-INTAKE_SPEED);
        }
        else {
            leftIntake.setPower(-INTAKE_SPEED);
            rightIntake.setPower(INTAKE_SPEED);
        }
    }
}
