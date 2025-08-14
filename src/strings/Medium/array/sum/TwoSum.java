package strings.Medium.array.sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] targetedSum(int[] arr, int targetasum) {
        int first = 0;

        int[] ele = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int index = i + 1; index < arr.length; index++) {

                first = arr[i];

                if ((targetasum - first) == arr[index]) {
                    ele[0] = first;
                    ele[1] = targetasum - first;
                    return ele;
                }

            }
        }
        return null;
    }

    public static int[] targetedSumOptimum(int[] arr, int targettedsum) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < arr.length; index++) {
            targettedsum = arr[0];
            int second = targettedsum - arr[index];

            if (map.containsKey(second)) {
                return new int[]{second, arr[index], targettedsum};
            }
            map.put(arr[index], index);

        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0,9, -7, 10};

//        for(int el : targetedSum(arr,9)){
//            System.out.print(" "+el);
//        }

        for (int el : targetedSumOptimum(arr, 9)) {
            System.out.print(" " + el);
        }
    }
}
