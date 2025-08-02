package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.util.GoBildaPinpointDriver;

public class PinpointSubsystem extends SubsystemBase {
    public GoBildaPinpointDriver pinpoint;
    public PinpointSubsystem(HardwareMap h, String name){
        pinpoint = h.get(GoBildaPinpointDriver.class, name);
        pinpoint.setOffsets(Constants.pinpointXOffset, Constants.pinpointYOffset, DistanceUnit.INCH);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.REVERSED, GoBildaPinpointDriver.EncoderDirection.REVERSED);
        pinpoint.resetPosAndIMU();
    }
    public Pose2d getPose(){
        pinpoint.update();
        double x = pinpoint.getPosX(DistanceUnit.INCH);
        double y = pinpoint.getPosY(DistanceUnit.INCH);
        double heading = pinpoint.getHeading(AngleUnit.RADIANS);
        return new Pose2d(x, y, new Rotation2d(heading));
    }
    public void setup(double x, double y, double heading){
        pinpoint.setPosition(new Pose2D(DistanceUnit.INCH, x, y, AngleUnit.RADIANS, heading));
    }
}