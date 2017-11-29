package colis.td2;
import java.lang.Double;
import java.math.* ;

public abstract class Pack {
    protected int height;
    protected int width;
    protected int depth;
    protected double weight;

    public Pack(int height, int width, int depth, double weight) {
        this.height=height;
        this.width=width;
        this.depth=depth;
        this.weight=weight;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public abstract double calculateLocalShippingCost();
}
