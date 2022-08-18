package contacts;

import java.util.Scanner;

public class Input {
    public int getInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int userNumber = scanner.nextInt();
        if (userNumber < min || userNumber > max) {
            return getInt(min, max);
        }
        return userNumber;
    }
}
