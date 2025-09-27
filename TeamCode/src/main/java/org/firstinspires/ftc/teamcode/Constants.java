package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.geometry.Rotation2d;
import com.arcrobotics.ftclib.geometry.Translation2d;

/*
 * Pathing Conventions
 * Given the field in an orientation where the obelisk is opposite to the viewing point, the +x direction
 * is rightwards, the -x direction is leftwards, the +y direction is forward, and the -y direction is
 * backwards. 0 degrees is when the robot is facing directly in the +x direction, with a heading of 90
 * degrees when looking in the +y direction and -90 degrees when looking in the -y direction.
 * The origin of the field is considered to be the loading zone for the red human player, or the corner
 * of the field on the same side as the blue goal.
 */

@Config
public class Constants {
    //TODO: Tune these values
    public static final double shooterP = 0;
    public static final double shooterI = 0;
    public static final double shooterD = 0;
    public static final double shooterF = 0;
    public static final double turretP = 0;
    public static final double turretI = 0;
    public static final double turretD = 0;
    public static final double turretF = 0;
    public static final double holdOpenPos = .5;
    public static final double holdClosePos = .75;


    public Constants(boolean alliance){
        isBlueAlliance = alliance;
        if(isBlueAlliance){
            goal = blueGoal;
        }
        else {
            goal = redGoal;
        }
    }
    public static final double shooterVeloTol = 50;
    public static final Pose2d redGoal = new Pose2d(new Translation2d(144, 144), new Rotation2d(0));
    public static final Pose2d blueGoal = new Pose2d(new Translation2d(0, 144), new Rotation2d(0));
    public static Pose2d goal;
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
    public static boolean isBlueAlliance;

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