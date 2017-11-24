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

                {191, 123, 18, 2.354, "FR", "12.0"},

                {253, 215, 164, 1.565, "FR", "30.39"},

                {653, 133, 271, 2.132, "FR", "46.09"},

                {653, 331, 271, 3.650, "FR", "83.76"},

                {191, 123, 18, 2.354, "MC", "13.04"},

                {253, 215, 164, 1.565, "MC", "33.03"},

                {653, 133, 271, 2.132, "MC", "50.1"},

                {653, 331, 271, 3.650, "MC", "91.05"}

        });
    }
    private int inputHeight;
    private int inputWidth;
    private int inputDepth;
    private double inputWeight;
    private String inputCountry;
    private String expectedCost;
    public PackTest(int Height, int Width, int Depth, double Weight,String Country, String Cost) {
        inputHeight= Height;
        inputWidth= Width;
        inputDepth=Depth;
        inputWeight=Weight;
        inputCountry=Country;
        expectedCost=Cost;
    }

    @Test
    public void test() {
        Pack pack=new Pack(inputHeight,inputWidth,inputDepth,inputWeight);
        ShippingCostCalculator sc = new ShippingCostCalculator();
        double cost = 0.0;
        if(inputCountry.matches("MC"))
            cost = sc.calculateShippingCost(pack, ShippingCostCalculator.Destination.MC);
        else if(inputCountry.matches("FR"))
            cost = sc.calculateShippingCost(pack, ShippingCostCalculator.Destination.FR);

        assertEquals(expectedCost, Double.toString(cost));
    }
}
