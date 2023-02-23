package LeetCode;

public class IndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {

        String string = "sadbutsad";
        String target = "sad";

//        String string = "aaa";
//        String target = "aaaa";

//        String string = "mississippi";
//        String target = "issipi";


//        String string = "abc";
//        String target = "c";

        System.out.println(bIndexOf(string, target));
        System.out.println(cIndexOf(string, target));
        System.out.println(dIndexOf(string, target));
        System.out.println(aIndexOf(string, target));
    }


    // -> 30ms
    public static int bIndexOf(String haystack, String needle) {
        StringBuilder tmp = new StringBuilder();
        int index = 0, result = 0;

        if (haystack.length() < needle.length()) return -1;

        if ((haystack.length() == 1 && needle.length() == 1)
                && (haystack.equalsIgnoreCase(needle))) {
            return 0;
        }

        for (int j = 0; j < haystack.length(); j++) {
            if (needle.charAt(index) == haystack.charAt(j)) {
                tmp.delete(0, tmp.length());
                result = j;
                tmp.append(needle.charAt(index));
                int p = j, k = 0;
                while ((k++ < needle.length() - 1) && (++p < haystack.length())) {
                    tmp.append(haystack.charAt(p));
                   // k++;
                }
                if (needle.equalsIgnoreCase(String.valueOf(tmp))) {
                    return result;
                }
            }
        }
        return -1;
    }

    // -> 1ms
    public static int aIndexOf(String string, String target) {
        String tmp = null;
        int result = -1;

        if (string.length() < target.length()) return -1;

        if ((string.length() == 1 && target.length() == 1)
                && (string.equalsIgnoreCase(target))) {
            return 0;
        }

        for (int j = 0; j < string.length(); j++) {
            int index = 0;
            if (target.charAt(index) == string.charAt(j)) {
                index = j;
                if (index + (target.length()) <= string.length()) {
                    tmp = string.substring(index, index + (target.length()));
                }
            }
            //if (needle.equalsIgnoreCase(tmp)) return index;
            result = (target.equalsIgnoreCase(tmp)) ? index : -1;
            if (result != -1) break;
        }
        return result;
    }

    public static int dIndexOf(String string, String target) {
        int n = string.length();
        int m = target.length();

        if (m == 0) {
            return 0;
        }

        for (int i = 0; i <= n - m; i++) {
            if (string.charAt(i) == target.charAt(0) &&
                    string.regionMatches(true, i, target, 0, m)) {
                return i;
            }
        }

        return -1;
    }

    public static int cIndexOf(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
