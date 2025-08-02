package org.firstinspires.ftc.teamcode.subsystems.slides;

import android.hardware.HardwareBuffer;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class VerticalSlideSubsystem extends SubsystemBase implements Slide {
    SlideSubsystem rSlide, lSlide;
    public VerticalSlideSubsystem(HardwareMap hardwareMap, String rName, String lName, boolean rFlipEncoder, boolean lFlipEncoder){
        rSlide = new SlideSubsystem(hardwareMap, rName, rFlipEncoder);
        lSlide = new SlideSubsystem(hardwareMap, lName, lFlipEncoder);
    }
    public void set(int pos){
        rSlide.set(pos);
        lSlide.set(pos);
    }
    public boolean atPos(){
        return rSlide.atPos() && lSlide.atPos();
    }
    public int get(){
        return (rSlide.get() + lSlide.get())/2;
    }
    public void reset(){
        rSlide.reset();
        lSlide.reset();
    }
}