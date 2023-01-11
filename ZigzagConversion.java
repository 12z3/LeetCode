package LeetCode;

import training.Methods;

public class ZigzagConversion extends Methods {

    // "fbmafwsahcpwthjqmajrtlaykcwidwoixcifadfjfwgafrquscllpmlaoiktgacgdmlfpsrwozxvqppir"  -> Time Limit Exceeded

    // PAYPALISHIRING
    // PAHNAPLSIIGYIR  char[3][7]

    // PAYPALISHIRING
    // PINALSIGYAHRPI  char[4][7]


    public static void main(String[] args) {

        String line1 = "PAYPALISHIRING";
        String line = "fbmafwsahcpwthjqmajrtlaykcwidwoixcifadfjfwgafrquscllpmlaoiktgacgdmlfpsrwozxvqppir";
        String line2 = "AB"; // 1
        System.out.println(line);
        System.out.println(convert(line, 76));

        // compareWords(convert(line,4),"PINALSIGYAHRPI");
    }

    public static String convert(String s, int numRows) {
        char el = '-';
        int r = 0, c = 0, i = 0, count = 0, col = 0;
        if (numRows == 1) return s;

        if (s.length() == 1) {
            col = 1;
        } else {
            col = (s.length() + numRows);
        }

        boolean isBreak = false;
        char[][] arr = new char[numRows][col];
        StringBuilder tmp = new StringBuilder();

        while (count < s.length()) {
            while (r <= arr.length - 1) {
                el = s.charAt(i);
                arr[r++][c] = el;
                i++;
                count++;
                if (count > s.length() - 1) {
                    isBreak = true;
                    break;
                }
            }
            r--;
            while (r > 0) {
                if (isBreak) break;
                //if (r == numRows) r -= numRows - 1;
                el = s.charAt(i);
                arr[--r][++c] = el;
                i++;
                count++;
                if (count > s.length() - 1) break;

            }
            r++;
        }

        for (int rowS = 0; rowS < arr.length; rowS++) {
            for (int colS = 0; colS < arr[rowS].length; colS++) {
                if (arr[rowS][colS] == 0) {
                    arr[rowS][colS] = ' ';
                }
                if (arr[rowS][colS] != ' ') tmp.append(arr[rowS][colS]);
                System.out.print(arr[rowS][colS]);
            }
            System.out.println();
        }

        return tmp.toString();
    }
}


//---------------------------------------------------------------------------------

//    public static String convert(String s, int numRows) {
//        char el = '-';
//        int r = 0, c = 0, i = 0, count = 0, col = 0;
//
//        if (s.length() == 1) {
//            col = 1;
//        } else {
//            col = (s.length() - 1) - numRows;
//        }
//
//        boolean isBreak = false;
//        char[][] arr = new char[numRows][col];
//        StringBuilder tmp = new StringBuilder();
//
//        while (count < s.length()) {
//            while (r <= arr.length - 1) {
//                el = s.charAt(i);
//                arr[r++][c] = el;
//                i++;
//                count++;
//                if (count > s.length() - 1) {
//                    isBreak = true;
//                    break;
//                }
//            }
//
//            while (r >= 0) {
//                if (isBreak) break;
//                if (r == numRows) r -= numRows - 1;
//                el = s.charAt(i);
//                arr[r--][++c] = el;
//                i++;
//                count++;
//                if (count > s.length() - 1) break;
//
//            }
//            r += numRows - 1;
//        }
//
//        for (int rowS = 0; rowS < arr.length; rowS++) {
//            for (int colS = 0; colS < arr[rowS].length; colS++) {
//                if (arr[rowS][colS] == 0) {
//                    arr[rowS][colS] = ' ';
//                }
//                if (arr[rowS][colS] != ' ') tmp.append(arr[rowS][colS]);
//                System.out.print(arr[rowS][colS]);
//            }
//            System.out.println();
//        }
//
//        return tmp.toString();
//    }
//}


//        for (int i = 0; i < line.length(); i++) {
//            el = line.charAt(i);
//            arr[r++][c] = el;
//
//            if (r > 2) {
//                r-= 2;
//                i = i + 1;
//                el = line.charAt(i);
//                arr[r--][++c] = el;
//                while (r > 0){
//                    i = i + 1;
//                    el = line.charAt(i);
//                    arr[r--][++c] = el;
//                }
//            }
//        }


//        for (int i = 0, j = 0; count < line.length(); i += 4) {
//            el = line.charAt(i);
//            tmp.append(el);
//
//            if (i + 4 > line.length() - 1) countCircle++;
//            if (i + 4 > line.length() - 1) {
//                i = (line.length() - 1 - i) - (4 + 1) + countCircle;
//            }
//            count++;
//
//
//        }
//        System.out.println(tmp);


//        int col = 0, row = 0, i = 0, j = 0;
//        while (i < line.length()) {
//            char el = line.charAt(i);
//            if (j < arr.length) {
//                arr[row++][col] = el;
//            } else if (row > 1) {
//                row -= 2;
//                col = 1;
//                arr[row][col] = el;
//            } else if (row >= 0) {
//                row--;
//                col++;
//                arr[row][col] = el;
//                //j = 0;
//                row ++;
//                col--;
//
//            }
//            i++;
//            j++;
//        }
//
//        for (int rowS = 0; rowS < arr.length; rowS++) {
//            for (int colS = 0; colS < arr[rowS].length; colS++) {
//                if (arr[rowS][colS] == 0) arr[rowS][colS] = ' ';
//                System.out.print(arr[rowS][colS]);
//            }
//            System.out.println();
//        }

//    int col = 0, row = 0, i = 0, j = 0;
//        while (i < line.length()) {
//        char el = line.charAt(i);
//        if (j < arr.length) {
//        arr[row++][col] = el;
//        } else if (row > 2) {
//        row -= 2;
//        col = 1;
//        arr[row][col] = el;
//        } else if (row >= 0) {
//        row--;
//        col++;
//        arr[row][col] = el;
//        j = -1;
//        }
//        i++;
//        j++;
//        }