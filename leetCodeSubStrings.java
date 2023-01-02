package task;

import java.util.ArrayList;
import java.util.List;

public class leetCodeSubStrings {

    //TODO: Time Limit Exceeded
    // https://leetcode.com/problems/longest-palindromic-substring/description/

    public static void main(String[] args) {
        String x4 = "bappabad";
        String x1 = "cbbd";
        String x8 = "aacabdkacaa";
        String x5 = "ac";
        String x6 = "babad";
        String x7 = "ccc";
        String x9 = "xaabacxcabaaxcabaax";
        String x = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(palindromsLeetCode(x));


        /**
         *  Взима 1-та буква
         *  Проверява дали indexOf("нея") != -1
         *  Ако "Да" -> for(позицията на буквата до резултата от indexOf("нея") + 1)
         *  Генерира се StringBuilder, който проверяваме, че е палиндромен.
         *
         */
    }

    private static String palindromsLeetCode(String s) {
        StringBuilder stb = new StringBuilder();
        StringBuilder stbR;
        StringBuilder stbL;
        List<StringBuilder> stbAll = new ArrayList<>();
        int idxFrom = 0, index = 0, max = 0;
        boolean isMatch = false;


        if (s.length() == 1) return s;

        StringBuilder tmp = new StringBuilder();
        StringBuilder tmp1 = new StringBuilder(s);
        for (int i = s.length() - 1; i >= 0; i--) {
            tmp.append(tmp1.charAt(i));
        }
        if (tmp1.toString().equalsIgnoreCase(tmp.toString())) return tmp.toString();

        int indexX = 0, p = 0;
        while (indexX < s.length()) {                               // xaabacxcabaaxcabaax
            idxFrom = indexX;
            for (int i = 0; i < s.length(); i++) {
                char y = s.charAt(p);

                if (s.indexOf(y, idxFrom) != -1) {
                    int idx = s.indexOf(y, idxFrom);
                    stbR = new StringBuilder(s.substring(p, idx + 1));
                    stbL = new StringBuilder();
                    idxFrom = idx + 1;

                    for (int j = stbR.length() - 1; j >= 0; j--) {
                        stbL.append(stbR.charAt(j));
                    }
                    if (stbR.toString().equalsIgnoreCase(stbL.toString())) {
                        stbAll.add(stbR);
                        isMatch = true;
                    }
                }
            }
            p++;
            indexX++;
        }

        if (isMatch) {
            for (int i = 0; i < stbAll.size(); i++) {
                if (stbAll.get(i).length() > max) {
                    max = stbAll.get(i).length();
                    index = i;
                }
            }
            return stbAll.get(index).toString();
        }
        return String.valueOf(s.charAt(0));
    }

//    private static String palindromsLeetCode2(String s) {
//        StringBuilder stb = new StringBuilder();
//        StringBuilder stbR;
//        StringBuilder stbL;
//        List<StringBuilder> stbAll = new ArrayList<>();
//        int idxFrom = 0, index = 0, max = 0;
//        boolean isMatch = false;
//
//
//        if (s.length() == 1) return s;
//
//        StringBuilder tmp = new StringBuilder();
//        StringBuilder tmp1 = new StringBuilder(s);
//        for (int i = s.length() - 1; i >= 0; i--) {
//            tmp.append(tmp1.charAt(i));
//        }
//        if (tmp1.toString().equalsIgnoreCase(tmp.toString())) return tmp.toString();
//
//
//        int indexX = 0;
//        while (indexX < s.length()){
//
//
//
//            indexX++;
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            char y = s.charAt(i);
//
//            idxFrom = i + 1;
//            if (s.indexOf(y, idxFrom) != -1) {
//                int idx = s.indexOf(y, idxFrom);
//                stbR = new StringBuilder(s.substring(i, idx + 1));
//                stbL = new StringBuilder();
//
//                for (int j = stbR.length() - 1; j >= 0; j--) {
//                    stbL.append(stbR.charAt(j));
//                }
//                if (stbR.toString().equalsIgnoreCase(stbL.toString())) {
//                    stbAll.add(stbR);
//                    isMatch = true;
//                }
//            }
//        }
//
//        if (isMatch) {
//            for (int i = 0; i < stbAll.size(); i++) {
//                if (stbAll.get(i).length() > max) {
//                    max = stbAll.get(i).length();
//                    index = i;
//                }
//            }
//            return stbAll.get(index).toString();
//        }
//        return String.valueOf(s.charAt(0));
//    }


//    private static String palindromsLeetCode1(String s) {
//        StringBuilder stb = new StringBuilder();
//        StringBuilder stbR;
//        StringBuilder stbL = new StringBuilder();
//
//
//        if (s.length() == 1) return s;
//        for (int i = 0; i < s.length(); i++) {                     // aacabdkacaa
//            stb.append(s.charAt(i));
//            char y = stb.charAt(i);
//            if (s.lastIndexOf(y) != -1 && s.lastIndexOf(y) != i) {
//                int idx = s.lastIndexOf(y);
//                stbR = new StringBuilder(s.substring(i, idx + 1));
//
//                for (int j = stbR.length() - 1; j >= 0; j--) {
//                    stbL.append(stbR.charAt(j));
//                }
//                if (stbR.toString().equalsIgnoreCase(stbL.toString())) {
//                    return stbR.toString();
//                }
//            }
//        }
//
//        return String.valueOf(s.charAt(0));
//    }
}
