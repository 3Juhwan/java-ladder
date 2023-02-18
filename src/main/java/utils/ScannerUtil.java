package utils;

import java.util.Scanner;

public class ScannerUtil {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String nextLine() {

        return SCANNER.nextLine();
    }

    public static int nextInt() {

        return SCANNER.nextInt();
    }
}
