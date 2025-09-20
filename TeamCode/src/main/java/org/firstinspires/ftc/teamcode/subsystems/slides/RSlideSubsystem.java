package org.firstinspires.ftc.teamcode.subsystems.slides;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RSlideSubsystem extends SubsystemBase {
    private DcMotorEx slide;
    boolean flipEncoder;

    public RSlideSubsystem(HardwareMap h, String name, boolean flipEncoder) {
        slide = h.get(DcMotorEx.class, name);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }



    public void set(double power) {
        slide.setPower(power);
    }


    public void reset(){
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slide.setTargetPosition(0);
        slide.setPower(0.0);
        slide.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

}