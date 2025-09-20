package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class ShooterSubsystem extends SubsystemBase {
    private DcMotorEx slide;
    double rpm = 0;

    public ShooterSubsystem(HardwareMap h, String name) {
        slide = h.get(DcMotorEx.class, name);
        slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public void set(double rpm) {
        slide.setVelocity(rpm);
        this.rpm = rpm;
    }
    public boolean atVelocity(){
        return Math.abs(slide.getVelocity() - rpm) < 10;
    }
    public void setPIDF(double p, double i, double d, double f) {
        slide.setVelocityPIDFCoefficients(p, i, d, f);
    }

}