import javafx.util.Pair;

import java.util.HashMap;

public class ChiSquare implements Test {
    double[] numbers;
    public static HashMap<Integer, Pair<Double, Double>> chiTable;

    ChiSquare(double[] numbers) {
        this.numbers = numbers;
        chiTable = new HashMap<Integer, Pair<Double, Double>>();
        chiTable.put(6, new Pair<Double, Double>(1.6354, 12.596));
        chiTable.put(9, new Pair<Double, Double>(3.3251, 16.9190));
        chiTable.put(10, new Pair<Double, Double>(3.9403, 18.3070));

    }

    public static boolean test(int[] c, double[] p, int vertexOfFreedom) {
        double chiSquare = 0;
        int n = 0;
        for (int i : c) {
            n += i;
        }
        for (int i = 0; i < c.length; i++) {
            chiSquare += (c[i] - n * p[i]) * (c[i] - n * p[i]) / (n * p[i]);
        }
        System.out.println(chiSquare);
        if (chiSquare < chiTable.get(vertexOfFreedom).getValue() && chiSquare > chiTable.get(vertexOfFreedom).getKey()) {
            return true;
        }
        return false;
    }

    public static boolean test(int[] c, double p, Integer vertexOfFreedom) {
        double chiSquare = 0;
        int n = 0;
        for (int i : c) {
            n += i;
        }
        for (int i = 0; i < c.length; i++) {
            chiSquare += (c[i] - n * p) * (c[i] - n * p) / (n * p);
        }
        System.out.println(chiSquare);
        if (chiSquare < chiTable.get(vertexOfFreedom).getValue() && chiSquare > chiTable.get(vertexOfFreedom).getKey()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean test() {
        int d = 10;
        int c[] = new int[d];
        double p = 1.0 / d;
        for (int i = 0; i < numbers.length; i++) {
            c[((int) Math.floor(numbers[i] * d))]++;
        }
        int n = numbers.length;
        double chiSquare = 0;
        for (int i = 0; i < d; i++) {
            chiSquare += (c[i] - n * p) * (c[i] - n * p) / (n * p);
        }
        System.out.println(chiSquare);
        if (chiSquare < 18.3070 && chiSquare > 3.9403) {
            return true;
        }
        return false;
    }
}
