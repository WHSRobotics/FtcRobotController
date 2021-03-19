package org.firstinspires.ftc.teamcode.subsys;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public Intake intake;
    public Outtake outtake;
    public Capstone capstone;
    public Drivetrain drivetrain;
    public FoundationPullers foundationPullers;
    public IMU imu;

    public Robot(HardwareMap robotMap){
        intake = new Intake(robotMap);
        outtake = new Outtake(robotMap);
        capstone = new Capstone(robotMap);
        drivetrain = new Drivetrain(robotMap);
        foundationPullers = new FoundationPullers(robotMap);
        imu = new IMU(robotMap);
    }
}
