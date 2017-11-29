package colis.td2;

public class SmallPack extends Pack {
    public SmallPack(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }

    public double calculateLocalShippingCost(){
        return 12.00;
    }
}
