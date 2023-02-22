package LeetCode;

public class DivideTwoIntegers {

    /*
    https://leetcode.com/problems/divide-two-integers/
     */
    public static void main(String[] args) {
        //System.out.println(divide(7, -3));
        //System.out.println(divide(-1, 1));
        //System.out.println(divide(1, 2));
        System.out.println(divide(-2147483648, 1));
    }

    public static int divide(int dividend, int divisor) {
        long number1 = (dividend < 0) ? dividend * (-1) : dividend;
        long number2 = (divisor < 0) ? divisor * (-1) : divisor;


        if ((dividend == divisor) && (divisor == 1)) return 1;

        if ((dividend == divisor) && (divisor == -1)) return 1;

        if ((dividend == -divisor) || (divisor == -1)) return -1;

        if (number1 < number2) return 0;

        if (number2 == 1) return Math.toIntExact(number1);

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
