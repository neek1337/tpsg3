import java.util.HashSet;

public class Collision implements Test {
    double[] numbers;

    Collision(double[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean test() {
        int d = 2;
        int k = 12;

        HashSet<Integer> founded = new HashSet<Integer>();
        int collisions = 0;
        for (int i = 0; i < numbers.length - k; i = i + k) {
            int current = 0;
            for (int j = 0; j < k; j++) {
                current = (current << 1) | (int) Math.floor(numbers[i + j] * d);
            }
            if (founded.contains(current)) {
                collisions++;
            } else {
                founded.add(current);
            }
        }
        return calculateCollisions(numbers.length / k, 1 << k, collisions);
    }

    private boolean calculateCollisions(int n, int m, int x) {
        double[] a = new double[n + 1];
        double EPS = 1e-20;
        a[1] = 1;
        int j0 = 1;
        int j1 = 1;
        for (int i = 0; i < n - 1; i++) {
            j1++;
            for (int j = j1; j >= j0; j--) {
                a[j] = ((double) j / (double) m) * a[j] + ((1 + 1.0 / (double) m) - ((double) j / (double) m)) * a[j - 1];
                if (a[j] < EPS) {
                    a[j] = 0;
                    if (j == j1) {
                        j1--;
                    } else if (j == j0) {
                        j0++;
                    }
                }
            }
        }
        double p = 0;
        int current = 0;
        int i = n;
        while (current < x) {
            i--;
            current++;
            p += a[i];
        }
        if (Math.abs(p - 1) < 1e-10) {
            p = 1;
        }
        System.out.println(p);
        if (p > 0.05 && p < 0.95) {
            return true;
        }
        return false;
    }

}
