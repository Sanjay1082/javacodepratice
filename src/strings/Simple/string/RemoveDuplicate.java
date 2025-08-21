package strings.Simple.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

    public static void removeDuplicates(String word){
        Set<Character> uqnique = new HashSet<>();

        for(char ch : word.toCharArray()){
            uqnique.add(ch);
        }
        System.out.println(new String(uqnique.toString()));
    }



    public static void main(String[] args) {
        removeDuplicates("Sanjay choudhary jairam jhsajhdfas asfjwurhoialbfksvmd wquioagfsdoqwiemfh uwieoudfhmqwehiosd zxcvbnmpoiuytrewqasdfghjkl");
    }
}
