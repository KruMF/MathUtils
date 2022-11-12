package mathUtils.coordinates;

import mathUtils.Trigonometry;
import mathUtils.coordinates.abstraction.Coordinates3D;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Cartesian3 extends Coordinates3D {
    public double z;

    public Cartesian3(@NotNull Cartesian2 basePlane, double z) {
        this.basePlane = basePlane;
        this.z = z;
    }

    public Cartesian3(double x, double y, double z) {
        this(new Cartesian2(x, y), z);
    }

    @Override
    public double @NotNull [] toArray() {
        double @NotNull [] basePlaneArray = basePlane.toArray();
        return new double[] {basePlaneArray[0], basePlaneArray[1], z};
    }

    @Override
    public @NotNull Cartesian3 toCartesian() {
        return this;
    }

    @Override
    public @NotNull Cylindrical toCylindrical() {
        return new Cylindrical(basePlane.toPolar(), z);
    }

    @Override
    public @NotNull Spherical toSpherical() {
        @NotNull Polar basePlanePolar = basePlane.toPolar();
        return new Spherical(
                basePlanePolar,
                Trigonometry.getAzimuth(basePlanePolar.r, z)); // theta
    }
}