public class Interval implements Test {
    double[] numbers;

    Interval(double[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean test() {
        int numberOfIntervals = 10;
        double a = 0.5;
        int current = 0;
        int[] c = new int[numberOfIntervals + 1];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > a) {
                current++;
            } else {
                if (current < numberOfIntervals) {
                    c[current]++;
                } else {
                    c[numberOfIntervals]++;
                }
                current = 0;
            }
        }
        double[] p = new double[numberOfIntervals + 1];
        for (int i = 0; i < numberOfIntervals; i++) {
            p[i] = a * Math.pow(1 - a, i);
        }
        p[numberOfIntervals] = Math.pow(1 - a, numberOfIntervals);

        return ChiSquare.test(c, p,10);
    }
}
