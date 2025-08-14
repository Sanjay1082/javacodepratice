package strings.Simple.string;

import java.util.*;

public class ReverseSentence {

    // Reverse a sentence with using the additional variable
    public static String  reverseSentenceUsingAdditonalSpace1(String sentence){

        String[] words = sentence.split(" ");

        StringBuffer sb = new StringBuffer();

        for(int i=0; i< words.length; i++){
            sb.append( words[words.length-1 -i]).append(" ");
        }

        return sb.toString();
    }

    public static String  reverseSentenceUsingAdditonalSpace2(String sentence){
        List<String> words = Arrays.asList(sentence.split(" "));
        Collections.reverse(words);
        return String.join(" ",words);
    }


    public static String  reverseSentenceUsingAdditonalSpace3(String sentence){
        Stack<String> stack = new Stack<>();
        String[] words = sentence.split(" ");

        for(int index = words.length-1; index>=0; index--){
            stack.push(words[index]);
        }
        return String.join(" ",stack);
    }



    public static void main(String[] args) {
        System.out.println(reverseSentenceUsingAdditonalSpace1("My name is Sanjay"));
        System.out.println(reverseSentenceUsingAdditonalSpace2("My name is Sanjay"));
        System.out.println(reverseSentenceUsingAdditonalSpace3("My name is Sanjay"));
    }
}
