package strings.Medium.array.sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TwoSumPairs {

    public static ArrayList<ArrayList<Integer>> getPairsForTwo(int[] arr, int total){

        Set<Integer> checked = new HashSet<>();
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        for(int num : arr){

            int second = total - num;

            if(checked.contains(second)){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(second);
                pairs.add(pair);
            }
            checked.add(num);
        }
        return pairs;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,9,10};
        ArrayList<ArrayList<Integer>> list = getPairsForTwo(arr,9);

        for(ArrayList<Integer> ele : list){
            System.out.print(ele);
        }

    }

}

