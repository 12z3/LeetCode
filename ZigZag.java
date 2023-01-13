package task;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    /**
     * @Source: https://www.nileshblog.tech/2022/04/leet-code-zigzag-
     * conversion-solution-c-java-python-javascript-swift-typescript/
     * @Problem: The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     *
     * Подход 1: Сортиране по ред
     * Интуицията
     *
     * Чрез итерация през низа отляво надясно можем лесно да определим към кой ред в зиг-заг модела принадлежи даден знак.
    
     * Подход 2: Посещение по ред
     * Интуицията
     *
     * Посетете знаците в същия ред, както четете зиг-заг модела ред по ред.
     */
    public static void main(String[] args) {

        String s = "PAYPALISHIRING";
        int numRows = 3;

        System.out.println(zizag(s, 3));
        System.out.println(convert(s, 3));
    }

    public static String zizag(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
