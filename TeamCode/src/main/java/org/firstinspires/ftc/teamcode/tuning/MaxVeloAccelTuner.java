package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Constants;

import java.util.HashMap;
import org.firstinspires.ftc.teamcode.util.*;

@Config
@TeleOp
public class MaxVeloAccelTuner extends OpMode {
    public static double timeToRun = 3;
    long startTime;
    boolean first;
    boolean isRunning;
    DcMotorEx fl, fr, bl, br;
    HashMap<Double, Integer> pairs = new HashMap<>();
    Datalog datalog;
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
        datalog = new Datalog("datalog_01");

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
            datalog.position.set(avgTicks);
            datalog.writeLine();
        }
        else {

        }
        if((System.nanoTime()-startTime)/1000000000.0 >= timeToRun){
            isRunning = false;
        }


    }
    public static class Datalog
    {
        // The underlying datalogger object - it cares only about an array of loggable fields
        private final Datalogger datalogger;

        // These are all of the fields that we want in the datalog.
        // Note that order here is NOT important. The order is important in the setFields() call below
        public Datalogger.GenericField position = new Datalogger.GenericField("Position (Ticks)");

        public Datalog(String name)
        {
            // Build the underlying datalog object
            datalogger = new Datalogger.Builder()

                    // Pass through the filename
                    .setFilename(name)

                    // Request an automatic timestamp field
                    .setAutoTimestamp(Datalogger.AutoTimestamp.DECIMAL_SECONDS)

                    // Tell it about the fields we care to log.
                    // Note that order *IS* important here! The order in which we list
                    // the fields is the order in which they will appear in the log.
                    .setFields(
                            position
                    )
                    .build();
        }

        // Tell the datalogger to gather the values of the fields
        // and write a new line in the log.
        public void writeLine()
        {
            datalogger.writeLine();
        }
    }
}
