package colis.td2;

public class ShippingCostCalculator {
    public enum Destination {FR,MC,DOM_TOM;}
    public double calculateShippingCost(Pack pack, Destination destination){

        if(Destination.MC.equals(destination))
            return Pack.round(pack.calculateLocalShippingCost()*1.087,2);
        else if(Destination.FR.equals(destination))
            return Pack.round(pack.calculateLocalShippingCost(),2);
        else if(Destination.DOM_TOM.equals(destination))
            return Pack.round(pack.calculateLocalShippingCost()*1.054+1.26,2);
        return Double.MAX_VALUE;
    }
}
