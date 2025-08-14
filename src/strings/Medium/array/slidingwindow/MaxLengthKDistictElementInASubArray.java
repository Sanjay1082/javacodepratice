package strings.Medium.array.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
🧩 Algorithm Steps
Initialize left = 0, right = 0, maxLen = 0

Use a HashMap map to count element frequencies inside the window

Expand right one element at a time

Add arr[right] to the map

If map.size() > K, shrink from left:

Decrease frequency of arr[left]

If its frequency becomes 0, remove it from the map

Move left++

Update maxLen = max(maxLen, right - left + 1)

Return maxLen
 */

public class MaxLengthKDistictElementInASubArray {

    // Works only for the few inputs
    // exa 1,1,1,1 and k =1 this will give the length lesser and for example search the problem in chat gpt
    public static int getMaxLength(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max_len = 0;
        int current_len = -1;

        for (int i = 0; i < arr.length; i++) {

            if (map.size() > k) {
                max_len = Math.max(current_len, max_len);
                map.clear();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                current_len = 0;
            } else {
                current_len++;
                max_len = Math.max(current_len, max_len);
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            max_len = Math.max(current_len, max_len);
        }
        return max_len;
    }


    // Sliding window approach using the hashmap

    public static int getLengthOfTheKDistictSubArray(int[] arr, int k) {

        int max_length = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < arr.length; right++) {

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            if (map.size() > k) {
                while (map.size() >= k) {
                    map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);
                    if (map.get(arr[left]) == 0) {
                        map.remove(arr[left]);
                    }
                    left++;
                }
            }
            max_length = Math.max(max_length, right - left + 1);

        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 1, 2, 3};

        System.out.print(getMaxLength(arr, 1));

        System.out.print(getLengthOfTheKDistictSubArray(arr, 2));
    }

}
