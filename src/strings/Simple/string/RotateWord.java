package strings.Simple.string;

public class RotateWord {

    public static void reverseWord(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }

    public static String leftRotateWord(String word, int rotate) {
        //Left rotate
        char[] ch = word.toCharArray();
        reverseWord(ch, 0, rotate - 1);
        reverseWord(ch, rotate, ch.length - 1);
        reverseWord(ch, 0, ch.length - 1);
        return new String(ch);
    }

    public static String rightRotateWord(String word, int rotate) {
        //Left rotate
        char[] ch = word.toCharArray();
        reverseWord(ch, 0, ch.length - 1);
        reverseWord(ch, 0, rotate - 1);
        reverseWord(ch, rotate, ch.length - 1);
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(leftRotateWord("Sanjay Choudhary", 2));
        System.out.println(rightRotateWord("Sanjay Choudhary", 2));
    }
}
