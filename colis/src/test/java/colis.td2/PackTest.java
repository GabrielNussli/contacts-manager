package colis.td2;

import static org.junit.Assert.assertEquals;

import java.math.MathContext;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PackTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{

                {191, 123, 18, 2.354, ShippingCostCalculator.Destination.FR, "12.0"},

                {253, 215, 164, 1.565, ShippingCostCalculator.Destination.FR, "30.39"},

                {653, 133, 271, 2.132, ShippingCostCalculator.Destination.FR, "46.09"},

                {653, 331, 271, 3.650, ShippingCostCalculator.Destination.FR, "83.76"},

                {191, 123, 18, 2.354, ShippingCostCalculator.Destination.MC, "13.04"},

                {253, 215, 164, 1.565, ShippingCostCalculator.Destination.MC, "33.03"},

                {653, 133, 271, 2.132, ShippingCostCalculator.Destination.MC, "50.1"},

                {653, 331, 271, 3.650, ShippingCostCalculator.Destination.MC, "91.05"},

                {191, 123, 18, 2.354, ShippingCostCalculator.Destination.DOM_TOM, "13.91"},

                {253, 215, 164, 1.565, ShippingCostCalculator.Destination.DOM_TOM, "33.29"},

                {653, 133, 271, 2.132, ShippingCostCalculator.Destination.DOM_TOM, "49.84"},

                {653, 331, 271, 3.650, ShippingCostCalculator.Destination.DOM_TOM, "89.54"}

        });
    }
    private int inputHeight;
    private int inputWidth;
    private int inputDepth;
    private double inputWeight;
    private ShippingCostCalculator.Destination inputCountry;
    private String expectedCost;
    public PackTest(int Height, int Width, int Depth, double Weight,ShippingCostCalculator.Destination Country, String Cost) {
        inputHeight= Height;
        inputWidth= Width;
        inputDepth=Depth;
        inputWeight=Weight;
        inputCountry=Country;
        expectedCost=Cost;
    }

    @Test
    public void test() {

        PackFactory packF=new PackFactory(inputHeight,inputWidth,inputDepth,inputWeight);
        ShippingCostCalculator sc = new ShippingCostCalculator();
        assertEquals(expectedCost, Double.toString(sc.calculateShippingCost(packF.pack, inputCountry)));
    }
}
