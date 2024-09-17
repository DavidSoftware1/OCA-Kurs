import java.util.Scanner;

public class Helper {
    static Scanner sc = new Scanner(System.in);


    public static String getStringInput(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public static int getIntInput(String msg) {
        System.out.println(msg);
        return Integer.parseInt(sc.nextLine());
    }
}
