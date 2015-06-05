import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Info info = new Info(args);


        info.fileName = "output.txt";
        File file = new File(info.fileName);
        double[] numbers = readNumbers(info.fileName);
        ChiSquare chiSquare = new ChiSquare(numbers);
        System.out.println("Хи-квадрат");
        System.out.println(chiSquare.test());
        Seria seria = new Seria(numbers);
        System.out.println("Серии");
        System.out.println(seria.test());
        Interval interval = new Interval(numbers);
        System.out.println("Интервалы");
        System.out.println(interval.test());
        Partition partition = new Partition(numbers);
        System.out.println("Разбиение");
        System.out.println(partition.test());
        Permutation permutation = new Permutation(numbers);
        System.out.println("Перестановки");
        System.out.println(permutation.test());
        Mono mono = new Mono(numbers);
        System.out.println("Монотонности");
        System.out.println(mono.test());
        Collision collision = new Collision(numbers);
        System.out.println("Конфликты");
        System.out.println(collision.test());
    }

    public static double[] readNumbers(String file) {
        try {
            Scanner scanner = new Scanner(new File(file));
            ArrayList<Double> list = new ArrayList<Double>();
            while (scanner.hasNext()) {
                list.add(Double.valueOf(scanner.next()));
            }
            double[] result = new double[list.size()];
            for (int i = 0; i < result.length; i++) {
                result[i] = list.get(i);
            }
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Имя файла ввидено неверно");
        }
        return null;
    }
}
