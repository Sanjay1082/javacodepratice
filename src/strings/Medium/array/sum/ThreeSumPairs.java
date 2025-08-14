package strings.Medium.array.sum;

import java.lang.reflect.Array;
import java.util.*;

public class ThreeSumPairs {

    public static ArrayList<ArrayList<Integer>> getPairOfTheSum(int[] arr, int total){

        Set<Integer> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> pairs = new ArrayList<>();

        for(int num : arr){
            int second = total - num;

            if(visited.contains(second)){
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(num);
                pair.add(second);
                pairs.add(pair);
                Collections.sort(pair);
            }
            visited.add(num);
        }
        return pairs;
    }

    public static ArrayList<ArrayList<Integer>> getTripletOfTheSum(int[] arr){

        Set<Integer> visited = new HashSet<>();
        ArrayList<ArrayList<Integer>> triplet = new ArrayList<>();

        for (int i=0; i< arr.length - 2; i++){
            int first = -arr[i];

            if(!getPairOfTheSum(arr,first).isEmpty()){
                ArrayList<ArrayList<Integer>> ele = getPairOfTheSum(arr,first);
                ArrayList<Integer> firstPair = ele.getFirst();
                Collections.sort(ele.getFirst());
                firstPair.add(arr[i]);
                triplet.add(firstPair);
            }
        }
        return triplet;
    }


    //Correct way to approach the problem

    public static Set<ArrayList<Integer>> getTriplets(int[] arr){

        Set<ArrayList<Integer>> triplets = new HashSet<>();

        Arrays.sort(arr);

        for(int i=0; i< arr.length - 2; i++){
            // Skip duplicates
//            if (i > 0 && arr[i] == arr[i - 1]) continue;


            int first = -arr[i];
            Set<Integer> visited = new HashSet<>();

            for(int j=i+1; j<arr.length; j++){

                if(visited.contains(first - arr[j])){
                    ArrayList<Integer> trip = new ArrayList<>();
                    trip.add(arr[i]);
                    trip.add(arr[j]);
                    trip.add((first - arr[j]));

                    triplets.add(trip);
                }
                visited.add(arr[j]);
            }
        }
        return triplets;
    }

//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,-3,-5,-7,-9};
//        ArrayList<ArrayList<Integer>> triplets = getTripletOfTheSum(arr);
//        for(ArrayList<Integer> trip : triplets){
//            System.out.println(trip);
//        }
//    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        Set<ArrayList<Integer>> triplets = getTriplets(arr);
        for(ArrayList<Integer> trip : triplets){
            System.out.println(trip);
        }
    }

}
