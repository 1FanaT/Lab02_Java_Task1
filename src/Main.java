import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість чисел (n): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Кількість чисел має бути більше 0.");
            return;
        }

        int firstPalindrome = -1; // Перше знайдене число-паліндром
        int secondPalindrome = -1; // Друге знайдене число-паліндром
        int countPalindromes = 0; // Кількість знайдених паліндромів

        for (int i = 0; i < n; i++) {
            System.out.print("Введіть число " + (i + 1) + ": ");
            int number = scanner.nextInt();

            if (isPalindrome(number)) {
                if (countPalindromes == 0) {
                    firstPalindrome = number;
                    countPalindromes++;
                } else if (countPalindromes == 1) {
                    secondPalindrome = number;
                    countPalindromes++;
                } else {
                    break; // Якщо знайдено більше двох паліндромів, виходимо з циклу
                }
            }
        }

        if (countPalindromes < 2) {
            System.out.println("Недостатньо чисел-паліндромів для знаходження другого.");
        } else {
            System.out.println("Друге число-паліндром: " + secondPalindrome);
        }
    }

    // Функція для перевірки, чи є число паліндромом
    private static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reverse = 0;

        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number /= 10;
        }

        return originalNumber == reverse;
    }
}
