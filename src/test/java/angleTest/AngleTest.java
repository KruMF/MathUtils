package angleTest;

import mathUtils.coordinates.Cartesian2;

import consoleUtils.ConsoleBuffer;
import static consoleUtils.ConsoleUtils.printLine;
import static consoleUtils.ConsoleUtils.separatorString;
import static consoleUtils.NumberFormatter.doubleToString;

import org.jetbrains.annotations.NotNull;


//TODO: finish this and add javadocs
public class AngleTest {
    private static final String TEST_NAME = "Angle test";

    private static ConsoleBuffer consoleBuffer = new ConsoleBuffer();

    /**
     * Main method of this test.
     *
     * @param args Command-line arguments (none needed nor supported).
     */
    public static void main(String[] args) {
        printLine("Angle test:");
        int dp = 2;
        double val = 1.0;
        addCartesian2D(0, 0, dp);   // center
        addCartesian2D(val, 0, dp);    // 0
        addCartesian2D(val, val, dp);     // 45
        addCartesian2D(0, val, dp);    // 90
        addCartesian2D(-val, val, dp);    // 135
        addCartesian2D(-val, 0, dp);   // 180
        addCartesian2D(-val, -val, dp);   // 225
        addCartesian2D(0, -1, dp);  // 270
        addCartesian2D(val, -val, dp);    // 315
    }

    private static void addCartesian2D(double x, double y, int decimalPlaces) {
        consoleBuffer.addLine(separatorString());
        @NotNull Cartesian2 cartesian = new Cartesian2(x, y);
        double @NotNull [] cartesianArray = cartesian.toArray();
        consoleBuffer.addLine("Cartesian: " +
                "x " + doubleToString(cartesianArray[0], decimalPlaces) + "; " +
                "y " + doubleToString(cartesianArray[1], decimalPlaces));
        double @NotNull [] polarArray = cartesian.toPolar().toArray();
        consoleBuffer.addLine("Polar: " +
                "r " + doubleToString(polarArray[0], decimalPlaces) + "; " +
                "phi " + doubleToString(Math.toDegrees(polarArray[1]), decimalPlaces));
        consoleBuffer.print();
    }
}