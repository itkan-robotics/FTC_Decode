package org.firstinspires.ftc.teamcode.subsystems.slides;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public interface Slide{
    public void set(int pos);
    public boolean atPos();
    public int get();
    public void reset();

}