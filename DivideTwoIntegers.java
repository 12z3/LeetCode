package LeetCode;

public class DivideTwoIntegers {

    /*
    https://leetcode.com/problems/divide-two-integers/
     */
    public static void main(String[] args) {
        //System.out.println(divide(7, -3));
        //System.out.println(divide(1, -1));
        //System.out.println(divide(1, 2));
        System.out.println(divide(-2147483648, -1));
    }

    public static int divide(int dividend, int divisor) {
        long number1 = dividend;
        long number2 = divisor;
        number1 = (dividend < 0) ? Math.abs(number1) : dividend;
        number2 = (divisor < 0) ? Math.abs(number2) : divisor;


        //if ((number1 == number2) && ((divisor == 1) || (divisor == -1))) return 1;   // -1 / -1

        //if ((dividend == -divisor) || (divisor == -1)) return -1;

        if (number1 < number2) return 0;

        if (divisor == 1 && (dividend < 0)) {
            return dividend;
        } else if (divisor == -1 && (dividend < 0)) {
            return Math.toIntExact(number1);
        } else if (divisor == 1 && (dividend == 1)) {
            return 1;
        } else if (divisor == -1 && (dividend > 0)) {
            return -dividend;
        }

        long number = number2;
        int count = 0;
        while (number > 1) {
            number = number1 - number2;
            number1 = number;
            count++;
        }
        return ((divisor < 0) || (dividend < 0)) ? -count : count;
    }
}
