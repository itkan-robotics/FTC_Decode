package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@Config
@TeleOp
public class TurretTuner extends OpMode {
    public static double p, i, d, f;
    public static int target;
    public static int current;
    public DcMotorEx turret = hardwareMap.get(DcMotorEx.class, "turret");

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        PIDFCoefficients c = new PIDFCoefficients(p, i, d, f);
        turret.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, c);
        turret.setTargetPosition(target);
        turret.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        turret.setPower(1);
        TelemetryPacket t = new TelemetryPacket();
        current = turret.getCurrentPosition();
        t.addLine("Current Position: " + current);
        t.addLine("Target Position: " + target);
        FtcDashboard.getInstance().sendTelemetryPacket(t);
    }
}
