package strings.Medium.array.sum;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> targetedSumOptimum(int[] arr, int targettedsum){



        Set<List<Integer>> sets = new HashSet<>();

        for(int i =0; i< arr.length -2; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int index = i+1; index < arr.length; index++) {
                targettedsum = -arr[i];
                int second = targettedsum - arr[index];

                if (map.containsKey(second)) {
                    List ele = (List<Integer>) Arrays.asList(second, arr[index], arr[i]);
                    Collections.sort(ele);
                    sets.add(ele);
                }
                map.put(arr[index], index);
            }
        }
        return new ArrayList<>(sets);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = targetedSumOptimum(arr, 9);

        if(!list.isEmpty()) {
            for (List<Integer> l : list) {
                System.out.println(l);
            }
        }
    }
}
