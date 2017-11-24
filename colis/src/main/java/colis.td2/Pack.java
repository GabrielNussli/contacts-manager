package colis.td2;
import java.lang.Double;
import java.math.* ;

public class Pack {
    private int height;
    private int width;
    private int depth;
    private double weight;

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

    public double calculateLocalShippingCost(){
        double cout;
        if(height <= 229 && width <= 162 && depth<= 25)
            cout = 12.00;
        else {
            if(weight < 1.8)
                cout = 17.59*weight + 2.86;
            else
                cout = Double.max(weight*21.62, 1.43*height*width*depth/1000000);
        }
        return round(cout,2);
    }
}
