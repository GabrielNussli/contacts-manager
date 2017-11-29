package colis.td2;

public class PackFactory {

    protected Pack pack ;

    public PackFactory(int height, int width, int depth, double weight){
        if(height < 229 && width < 162 && depth < 25)
            pack = new SmallPack(height,width,depth,weight);
        else if (weight < 1.8)
            pack = new MediumPack(height, width, depth, weight);
        else
            pack = new BigPack(height, width, depth, weight);
    }
}
