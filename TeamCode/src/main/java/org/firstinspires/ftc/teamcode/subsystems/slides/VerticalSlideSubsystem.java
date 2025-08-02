package org.firstinspires.ftc.teamcode.subsystems.slides;

import android.hardware.HardwareBuffer;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class VerticalSlideSubsystem implements Slide {
    SlideSubsystem slide;
    public VerticalSlideSubsystem(HardwareMap hardwareMap, String name, boolean flipEncoder){
        slide = new SlideSubsystem(hardwareMap, name, flipEncoder);
    }
    public void set(int pos){slide.set(pos);}
    public boolean atPos(){return slide.atPos();}
    public int get(){return slide.get();}
    public void reset(){slide.reset();}
}