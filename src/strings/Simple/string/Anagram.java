package strings.Simple.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static boolean isAnagram(String str1, String str2){

        if(str1.length()!= str2.length())
            return false;

        Map<Character, Integer > anagram = new HashMap<>();

        for(char ch : str1.toCharArray()){
            anagram.put(ch, anagram.getOrDefault(ch,0)+1);
        }

        for(char ch : str2.toCharArray()){
            anagram.put(ch, anagram.getOrDefault(ch,0)-1);
        }

        for (Integer value : anagram.values())
        {
            if (value !=0){
                return false;
            }
        }

        return true;
    }


    // Solve the anagram problem using the 26 char array
    // This is using the concept of the ASCII value

    public static boolean isAnagram1(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a'] = freq[str1.charAt(i) - 'a'] + 1;
            freq[str2.charAt(i) - 'a'] = freq[str2.charAt(i) - 'a'] - 1;
        }

        for(int value : freq){
            if(value !=0)
                return false;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(isAnagram("thumtum","tumhumt"));
        System.out.println(isAnagram1("thumtum","tumhmt"));
    }
}
