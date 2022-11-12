package mathUtils.coordinates.abstraction;

import mathUtils.coordinates.Cartesian2;
import mathUtils.coordinates.Polar;
import org.jetbrains.annotations.NotNull;

//TODO: add javadocs
public abstract class Coordinates2D implements CoordinatesInterface {
    public abstract @NotNull Cartesian2 toCartesian();
    public abstract @NotNull Polar toPolar();
}