package colis.td2;

public class MediumPack extends Pack {
    public MediumPack(int height, int width, int depth, double weight) {
        super(height, width, depth, weight);
    }
    public double calculateLocalShippingCost(){
        return round(17.59*this.weight + 2.86,2);
    }
}
