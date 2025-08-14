package strings.Simple.string;

import java.util.Stack;

public class ReverseWord {

    // Using the swapping technique
    public static String reverseWord(String word){
        char[] ch = word.toCharArray();

        for (int i = 0; i< ch.length/2; i++){
            char temp = ch[i];
            ch[i] = ch[ch.length-1 -i];
            ch[ch.length-1-i] = temp;
        }
        return new String(ch);
    }

    //Using the two-pointer approach
    public static String reverseWord1(String word){
        char[] ch = word.toCharArray();

        int start=0;
        int end  = ch.length - 1;

        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return new String(ch);
    }

    //Using the two-pointer approach
    public static String reverseWord2(String word){
        char[] ch = word.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char ch1: ch){
            stack.push(ch1);
        }

        String reversed = "";
       while(!stack.isEmpty()){
           reversed = reversed + stack.pop();
       }

       return  reversed;
    }



    public static void main(String[] args) {
        System.out.println(reverseWord("Sanjay"));
        System.out.println(reverseWord1("Choudhary"));
        System.out.println(reverseWord2("Shayam"));
    }
}
