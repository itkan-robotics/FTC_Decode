package org.firstinspires.ftc.teamcode.subsystems.slides;


import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HorizontalSlideSubsystem extends SubsystemBase implements Slide {
    SlideSubsystem slide;
    public HorizontalSlideSubsystem(HardwareMap hardwareMap, String name, boolean flipEncoder){
        slide = new SlideSubsystem(hardwareMap, name, flipEncoder);
    }
    public void set(int pos){slide.set(pos);}
    public boolean atPos(){return slide.atPos();}
    public int get(){return slide.get();}
    public void reset(){slide.reset();}
}