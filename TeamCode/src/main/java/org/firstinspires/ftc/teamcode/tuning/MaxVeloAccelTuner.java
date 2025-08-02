package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Constants;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Config
@TeleOp
public class MaxVeloAccelTuner extends OpMode {
    public static double timeToRun = 3;
    long startTime;
    boolean first;
    boolean isRunning;
    DcMotorEx fl, fr, bl, br;
    HashMap<Double, Integer> pairs = new HashMap<>();
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
        first = true;
        if(Constants.frontLeftMotorDirectionReversed) fl.setDirection(DcMotorSimple.Direction.REVERSE);
        if(Constants.frontRightMotorDirectionReversed) fr.setDirection(DcMotorSimple.Direction.REVERSE);
        if(Constants.backLeftMotorDirectionReversed) bl.setDirection(DcMotorSimple.Direction.REVERSE);
        if(Constants.backRightMotorDirectionReversed) br.setDirection(DcMotorSimple.Direction.REVERSE);

        isRunning = true;
    }

    @Override
    public void loop() {
        if(first){
            first = false;
            startTime = System.nanoTime();
            fl.setPower(1);
            fr.setPower(1);
            bl.setPower(1);
            br.setPower(1);
        }
        if(isRunning){
            int avgTicks = fl.getCurrentPosition()+fr.getCurrentPosition()+bl.getCurrentPosition()+br.getCurrentPosition();
            avgTicks /= 4;
            pairs.put((System.nanoTime()-startTime)/1000000000.0, avgTicks);
        }
        else {
            String vals = "";
            for(Map.Entry<Double, Integer> entry : pairs.entrySet()){
                double time = entry.getKey();
                int position = entry.getValue();
                vals += time + " : " + position + "\n";
            }
            telemetry.addLine(vals);
            telemetry.update();
        }
        if((System.nanoTime()-startTime)/1000000000.0 >= timeToRun){
            isRunning = false;
        }


    }
}
