package strings.Medium.string;

public class LongestPalindrome {

    public static int palindromeLength(String word, int left, int right){
        while( (left >=0 && right < word.length() && (word.charAt(left) == word.charAt(right)))){
            left--;
            right++;
        }
        return right - left -1;
    }

    public static String longestPalindromeString(String word) {
        int start =0;
        int end =0;

        for(int i =0; i< word.length(); i++){
            int length1 = palindromeLength(word,i,i);
            int length2 = palindromeLength(word,i,i+1);
            int length = Math.max(length1,length2);

            if(length> end - start){
                start = i - (length-1)/2;
                end = i + (length)/2;
            }
        }

        return word.substring(start,end+1);
    }

    public static void main(String[] args) {
        System.out.println("SSS "+longestPalindromeString("racecar"));
        System.out.println("SSS "+longestPalindromeString("acadfkgjdaaccaalfkg"));
    }
}
