package strings.Medium.array.sum;

import java.util.*;

public class FourSumPairs {


    public static Set<ArrayList<Integer>> getFourSumPairs(int[] arr, int total) {

        Arrays.sort(arr);

        Set<ArrayList<Integer>> fourlets = new HashSet<>();

        for (int i = 0; i < arr.length - 3; i++) {
            int first =  - arr[i];
            for (int j = i + 1; j < arr.length - 2; j++) {

                int second = first - arr[j];
                Set<Integer> visitedFlag = new HashSet<>();

                for (int k = j + 1; k < arr.length; k++) {
                    int third = second - arr[k];
                    if (visitedFlag.contains(third)) {
                        ArrayList<Integer> pairs = new ArrayList<>();
                        pairs.add(arr[i]);
                        pairs.add(third);
                        pairs.add(second);
                        pairs.add(first);

                        Collections.sort(pairs);

                        fourlets.add(pairs);
                    }

                    visitedFlag.add(arr[k]);
                }
            }
        }
        return fourlets;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        for(ArrayList<Integer> ele : getFourSumPairs(arr,0)){
            System.out.println(ele);
        }
    }
}
