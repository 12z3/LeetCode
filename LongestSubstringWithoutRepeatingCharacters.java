package LeetCode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Given a string s, find the length of the longest
    substring
    without repeating characters.
     */

    public static void main(String[] args) {
        //String s = "abcabcbb";
        //String s = "pwwkew";
        //String s = "bbbbb";
        //String s = "dvdf";
        //String s = "aab";
        String s = "";

        List<String> inputs = new ArrayList<>(List.of("abcabcbb", "pwwkew", "bbbbb", "dvdf", "aab", ""));
        for (String el : inputs) System.out.print(lengthOfLongestSubstringA(el) + " ");
        System.out.println();
        for (String el : inputs) System.out.print(lengthOfLongestSubstring(el) + " ");
    }

    // Runtime -> 1222 ms - Beats = 5.1%
    public static int lengthOfLongestSubstringA(String s) {
        ArrayList<Character> tmp = new ArrayList<>();
        int result = -1, count = 0;

        result = (s.length() == 1) ? 1 : 0;
        for (int i = 1; i < s.length(); i++) if (s.charAt(0) == s.charAt(i)) count++;
        if (count == s.length() - 1) return 1;

        for (int i = 0; i < s.length(); i++) {
            if (!tmp.contains(s.charAt(i))) {
                tmp.add(s.charAt(i));
                result = Math.max(result, tmp.size());
            } else {
                ArrayList<Character> tmpN = new ArrayList<>();
                i -= tmp.size();
                tmp = tmpN;
            }
        }
        return result;
    }


    // Runtime -> 2649 ms - Beats = 5.24%
    public static int lengthOfLongestSubstring(String s) {
        Map<StringBuilder, Integer> stringLength = new TreeMap<>();
        StringBuilder stbA = new StringBuilder();
        int result = -1, count = 0;


        if (s.length() == 1) return 1;
        if (s.length() == 0) return 0;
        for (int i = 1; i < s.length(); i++) if (s.charAt(0) == s.charAt(i)) count++;
        if (count == s.length() - 1) return 1;

        LOOP:
        for (int i = 0; i < s.length(); i++) {
            stbA.delete(0, stbA.length());
            char elA = s.charAt(i);
            stbA.append(elA);
            for (int j = i + 1; j < s.length(); j++) {
                char elB = s.charAt(j);
                if (stbA.indexOf(String.valueOf(elB)) != -1) {
                    j--;
                    continue LOOP;
                } else {
                    stbA.append(elB);
                }
                StringBuilder stbTemp = new StringBuilder(stbA);
                stringLength.put(stbTemp, stbTemp.length());
            }
        }

        //for (Map.Entry<StringBuilder, Integer> el : stringLength.entrySet()) System.out.println(el);
        for (Map.Entry<StringBuilder, Integer> el : stringLength.entrySet()) {
            result = Math.max(result, el.getValue());
        }
        return result;
    }
}
