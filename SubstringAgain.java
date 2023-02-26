package LeetCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SubstringAgain {
    /**
     * @Problem: <a href="https://www.youtube.com/watch?v=GS9TyovoU4c&t=1899s">...</a>
     */
    public static void main(String[] args) {
        String input = "abcdacbdfrtu";
        //String input = "abcdacd";
        //String input = "abcabcd";

        substringA(input);
//        System.out.println();
//        substringB(input);

    }

    private static void subsequences(String input) {                             // ... a b c d a c d
        StringBuilder tmp = new StringBuilder();                                // ... a b c a b c d
        Map<StringBuilder, Integer> sequences = new LinkedHashMap<>();
        int max = 0, count = 0;

        for (int r = 0, l = 0; r < input.length(); r++) {
            char el = input.charAt(r);

            //todo:  Довърши го...

        }
    }

    private static void substringA(String input) {
        StringBuilder tmp = new StringBuilder();
        Map<StringBuilder, Integer> sequences = new LinkedHashMap<>();
        Map<StringBuilder, Integer> sequencesResult = new LinkedHashMap<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char el = input.charAt(i);
            if (tmp.toString().indexOf(el, 0) == -1) {
                tmp.append(el);
                result = Math.max(result, tmp.length());
            } else {
                StringBuilder tmp1 = new StringBuilder(tmp);
                sequences.put(tmp1, tmp1.length());
                tmp.delete(0, tmp.length());                                    //    a b c d a c b d f r t u
                i -= (tmp1.length() - 1);                                       // Връща се на текущата позиция
                i--;                                                            // ---//---  текущата позиция - 1-а.
            }                                                                   // заради i++ е цялата галимация.
        }                               // Идеята е: започва от а(п. 0) и търси съвпадение.
                                        // Ако го намери следващата итерация на фор-а да започне от индекса след "а".
        sequences.put(tmp, tmp.length());
        for (Map.Entry<StringBuilder, Integer> el : sequences.entrySet()) {
            if (el.getValue() >= result) {
                result = el.getValue();
                sequencesResult.put(el.getKey(), el.getValue());
            }
        }
        System.out.println(result);
        System.out.println(sequencesResult);
    }

    // Тромаво е, но работи...
    private static void substringB(String input) {
        StringBuilder tmp = new StringBuilder();
        Map<StringBuilder, Integer> sequences = new LinkedHashMap<>();
        Map<Integer, StringBuilder> sequencesA = new LinkedHashMap<>();
        List<StringBuilder> listOfSequence = new ArrayList<>();

        LOOP:
        for (int i = 0; i < input.length(); i++) {                      // ... a b c d a c d
            char elA = input.charAt(i);
            tmp.append(elA);
            for (int j = i + 1; j < input.length(); j++) {
                char elB = input.charAt(j);
                if (tmp.toString().indexOf(elB, 0) == -1) {
                    tmp.append(elB);
                    StringBuilder tmpA = new StringBuilder(tmp);
                    listOfSequence.add(tmpA);
                    sequences.put(tmpA, tmpA.length());
                    sequencesA.put(tmpA.length(), tmpA);                  // 4=bcda и 4=abcd -> Key трябва да уникален.
                } else {                                                  // В този случай ги презаписва.
                    tmp.delete(0, tmp.length());
                    continue LOOP;
                }
            }
        }
        for (Map.Entry<StringBuilder, Integer> el : sequences.entrySet()) System.out.println(el);
        System.out.println();
        for (Map.Entry<Integer, StringBuilder> el : sequencesA.entrySet()) System.out.println(el);
        System.out.println();
        System.out.println("Input string is: " + input);
        System.out.println("List of subsequences is: " + listOfSequence);

        List<StringBuilder> result = new ArrayList<>();
        int max = listOfSequence.get(0).length();
        for (int i = 0; i < listOfSequence.size(); i++) {
            max = Math.max(max, listOfSequence.get(i).length());
        }

        for (int i = 0; i < listOfSequence.size(); i++) {
            if (listOfSequence.get(i).length() == max) {
                result.add(listOfSequence.get(i));
            }
        }

        System.out.println("Result: " + result + ", size = " + max);
    }

    // За да работи коректно това, първо трябва да намеря максималната от всички дължини // 1 - фор.
    // После пак да мина по-всички стрингове и да взема тези чиято дължина е = максималната. // 2 - фор.
}
