package strings.Simple.string;

public class Palindrome {

    public static boolean isPalindrome(String word){
        word = word.toLowerCase();
        char[] ch = word.toCharArray();
        for(int i =0; i < ch.length ; i++){
            if(ch[i]!=ch[ch.length-1-i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }
}
