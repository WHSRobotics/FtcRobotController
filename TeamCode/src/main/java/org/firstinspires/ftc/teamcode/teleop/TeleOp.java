package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsys.Capstone;
import org.firstinspires.ftc.teamcode.subsys.FoundationPullers;
import org.firstinspires.ftc.teamcode.subsys.Outtake;
import org.firstinspires.ftc.teamcode.subsys.Robot;

public class TeleOp extends OpMode {
    Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_down || gamepad1.b ){
            robot.intake.turnOnIntake(false);
        }
        // Foundation Pullers
        if (gamepad1.x) {
            robot.foundationPullers.toggleFoundationPullerPos(gamepad1.x);
        }
        // Capstone
        if (gamepad1.y) {
            robot.capstone.setCapstoneState(gamepad1.y);
        }
        // Outtake
        if (gamepad1.dpad_left || gamepad1.dpad_right || gamepad1.dpad_up) {
            robot.outtake.setOuttakeState(gamepad1.dpad_left, gamepad1.dpad_right, gamepad2.dpad_up);
        }


        // Telemetry
        telemetry.addData("Foundation Puller Status", robot.foundationPullers.foundationPullerStatus);
        telemetry.addData("Capstone Status", robot.capstone.capstoneStatus);
        telemetry.addData("Outtake Elbow Status", robot.outtake.elbowStatus);
        telemetry.addData("Outtake Wrist Status", robot.outtake.wristStatus);
        telemetry.addData("Outtake Slides Height", robot.outtake.slidesHeight);
    }
}
