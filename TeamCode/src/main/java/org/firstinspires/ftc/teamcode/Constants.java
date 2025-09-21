package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.geometry.Translation2d;

@Config
public class Constants {
    public static final double inchesPerTick = 0.06492335437330929;

    public static final String frontLeftName = "FrontLeft";
    public static final boolean frontLeftMotorDirectionReversed = true;
    public static final String frontRightName = "FrontRight";
    public static final boolean frontRightMotorDirectionReversed = true;
    public static final String backLeftName = "BackLeft";
    public static final boolean backLeftMotorDirectionReversed = true;
    public static final String backRightName = "BackRight";
    public static final boolean backRightMotorDirectionReversed = true;
    public static final String pinpointName = "odo";
    public static final double pinpointXOffset = 3.8125;
    public static final double pinpointYOffset = 1.875;
    public static final String turretName = "turret";
    public static final String intakeName = "Intake";
    public static final String climbName = "Climb";
    public static final String shooterName = "Shooter";
    public static final String llName = "limelight";
    public static final String holdName = "hold";

    public static final double[] distLT = {1, 2, 3};
    public static final double[] veloLT = {2, 4, 7};

    public static final Translation2d frontLeftWheelMeters = new Translation2d(5, 5.75);
    public static final Translation2d frontRightWheelMeters = new Translation2d(5, -5.75);
    public static final Translation2d backLeftWheelMeters = new Translation2d(-5, 5.75);
    public static final Translation2d backRightWheelMeters = new Translation2d(-5, -5.75);

    //TODO Tune these follower PID values
    public static final PIDController xPID = new PIDController(0.2, 0, 0);
    public static final PIDController yPID = new PIDController(0.2, 0, 0);
    public static final PIDController tPID = new PIDController(0.2, 0, 0);

    public static final double maxAcceleration = 70;
    public static final double maxVelocity = 85;








}