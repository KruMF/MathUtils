package mathUtils.coordinates;

import mathUtils.Trigonometry;
import mathUtils.coordinates.abstraction.Coordinates2D;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Cartesian2 extends Coordinates2D {
    public double x, y;

    public Cartesian2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double @NotNull [] toArray() {
        return new double[] {x, y};
    }

    @Override
    public @NotNull Cartesian2 toCartesian() {
        return this;
    }

    @Override
    public @NotNull Polar toPolar() {
        double  r = Math.hypot(x, y),
                phi = Trigonometry.getAngle(x, y);
        return new Polar(r, phi);
    }
}