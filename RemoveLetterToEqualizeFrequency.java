package LeetCode;

import java.util.*;

public class RemoveLetterToEqualizeFrequency {

    /**
     * -> aаbbcc: Махам 1-о "а" и проверява дали "а", "b" и "c" отговарят на условието за периодичност в "аbbcc".
     * Ако е "Да" -> return.
     * Ако е "Не", махам следващата след "а", но различна от "а" буква, в случая "b" и проверявам  "abcc" за
     * периодичност.
     * ? Как ще изглежда условието за периодичност.
     */

    public static void main(String[] args) {
        //String word = "aabbzz";
        //String word = "aaabbccdd";
        //String word = "aazz";
        String word = "abcc";
        //String word = "cccaa";
        //String word = "bac";
        //String word = "abbcc"; //<-

        //System.out.println(removeLetterToEqualizeFrequency(word));
        System.out.println(removeLetterToEqualizeFrequencyA(word));

    }

    private static boolean removeLetterToEqualizeFrequencyA(String word) {
        boolean result = true;
        int countEl, max = Integer.MIN_VALUE, count = 0, sum = 0, countDiff = 0;
        List<StringBuilder> letters = new ArrayList<>();
        StringBuilder tmpX = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            StringBuilder tmp = new StringBuilder();
            char elA = word.charAt(i);
            tmp.append(elA);
            if (tmpX.toString().indexOf(elA) == -1) {
                tmpX.append(elA);
                for (int j = i + 1; j < word.length(); j++) {
                    char elB = word.charAt(j);
                    if (elA == elB) {
                        tmp.append(elB);
                    } else break;
                }
                letters.add(tmp);
            } else continue;
        }
        System.out.println(letters);
        System.out.println(word);
        for (StringBuilder el : letters) System.out.print(el.length() + " ");


        for (StringBuilder el : letters) max = Math.max(max, el.length());
        // for (StringBuilder el: letters) if (el.length() == max) el.delete(0,1);
        for (StringBuilder el : letters) {
            sum += el.length();
        }

        for (int i = 0; i < letters.size() - 1; i++) {
            int a = letters.get(i).length();
            int b = letters.get(i + 1).length();
            if (Math.abs((a - b)) == 0) {
                countDiff++;
            }
        }

        return (countDiff != 0) && countDiff != 1;

//        System.out.println("\n" + max);
//        System.out.println(sum);
        //return (sum % letters.size() == 0);
    }

    private static boolean removeLetterToEqualizeFrequency(String word) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int count = 1, j = 0, sum = 0, countA = 0, reper = 0, countMax = 0;
        char maxEl = '*';
        boolean result = false;


        while (j < word.length()) {
            char el = word.charAt(j);
            if (frequency.containsKey(el)) {
                count = frequency.get(el);
                count++;
            } else {
                count = 1;
            }
            frequency.put(el, count);
            j++;
        }
        System.out.println(word);
        System.out.println(frequency);

        Map<Character, Integer> tmpMap = new HashMap<>();
        tmpMap.putAll(frequency);

        for (Map.Entry<Character, Integer> el : tmpMap.entrySet()) {
            if (el.getValue() >= max) {
                max = el.getValue();
                maxEl = el.getKey();
                countMax++;
            }
            sum += el.getValue();
        }

        if ((tmpMap.containsValue(max))) tmpMap.replace(maxEl, max - 1);
//        for (Map.Entry<Character, Integer> el : tmpMap.entrySet()) {
//            if ((tmpMap.containsValue(max))) tmpMap.replace(el.getKey(), max - 1);
//        }


        System.out.println(max);
        System.out.println(sum);
        System.out.println(tmpMap);

        max = -1;
        for (Map.Entry<Character, Integer> el : tmpMap.entrySet()) {
            if (el.getValue() >= max) {
                max = el.getValue();
            }
        }

        for (Map.Entry<Character, Integer> el : tmpMap.entrySet()) {
            if (max == 1) {
                return true;
            } else if (el.getValue() == max) countA++;
        }

        return countA == tmpMap.size();
    }

    private static boolean removeLetterToEqualizeFrequencyC(String word) {

        return true;
    }
}

// -> 43 / 49 testcases passed
/**
 * public boolean equalFrequency(String word) {
 * Map<Character, Integer> frequency = new LinkedHashMap<>();
 * int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
 * int count = 1, j = 0, sum = 0, countA = 0, reper = 0;
 * char maxEl = '*';
 * boolean result = false;
 * <p>
 * <p>
 * while (j < word.length()) {
 * char el = word.charAt(j);
 * if (frequency.containsKey(el)) {
 * count = frequency.get(el);
 * count++;
 * } else {
 * count = 1;
 * }
 * frequency.put(el, count);
 * j++;
 * }
 * // System.out.println(word);
 * // System.out.println(frequency);
 * <p>
 * Map<Character, Integer> tmpMap = new HashMap<>();
 * tmpMap.putAll(frequency);
 * <p>
 * for (Map.Entry<Character, Integer> el : tmpMap.entrySet()) {
 * if (el.getValue() > max) {
 * max = el.getValue();
 * maxEl = el.getKey();
 * }
 * sum += el.getValue();
 * }
 * if (frequency.containsValue(max)) tmpMap.replace(maxEl, max - 1);
 * reper = max - 1;
 * <p>
 * // System.out.println(sum);
 * // System.out.println(tmpMap);
 * <p>
 * for (Map.Entry<Character, Integer> el : tmpMap.entrySet()){
 * if (max == 1){
 * return true;
 * } else if (el.getValue() == max - 1) countA++;
 * }
 * <p>
 * return countA == tmpMap.size();
 * }
 */