package mathUtils.coordinates.abstraction;

import mathUtils.coordinates.Cartesian3;
import mathUtils.coordinates.Cylindrical;
import mathUtils.coordinates.Spherical;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public abstract class Coordinates3D implements CoordinatesInterface {
    public Coordinates2D basePlane;

    public abstract @NotNull Cartesian3 toCartesian();
    public abstract @NotNull Cylindrical toCylindrical();
    public abstract @NotNull Spherical toSpherical();
}