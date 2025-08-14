package strings.Medium.string;

import java.util.*;

public class GroupAnagram {

    public static ArrayList<ArrayList<String>> groupAnagram(String[] args) {

        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : args) {

            int[] ch = new int[26];
            StringBuffer keyBuilder = new StringBuffer();

            for (char ch1 : str.toCharArray()) {
                ch[ch1 - 'a'] = ch[ch1 - 'a'] + 1;
            }

            for (int freq : ch)
                keyBuilder.append('#').append(freq);

            String key = keyBuilder.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(input));
    }
}
