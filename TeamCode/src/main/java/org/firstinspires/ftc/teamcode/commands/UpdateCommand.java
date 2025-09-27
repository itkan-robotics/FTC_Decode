package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.hardware.limelightvision.LLResult;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.subsystems.LimelightSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.PinpointSubsystem;

public class UpdateCommand extends CommandBase {
    PinpointSubsystem pinpoint;
    LimelightSubsystem ll;

    public UpdateCommand(PinpointSubsystem pinpoint, LimelightSubsystem ll) {
        this.pinpoint = pinpoint;
        this.ll = ll;
    }

    @Override
    public void execute() {
        ll.get().updateRobotOrientation(Math.toDegrees(pinpoint.getPose().getHeading()));
        LLResult result = ll.get().getLatestResult();
        if (result != null) {
            if (result.isValid()) {
                Pose3D botpose = result.getBotpose_MT2();
                pinpoint.setup(botpose.getPosition().x, botpose.getPosition().y, pinpoint.getPose().getHeading());
            }
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
