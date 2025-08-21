package strings.Medium.string;

public class StringCompression {

    public static String stringCompression(String word){

        int[] freq = new int[26];

        for(char ch1 : word.toCharArray()){
            freq[ch1 - 'a'] = freq[ch1 - 'a'] + 1;
        }

        StringBuffer sb = new StringBuffer();

        for (int fre = 0; fre < freq.length; fre++){
            if(freq[fre]!=0) {
                char ch1 = (char) (fre + 'a');
                sb.append(ch1).append(freq[fre]);
//                sb.append(freq[fre]).append((char) (fre + 'a'));
            }
        }
        System.out.print(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        stringCompression("aaabbbccc");
    }
}
