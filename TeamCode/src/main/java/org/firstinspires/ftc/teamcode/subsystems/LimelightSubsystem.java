package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

public class LimelightSubsystem {
    private Limelight3A slide;

    public LimelightSubsystem(HardwareMap h, String name) {
        slide = h.get(Limelight3A.class, name);
    }



    public Limelight3A get(){
        return slide;
    }

}