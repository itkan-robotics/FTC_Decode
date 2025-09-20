package org.firstinspires.ftc.teamcode.opmodes.teleop;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.commands.DriveCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeCommand;
import org.firstinspires.ftc.teamcode.commands.RunClimbCommand;
import org.firstinspires.ftc.teamcode.commands.SetServoCommand;
import org.firstinspires.ftc.teamcode.commands.ShootCommand;
import org.firstinspires.ftc.teamcode.commands.TrackCommand;
import org.firstinspires.ftc.teamcode.commands.UpdateCommand;

public class Solo extends CommandOpMode {
    @Override
    public void initialize() {
        Robot.init(hardwareMap);
        GamepadEx gamepad = new GamepadEx(gamepad1);

        Robot.drive.setDefaultCommand(new DriveCommand(Robot.drive,gamepad));
        Robot.turret.setDefaultCommand(new TrackCommand(Robot.turret, Robot.pinpoint));
        Robot.pinpoint.setDefaultCommand(new UpdateCommand(Robot.pinpoint, Robot.ll));

        new GamepadButton(gamepad, GamepadKeys.Button.DPAD_UP).whenPressed(new RunClimbCommand(Robot.climb, 1)).whenReleased(new RunClimbCommand(Robot.climb, 0));
        new GamepadButton(gamepad, GamepadKeys.Button.DPAD_DOWN).whenPressed(new RunClimbCommand(Robot.climb, -1)).whenReleased(new RunClimbCommand(Robot.climb, 0));
        new GamepadButton(gamepad, GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new IntakeCommand(Robot.intake, -1)).whenReleased(new IntakeCommand(Robot.intake, 0));
        new GamepadButton(gamepad, GamepadKeys.Button.LEFT_BUMPER).whenPressed(new IntakeCommand(Robot.intake, -1)).whenReleased(new IntakeCommand(Robot.intake, 0));
        new GamepadButton(gamepad, GamepadKeys.Button.X).whenPressed(new SetServoCommand(Robot.hold, 0.5)).whenPressed(new IntakeCommand(Robot.intake, -1)).whenReleased(new SetServoCommand(Robot.hold, 0.75)).whenReleased(new IntakeCommand(Robot.intake, 0));
        new GamepadButton(gamepad, GamepadKeys.Button.Y).whenPressed(new ShootCommand(Robot.shooter, Robot.pinpoint));
    }
}
