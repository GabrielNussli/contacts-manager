package colis.td2;

public class BigPack extends Pack{
    public BigPack(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }
    public double calculateLocalShippingCost(){
        return round( Double.max(weight*21.62, 1.43*height*width*depth/1000000),2);
    }
}
