package strings.Medium.array;

public class ReverseANumber {

    public static int reverseTheNumber(int number) {
        int sum = 0;

        while (number != 0) {

            int rem = number % 10;
            number = number / 10;
            sum = sum * 10 + rem;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(reverseTheNumber(12345));
    }
}
