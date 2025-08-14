package strings.Medium.array.presum;

import java.util.HashMap;
import java.util.Map;

public class SubArrayOfEqualZerosAndOnes {
    public static int getBalancedZerosAndOnesSubArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum = sum + ((arr[i] == 0) ? -1 : 1);

            if(sum == 0){
                max = i + 1;
            }

            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                max = Math.max(max, len);
            }else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 0, 0, 1, 1};
        System.out.print(getBalancedZerosAndOnesSubArray(arr));
    }
}
