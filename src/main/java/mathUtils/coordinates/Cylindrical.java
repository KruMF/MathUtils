package mathUtils.coordinates;

import mathUtils.Trigonometry;
import mathUtils.coordinates.abstraction.Coordinates3D;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public class Cylindrical extends Coordinates3D {
    public double z;

    public Cylindrical(@NotNull Polar basePlane, double z) {
        this.basePlane = basePlane;
        this.z = z;
    }

    public Cylindrical(double r, double phi, double z) {
        this(new Polar(r, phi), z);
    }

    @Override
    public double @NotNull [] toArray() {
        double @NotNull [] basePlaneArray = basePlane.toArray();
        return new double[] {basePlaneArray[0], basePlaneArray[1], z};
    }

    @Override
    public @NotNull Cartesian3 toCartesian() {
        return new Cartesian3(basePlane.toCartesian(), z);
    }

    @Override
    public @NotNull Cylindrical toCylindrical() {
        return this;
    }

    @Override
    public @NotNull Spherical toSpherical() {
        @NotNull Polar basePlanePolar = basePlane.toPolar();
        return new Spherical(
                basePlanePolar,
                Trigonometry.getAzimuth(basePlanePolar.r, z)); //theta
    }
}