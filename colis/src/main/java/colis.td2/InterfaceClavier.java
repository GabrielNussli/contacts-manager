package colis.td2;
import java.io.*;
import java.util.*;

public class InterfaceClavier {
    private static Scanner Sc = new Scanner(System.in);
    private static PackFactory p;
    private static ShippingCostCalculator scc = new ShippingCostCalculator();


    public static void main(String[] args) {
        System.out.println("Enter dimensional values in millimeters (Integer), weight in kilogrammes(Double), and the destination to get the corresponding shipping cost");
        while (true) {
            System.out.println("Compute\nExit");
            String cmd = Sc.next();
            if (cmd.toLowerCase().equals("compute")) {
                try {
                    System.out.print("height : ");
                    int height = Integer.parseInt(Sc.next());
                    System.out.println();
                    System.out.print("width : ");
                    int width = Integer.parseInt(Sc.next());
                    System.out.println();
                    System.out.print("depth : ");
                    int depth = Integer.parseInt(Sc.next());
                    System.out.println();
                    System.out.print("weight : ");
                    double weight = Double.parseDouble(Sc.next());
                    System.out.println();
                    p = new PackFactory(height, width, depth, weight);
                    System.out.println("destination : 1 -> FR  2 -> MC  3 -> DOM_TOM");
                    int dest = Integer.parseInt(Sc.next());
                    if (dest == 1)
                        System.out.println("Shipping cost = " + Double.toString(scc.calculateShippingCost(p.pack, ShippingCostCalculator.Destination.FR)));
                    else if (dest == 2)
                        System.out.println("Shipping cost = " + Double.toString(scc.calculateShippingCost(p.pack, ShippingCostCalculator.Destination.MC)));
                    else if (dest == 3)
                        System.out.println("Shipping cost = " + Double.toString(scc.calculateShippingCost(p.pack, ShippingCostCalculator.Destination.DOM_TOM)));
                    else
                        System.out.println("Destination Unknown");
                } catch (java.lang.NumberFormatException e) {
                    System.out.println("Wrong type value detected -> height,width,depth : int  weight : double");
                }
            }
            if (cmd.toLowerCase().equals("exit"))
                break;
        }
    }

}