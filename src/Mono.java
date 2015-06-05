public class Mono implements Test {
    double[] numbers;

    Mono(double[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean test() {
        double[][] A = {
                {4529.4, 9044.9, 13568, 18091, 22615, 27892},
                {9044.9, 18097, 27139, 36187, 45234, 55789},
                {13568, 27139, 40721, 54281, 67852, 83685},
                {18091, 36187, 54281, 72414, 90470, 111580},
                {22615, 45234, 67852, 90470, 113262, 139476},
                {27892, 55789, 83685, 111580, 139476, 172860}};
        double[] B = {1.00 / 6, 5.00 / 24, 11.00 / 120, 19.00 / 720, 29.00 / 5040, 1.00 / 840};
        int d = 6;
        int[] c = new int[d];
        int current = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                current++;
            } else {
                if (current < d) {
                    c[current - 1]++;
                } else {
                    c[d - 1]++;
                }
                current = 1;
            }
        }
        if (current < d - 1) {
            c[current]++;
        } else {
            c[d - 1]++;
        }
        double chiSquare = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                chiSquare += (c[i] - numbers.length * B[i]) * (c[j] - numbers.length * B[j]) * A[i][j];
            }
        }
        chiSquare = chiSquare / (numbers.length - d);

        System.out.println(chiSquare);
        if (chiSquare > ChiSquare.chiTable.get(6).getKey() && chiSquare < ChiSquare.chiTable.get(6).getValue()) {
            return true;
        }
        return false;

    }
}
