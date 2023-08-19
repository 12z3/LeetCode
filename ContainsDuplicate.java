package dynamicsStructhure;

import dynamicsStructhure.bS.Infinite;

import java.util.*;

import static task.ZigZag.zigZag;

public class ContainsDuplicate {

    // https://leetcode.com/problems/contains-duplicate/submissions/1024933768/
    // https://leetcode.com/problems/contains-duplicate-ii/submissions/1025403234/

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 1, 2, 4, 2, 4, 4};
        int[] b = {1, 0, 1, 1};
        System.out.println(containsDuplicate(a));
        //System.out.println(Arrays.toString(contains(a)));
        contains(a);
        System.out.println(containsDuplicateSet(a));
        //System.out.println(containsDuplicate2(b, 1));
    }


    private static void contains(int[] nums) {              // 1, 1, 1, 4, 3, 2, 4, 2, 4, 4
        int cnt;                                            // 3, 0, 0, 4, 1, 2, 0, 0, 0, 0
        boolean itWasExist, isTrue = false;

        int[] numbers = new int[nums.length];
        int[] counts = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            itWasExist = false;
//            isTrue = false;
            cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) cnt++;
            }

//            if (cnt >= 2) {
//                isTrue = true;
//                break;
//            }

            for (int k = 0; k <= i; k++) {
                if (nums[i] == numbers[k]) {
                    itWasExist = true;
                    break;
                }
            }
            if (!itWasExist) {
                numbers[i] = nums[i];
                counts[i] = cnt;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (counts[i] != 0) System.out.printf("el: %d -> %d times%n", nums[i], counts[i]);
        }
        //return counts;
        //return isTrue;
    }

    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> digitCount = new LinkedHashMap<>();
        boolean isTrue = false;
        int cnt;

        //for (int i = 0; i < nums.length; i++) digitCount.put(nums[i], 0);
        for (int i = 0; i < nums.length; i++) {

//            if (digitCount.containsKey(nums[i])) {
//                cnt = digitCount.get(nums[i]);
//                digitCount.put(nums[i], ++cnt);

            cnt = digitCount.getOrDefault(nums[i], 0);
            digitCount.put(nums[i], ++cnt);
            if (cnt >= 2) {
                isTrue = true;
                break;
            }

        }

//        for (Map.Entry<Integer, Integer> el : digitCount.entrySet()) {
//            System.out.printf("el: %d -> %d%n", el.getKey(), el.getValue());
//            if (el.getValue() >= 2) {
//                isTrue = true;
//            }
//        }
        return isTrue;
    }

    public static boolean containsDuplicateSet(int[] nums) {
        Set<Integer> digitSet = new HashSet<>();
        for (int num : nums) {
            if (digitSet.contains(num)) {
                return true;
            }
            digitSet.add(num);
        }
        return false;
    }

    private static boolean containsDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> idxOfDigit = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {                                    //  1,2,3, 1, 5, 1
            if (!idxOfDigit.containsKey(nums[i])) {                                //  0,1,2,... за 1 на idx = 3
                idxOfDigit.put(nums[i], i);                                        //  3,1,2
            } else {                                                               //  5,1,2,... за 1 на idx = 5
                if (Math.abs(i - idxOfDigit.get(nums[i])) <= k) {
                    return true;
                } else idxOfDigit.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean containsDuplicateSet2(int[] nums, int k) {
        Set<Integer> digitSet = new HashSet<>();
        ArrayList<Integer> idx = new ArrayList<>(digitSet);
        int num;

        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (digitSet.contains(num)) {
                // todo.....
            }
            digitSet.add(num);
        }
        return false;
    }
}
