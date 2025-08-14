package strings.Simple.string;

public class CountVowelAndConsonant {

    public static String countVowelsConsonant(String message){
        message = message.toLowerCase();

        int vowels=0, consonant = 0;
        for(char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                switch (ch) {
                    case 'a', 'e', 'i', 'o', 'u':
                        vowels++;
                        break;
                    default:
                        consonant++;
                        break;
                }
            }
        }
       return "Vowels : "+vowels+ " Consonant : "+consonant;
    }

    public static void main(String[] args) {
        System.out.print(countVowelsConsonant("qwertyuioplkjhgfdsamnbvcxz"));
    }
}
