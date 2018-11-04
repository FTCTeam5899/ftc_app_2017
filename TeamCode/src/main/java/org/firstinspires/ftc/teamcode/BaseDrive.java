package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class BaseDrive extends LinearOpMode {

        private DcMotor motorFwdLeft;
        private DcMotor motorFwdRight;
        private DcMotor motorBackLeft;
        private DcMotor motorBackRight;

        private static double left;
        private static double right;

        @Override
        public void runOpMode() {

            motorFwdRight = hardwareMap.get(DcMotor.class, "motorFwdRight");
            motorBackLeft = hardwareMap.get(DcMotor.class, "motorBackLeft");
            motorFwdLeft = hardwareMap.get(DcMotor.class, "motorFwdLeft");
            motorBackRight = hardwareMap.get(DcMotor.class, "motorBackRight");

            telemetry.addData("Status", "Initialized");
            telemetry.update();
            // Wait for the game to start (driver presses PLAY)
            waitForStart();

            // run until the end of the match (driver presses STOP)
            while (opModeIsActive()) {

                left = -this.gamepad1.left_stick_y;
                right = this.gamepad1.right_stick_y;

                motorFwdLeft.setPower(left);
                motorFwdRight.setPower(right);
                motorBackLeft.setPower(-left);
                motorBackRight.setPower(-right);

                //telemetry.addData("Nathan Mode", mode);

                telemetry.addData("Status", "Running");
                telemetry.update();

            }
        }
}
