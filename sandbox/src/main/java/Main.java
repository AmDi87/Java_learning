import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Point P1 = new Point();
        Point P2 = new Point();

        System.out.println("Введите координаты первой точки P1 - a и b");

        Scanner scanner1 = new Scanner(System.in);
        int a = scanner1.nextInt();
        int b = scanner1.nextInt();

        P1.setX(a);
        P1.setY(b);

        System.out.println("Введите координаты первой точки P2 - c и d");

        Scanner scanner2 = new Scanner(System.in);
        int c = scanner2.nextInt();
        int d = scanner2.nextInt();

        P2.setX(c);
        P2.setY(d);

        System.out.println(P1.distance(P2));

    }
}