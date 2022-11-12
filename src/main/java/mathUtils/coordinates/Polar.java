package mathUtils.coordinates;

import mathUtils.Trigonometry;
import mathUtils.coordinates.abstraction.Coordinates2D;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Polar extends Coordinates2D {
    public double r, phi;

    public Polar(double r, double phi) {
        this.r = r;
        this.phi = Trigonometry.normalizeAngle(phi);
    }

    @Override
    public double @NotNull [] toArray() {
        return new double[] {r, phi};
    }

    @Override
    public @NotNull Cartesian2 toCartesian() {
        double  x = r * Math.cos(phi),
                y = r * Math.sin(phi);
        return new Cartesian2(x, y);
    }

    @Override
    public @NotNull Polar toPolar() {
        return this;
    }
}