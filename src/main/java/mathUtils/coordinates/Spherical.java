package mathUtils.coordinates;

import mathUtils.Trigonometry;
import mathUtils.coordinates.abstraction.Coordinates3D;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Spherical extends Coordinates3D {
    public double theta;

    public Spherical(@NotNull Polar basePlane, double theta) {
        this.basePlane = basePlane;
        this.theta = Trigonometry.normalizeAngle(theta);
    }

    public Spherical(double r, double phi, double theta) {
        this(new Polar(r, phi), theta);
    }

    @Override
    public double @NotNull [] toArray() {
        double @NotNull [] basePlaneArray = basePlane.toArray();
        return new double[] {basePlaneArray[0], basePlaneArray[1], theta};
    }

    @Override
    public @NotNull Cartesian3 toCartesian() {
        return new Cartesian3(basePlane.toCartesian(), getZ());
    }

    @Override
    public @NotNull Cylindrical toCylindrical() {
        return new Cylindrical(basePlane.toPolar(), getZ());
    }

    private double getZ() {
        return basePlane.toPolar().r * Math.sin(theta);
    }

    @Override
    public @NotNull Spherical toSpherical() {
        return this;
    }
}