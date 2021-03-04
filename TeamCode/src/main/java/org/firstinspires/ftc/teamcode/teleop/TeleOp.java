package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.subsys.Capstone;
import org.firstinspires.ftc.teamcode.subsys.FoundationPullers;

public class TeleOp extends OpMode {
    FoundationPullers foundationPullers;
    Capstone capstone;

    @Override
    public void init() {
        foundationPullers = new FoundationPullers(hardwareMap);
        capstone = new Capstone(hardwareMap);
    }

    @Override
    public void loop() {

        // Foundation Pullers
       if (gamepad1.a){
           foundationPullers.toggleFoundationPullerPos(gamepad1.a);
       }

       // Capstone
        if (gamepad1.b){
            capstone.setCapstoneState(gamepad1.b);
        }





       // Telemetry
       telemetry.addData("Foundation Puller Status", foundationPullers.foundationPullerStatus);
        telemetry.addData("Capstone Status", capstone.capstoneStatus);
    }
}
