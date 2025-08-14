package strings.Simple.string;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    public static void nonReaptingChar(String word) {
        char[] ch = word.toCharArray();
        Map<Character, Integer> freqency = new HashMap<>();

        for(char ch1 : ch){
            freqency.put(ch1, freqency.getOrDefault(ch1,0)+1);
        }

        for(Map.Entry<Character, Integer> entry : freqency.entrySet()){
            if(entry.getValue() ==1)
                System.out.println(entry.getKey());
        }
    }



    public static Character firstNonRepeatingChar(String word){
        char[] ch = word.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();

        for(char ch1 : ch){
            freq.put(ch1, freq.getOrDefault(ch1,0)+1);
        }

        for(Map.Entry<Character, Integer> entry : freq.entrySet()){
            if(entry.getValue()==1)
            { System.out.println(entry.getKey());
                return entry.getKey();}
        }
        return  ' ';
    }

    public static void main(String[] args) {
        nonReaptingChar("Sanjay");
        firstNonRepeatingChar("aaaabbbbcccdddefffn");
    }
}
