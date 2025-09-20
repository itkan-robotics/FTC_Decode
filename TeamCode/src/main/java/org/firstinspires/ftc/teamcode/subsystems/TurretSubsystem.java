package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class TurretSubsystem extends SubsystemBase {
    private DcMotorEx slide;

    public TurretSubsystem(HardwareMap h, String name) {
        slide = h.get(DcMotorEx.class, name);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        slide.setPower(1);
    }



    public void set(int pos) {
        slide.setTargetPosition(pos);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        slide.setPower(1);
    }
    public boolean atPos(){
        return Math.abs(slide.getCurrentPosition() - slide.getTargetPosition()) < 20;
    }
    public void setPIDF(double p, double i, double d, double f){
        slide.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, new PIDFCoefficients(p, i, d, f));
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }



    public void reset(){
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setPower(0.0);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

}