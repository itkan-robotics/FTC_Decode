package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

@Config
@TeleOp
public class FlywheelTuner extends OpMode {
    public static double p, i, d, f;
    public static double target;
    public static double current;
    public int lpos;
    public DcMotorEx turret = hardwareMap.get(DcMotorEx.class, "turret");
    public ElapsedTime t = new ElapsedTime();
    public double last;

    @Override
    public void init() {
        t.startTime();
        last = t.time(TimeUnit.SECONDS);
        lpos = turret.getCurrentPosition();
    }

    @Override
    public void loop() {
        current = (turret.getCurrentPosition()-lpos)/(t.time(TimeUnit.SECONDS) - last);
        turret.setVelocityPIDFCoefficients(p, i, d, f);
        turret.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        turret.setVelocity(target);
        last = t.time(TimeUnit.SECONDS);
        lpos = turret.getCurrentPosition();
        TelemetryPacket v = new TelemetryPacket();
        v.addLine("Current Velocity: " + current);
        v.addLine("Target Velocity: " + target);
        FtcDashboard.getInstance().sendTelemetryPacket(v);

    }
}
