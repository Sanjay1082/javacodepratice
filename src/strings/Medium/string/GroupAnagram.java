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

    //Brute force solution
    public static boolean isAnagram(String str1, String str2){

        if(str1.length() != str2.length()){
            return false;
        }

        int[] fre = new int[26];
        ArrayList<String> group = new ArrayList<>();

        for(int i = 0; i < str1.length(); i++){
            fre[str1.charAt(i) - 'a'] =  fre[str1.charAt(i) - 'a'] + 1;
            fre[str2.charAt(i) - 'a'] =  fre[str2.charAt(i) - 'a'] - 1;
        }

        for(int value : fre){
            if(value !=0){
                return false;
            }
        }
        return true;
    }

    public static Set<Set<String>> findGroupAnagram(String[]  str){
        Set<Set<String>> groupAnagrams = new LinkedHashSet<>();
        for(int i =0; i < str.length; i++){
            Set<String> group = new LinkedHashSet<>();
            boolean flag = false;
            for(int j = i+1; j < str.length; j++){
                flag = isAnagram(str[i], str[j]);
                if(flag && !(str[i].isEmpty() || str[j].isEmpty())){
                    group.add(str[i]);
                    group.add(str[j]);
                }
            }
            groupAnagrams.add(group);
        }
        return groupAnagrams;
    }


    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagram(input));
    }
}
