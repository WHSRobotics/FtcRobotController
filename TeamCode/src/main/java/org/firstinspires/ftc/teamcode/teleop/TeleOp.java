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

        // Foundation Pullers
        if (gamepad1.a) {
            foundationPullers.toggleFoundationPullerPos(gamepad1.a);
        }

        // Capstone
        if (gamepad1.b) {
            capstone.setCapstoneState(gamepad1.b);
        }

        // Outtake
        if (gamepad2.a || gamepad2.b || gamepad2.dpad_up) {
            outtake.setOuttakeState(gamepad2.a, gamepad2.b, gamepad2.dpad_up);
        }


        // Telemetry
        telemetry.addData("Foundation Puller Status", foundationPullers.foundationPullerStatus);
        telemetry.addData("Capstone Status", capstone.capstoneStatus);
        telemetry.addData("Outtake Elbow Status", outtake.elbowStatus);
        telemetry.addData("Outtake Wrist Status", outtake.wristStatus);
        telemetry.addData("Outtake Slides Height", outtake.slidesHeight);
    }
}
