import java.util.HashSet;

public class Partition implements Test {
    double[] numbers;

    Partition(double[] numbers) {
        this.numbers = numbers;
    }


    @Override
    public boolean test() {
        int d = 10;
        int k = 6;
        int[] c = new int[k];
        double[] p = new double[k];
        for (int i = 0; i < numbers.length - k; i = i + k) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int j = 0; j < k; j++) {
                hashSet.add((int) Math.floor(numbers[i + j] * d));
            }
            c[hashSet.size() - 1]++;
        }
        double l=0,sum = 0;
        int f = 0;
        for (int i = 1; i <=k; i++) {
            double pi = 1;
            for (int j = d; j >= d - i + 1; j--) {
                pi *= j;
            }
            p[i-1] = pi / Math.pow(d, k) * S(k, i);
            if (l < 0.05) {
                l += p[i-1];
                f = i;
            }
            sum+=p[i-1];
        }
        int[] c1 = new int[k - f+1];
        double[] p1 = new double[k - f+1];
        for (int i = 0; i <f; i++) {
            c1[0]+=c[i];
            p1[0]+=p[i];
        }
        for (int i = 0; i <k - f; i++) {
            c1[i+1] = c[i + f];
            p1[i+1] = p[i + f];
        }
        return ChiSquare.test(c1, p1, k);
    }

    private double S(int n, int k) {
        if (n == k) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        return S(n - 1, k - 1) + k * S(n - 1, k);
    }
}
