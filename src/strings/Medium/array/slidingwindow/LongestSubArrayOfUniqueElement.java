package strings.Medium.array.slidingwindow;

import java.util.LinkedHashSet;
import java.util.Set;

//Longest Subarray with All Unique Elements	Variation of longest substring without repeating characters	Set, Sliding Window
//longest contiguous subarray with all unique elements.
public class LongestSubArrayOfUniqueElement {

    //This is works for few input but does not handle all the input
    // for example if control goes ahead and then from back we need to construct the uqnique sub array that not
    // possible by this
    public static int getSubArrayOfUniqueElements(int[] arr){

        int max =0;
        int current_length = 0;
        Set<Integer> set = new LinkedHashSet<>();

        for(int i =0; i < arr.length; i++){

            if(set.contains(arr[i])){
                set.clear();
                set.add(arr[i]);
                current_length=1;
            }else{
                current_length++;
                max = Math.max(max, current_length);
                set.add(arr[i]);
            }

        }
        return max;
    }

    //Using the sliding window technique, we can get all the possible unique windows
    public static int getSubArrayOfUniqueElements1(int[] arr){

        int left =0;
        int max_legth=0;

        Set<Integer> visited = new LinkedHashSet<>();

        for(int right = 0; right < arr.length; right++){

            while(visited.contains(arr[right])){
                visited.remove(arr[left]);
                left++;
            }
            max_legth = Math.max(max_legth, right-left+1);
            visited.add(arr[right]);
        }
        return max_legth;
    }


    public static void main(String[] args) {
        int[] arr ={4, 5, 6, 3, 4, 5, 2, 8, 9};
//        System.out.print(getSubArrayOfUniqueElements(arr));
        System.out.print(getSubArrayOfUniqueElements1(arr));
    }
}
