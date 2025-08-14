package strings.Medium.array;

import java.util.*;

public class RemoveDuplicates {

    public static ArrayList<Integer> removeDuplicate(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], arr[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 10, 25, 15, 30, 20, 50, 5};
        System.out.print(removeDuplicate(arr));
    }
}
