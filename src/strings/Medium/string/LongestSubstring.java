package strings.Medium.string;

import java.util.HashSet;

public class LongestSubstring {

    public static StringBuilder longestSubString(String message) {

        HashSet<Character> char_set = new HashSet<>();
        StringBuilder subString = new StringBuilder();
        StringBuilder longest = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if ( char_set.contains(ch)) {
                char_set.clear();
                subString = new StringBuilder();
            }

            char_set.add(ch);
            subString= subString.append(ch);

            if (subString.length()>longest.length()){
                longest = subString;
            }
        }

        System.out.print(longest);
        return longest;
    }

    public static void main(String[] args) {
        longestSubString("ABCAERTYU");
    }

}
