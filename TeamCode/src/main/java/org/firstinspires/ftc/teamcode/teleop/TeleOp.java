package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsys.Capstone;
import org.firstinspires.ftc.teamcode.subsys.FoundationPullers;
import org.firstinspires.ftc.teamcode.subsys.Outtake;

public class TeleOp extends OpMode {
    FoundationPullers foundationPullers;
    Capstone capstone;
    Outtake outtake;

    @Override
    public void init() {
        foundationPullers = new FoundationPullers(hardwareMap);
        capstone = new Capstone(hardwareMap);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_down || gamepad1.b ){

        }
        // Foundation Pullers
        if (gamepad1.x) {
            foundationPullers.toggleFoundationPullerPos(gamepad1.x);
        }
        // Capstone
        if (gamepad1.y) {
            capstone.setCapstoneState(gamepad1.y);
        }
        // Outtake
        if (gamepad1.dpad_left || gamepad1.dpad_right || gamepad1.dpad_up) {
            outtake.setOuttakeState(gamepad1.dpad_left, gamepad1.dpad_right, gamepad2.dpad_up);
        }


        // Telemetry
        telemetry.addData("Foundation Puller Status", foundationPullers.foundationPullerStatus);
        telemetry.addData("Capstone Status", capstone.capstoneStatus);
        telemetry.addData("Outtake Elbow Status", outtake.elbowStatus);
        telemetry.addData("Outtake Wrist Status", outtake.wristStatus);
        telemetry.addData("Outtake Slides Height", outtake.slidesHeight);
    }
}
