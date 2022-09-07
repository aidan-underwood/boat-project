package frc.robot;

/**
 * Constants file.
 */

public final class Constants {
    public static final double stickDeadband = 0.1;
    public static final int driverID = 0;
    public static final int operatorID = 1;

    /**
     * Motor CAN id's.
     */
    public static final class Motors {
        public static final int leftFront = 2;
        public static final int leftBack = 3;
        public static final int rightFront = 1;
        public static final int rightBack = 4;
    }

    /**
     * Pneumatics CAN id constants.
     */
    public static final class Pneumatics {
        public static final int forwardChan = 4;
        public static final int reverseChan = 3;
    }
}
