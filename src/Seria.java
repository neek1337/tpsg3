public class Seria implements Test {
    double[] numbers;

    Seria(double[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean test() {
        int d = 3;
        int pairs[] = new int[d * d];
        double p = 1.00 / (d * d);
        for (int i = 0; i < numbers.length; i = i + 2) {
            pairs[((int) (Math.floor(numbers[i] * d) * d + Math.floor(numbers[i + 1] * d)))]++;
        }
        return ChiSquare.test(pairs, p, d*d);
    }
}
