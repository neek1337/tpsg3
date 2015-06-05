public class Permutation implements Test {
    double[] numbers;

    Permutation(double[] numbers) {
        this.numbers = numbers;
    }

    int numberOfPermutation(int[] permutation) {
        int result = 0;
        int currentSize = permutation.length;
        while (currentSize > 0) {
            int minIndex = 0;
            for (int i = 1; i < currentSize; i++) {
                if (permutation[i] < permutation[minIndex]) {
                    minIndex = i;
                }
            }
            result = result * currentSize + minIndex;
            int local = permutation[currentSize - 1];
            permutation[currentSize - 1] = permutation[minIndex];
            permutation[minIndex] = local;
            currentSize--;
        }
        return result;
    }

    @Override
    public boolean test() {
        int d = 1000;
        int k = 3;
        int cSize = 1;
        for (int i = 2; i <=k; i++) {
            cSize *= i;
        }
        int c[] = new int[cSize];
        for (int i = 0; i < numbers.length - k; i = i + k) {
            int[] mas = new int[k];
            for (int j = 0; j < k; j++) {
                mas[j] = (int) Math.floor(numbers[i + j] * d);
            }
            c[numberOfPermutation(mas)]++;
        }
        double p = 1.00/ cSize;
        return ChiSquare.test(c, p, cSize);
    }
}
