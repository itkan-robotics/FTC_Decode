package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Constants;

@TeleOp
@Config
public class InchesPerTickTuner extends OpMode {

    public static int inchesPushed = 72;
    DcMotorEx fl, fr, bl, br;
    @Override
    public void init() {
        fl = hardwareMap.get(DcMotorEx.class, Constants.frontLeftName);
        fr = hardwareMap.get(DcMotorEx.class, Constants.frontRightName);
        bl = hardwareMap.get(DcMotorEx.class, Constants.backLeftName);
        br = hardwareMap.get(DcMotorEx.class, Constants.backRightName);
        fl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        fr.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        bl.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        br.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        fl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    @Override
    public void loop() {
        int avgTicks = fl.getCurrentPosition()+fr.getCurrentPosition()+bl.getCurrentPosition()+br.getCurrentPosition();
        avgTicks /= 4;
        telemetry.addData("Current Ticks", avgTicks);
        telemetry.addData("Inches Per Tick", ((double)inchesPushed)/avgTicks);
        telemetry.update();
    }
}
