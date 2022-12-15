import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static int isRoman(String first) {

        String[] roman = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        for (int i = 0; i < roman.length; i++) {

            if (first.equals(roman[i])) {

                int firstRoman = i + 1;
                return firstRoman;
            }
        }
        return 0;
    }

    public static String romanToArabian(int result) {

        String[] roman = {
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        if (result < 0) {
            throw new RuntimeException("Результатом работы калькулятора с римскими числами могут быть только положительные числа.");
        } else return roman[result - 1];
    }

    public static int Calculator(int a, String operation, int b) {

        int result = 0;

        switch (operation) {

            case "-":
                result = a - b;
                break;
            case "+":
                result = a + b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new NumberFormatException("Такой операции нет.");
        }
        return result;
    }

    public static String calc(String input) {

        String[] parts = input.split(" ");

        String result = null;
        String first = parts[0];
        String operation = parts[1];
        String second = parts[2];

        if (isRoman(first) != 0 && isRoman(second) == 0 || isRoman(first) == 0 && isRoman(second) != 0) {
            throw new NumberFormatException("Вы ввели арабские цифры вместе с римскими. Либо некоректные арабские цифры.");
        } else if (isRoman(first) > 10 || isRoman(second) > 10) {
            throw new NumberFormatException("Вы ввели римскую цифру превышающую значение 10.");
        } else if (isRoman(first) != 0 && isRoman(second) != 0) {
            result = (romanToArabian(Calculator(isRoman(first), operation, isRoman(second))));
        } else if (isRoman(first) == 0 && isRoman(second) == 0) {

            int a = Integer.parseInt(first);
            int b = Integer.parseInt(second);

            if (a > 10 || b > 10) {
                throw new NumberFormatException("Введено число больше 10.");
            } else if (parts.length != 3) {
                throw new NumberFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
            } else result = Integer.toString(Calculator(a, operation, b));
        }
        if (result == null) {
            throw new NumberFormatException("Ошибка");
        }
        return result;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите два числа (арабских или римских) и между ними операцию в формате: X - I или 10 - 1");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }
}
