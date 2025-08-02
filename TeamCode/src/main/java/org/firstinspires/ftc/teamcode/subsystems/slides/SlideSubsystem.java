package org.firstinspires.ftc.teamcode.subsystems.slides;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SlideSubsystem {
    private DcMotorEx slide;
    boolean flipEncoder;

    public SlideSubsystem(HardwareMap h, String name, boolean flipEncoder) {
        slide = h.get(DcMotorEx.class, name);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        slide.setPower(1);
        this.flipEncoder = flipEncoder;
    }



    public void set(int pos) {
        if(flipEncoder) pos *= -1;
        slide.setTargetPosition(pos);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        slide.setPower(1);
    }
    public boolean atPos(){
        return Math.abs(slide.getCurrentPosition() - slide.getTargetPosition()) < 20;
    }
    public int get(){
        if (flipEncoder) return -slide.getTargetPosition();
        return slide.getTargetPosition();
    }

    public void reset(){
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setPower(0.0);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

}