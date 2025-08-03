package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.geometry.Translation2d;


public class Constants {
    public static final double inchesPerTick = 0.06492335437330929;
    public static final double blockerOpenPos = 0.5;
    public static final double blockerClosePos = 0;
    public static final double grabberOpenPos = 0.1;
    public static final double grabberClosePos = 1;
    public static final double intakeRotIntakePos = 0.6;
    public static final double intakeRotTransferPos = .18;
    public static final double intakeRotStowPos = 0;
    public static final double handBasketScorePos = 0.9;
    public static final double handTransferPos = .15;
    public static final int highBasketHeight = 1200;
    public static final int lowBasketHeight = 900;

    public static final String intakeRotName = "intakeWrist";
    public static final String grabberName = "grabber";
    public static final String blockerName = "blocker";
    public static final String handName = "scorewrist";
    public static final String hSlideName = "Iextend";
    public static final boolean hSlideEncoderDirectionReversed = true;
    public static final String vSlideRightName = "Relevator";
    public static final String vSlideLeftName = "Lelevator";
    public static final boolean vSlideRightEncoderDirectionReversed = false;
    public static final boolean vSlideLeftEncoderDirectionReversed = true;
    public static final String frontLeftName = "fl";
    public static final boolean frontLeftMotorDirectionReversed = false;
    public static final String frontRightName = "fr";
    public static final boolean frontRightMotorDirectionReversed = true;
    public static final String backLeftName = "bl";
    public static final boolean backLeftMotorDirectionReversed = false;
    public static final String backRightName = "br";
    public static final boolean backRightMotorDirectionReversed = true;
    public static final String intakeName = "intake";
    public static final String colorSensorName = "color_sensor";
    public static final String pinpointName = "odo";
    public static final double pinpointXOffset = 3.8125;
    public static final double pinpointYOffset = 1.875;

    public static final Translation2d frontLeftWheelMeters = new Translation2d(5, 5.75);
    public static final Translation2d frontRightWheelMeters = new Translation2d(5, -5.75);
    public static final Translation2d backLeftWheelMeters = new Translation2d(-5, 5.75);
    public static final Translation2d backRightWheelMeters = new Translation2d(-5, -5.75);

    //TODO Tune these follower PID values
    public static final double followerXkP = 0;
    public static final double followerXkI = 0;
    public static final double followerXkD = 0;
    public static final double followerYkP = 0;
    public static final double followerYkI = 0;
    public static final double followerYkD = 0;
    public static final double followerThetakP = 0;
    public static final double followerThetakI = 0;
    public static final double followerThetakD = 0;

    public static final double maxAcceleration = 70;
    public static final double maxVelocity = 85;








}