package mathUtils;

/**
 * Basic trigonometry.
 */
public class Trigonometry {

    /**
     * Ensures that an angle is within [0; 2 * pi).
     *
     * @param angle An angle to normalize.
     *
     * @return Normalized angle.
     */
    public static double normalizeAngle(double angle) {
        while (angle < 0) {
            angle += Math.PI * 2;
        }
        while (angle >= Math.PI * 2) {
            angle -= Math.PI * 2;
        }
        return angle;
    }

    /**
     * Gets an angle from x and y coordinates.
     *
     * @param x x value.
     * @param y y value.
     *
     * @return Angle.
     */
    public static double getAngle(double x, double y) {
        double correction = getArctangentQuadrantCorrection(x, y);

        if (y == 0) {
            return correction;
        } else if (x == 0) {
            return correction + Math.signum(y) * Math.PI / 2;
        } else {
            return correction + Math.atan(y / x);
        }
    }

    private static double getArctangentQuadrantCorrection(double x, double y) {
        if (x < 0) { // quadrant II & III
            return Math.PI;
        } else if (y < 0) { // quadrant IV
            return Math.PI * 2;
        } else {
            return 0; // quadrant I
        }
    }

    /**
     * Gets an azimuth from radius and height.
     *
     * @param radius Radius (must be positive).
     * @param height Height.
     *
     * @return Azimuth within [-pi / 2; pi / 2].
     */
    public static double getAzimuth(double radius, double height) {
        if (radius == 0) {
            return 0;
        } else {
            return Math.atan(height / radius);
        }
    }
}