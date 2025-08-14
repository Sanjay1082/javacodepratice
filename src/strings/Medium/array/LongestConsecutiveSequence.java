package strings.Medium.array;

public class LongestConsecutiveSequence {

    public static int lenLongestConSeq(int[] arr) {

        int longest = 0;
        int current_longest = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                current_longest++;
            } else {
                current_longest = 0;
            }

            if (longest < current_longest) {
                longest = current_longest;
            }

        }
        return longest;
    }

    public static int getLogestSum(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];
        int start=0; int end = 0;

        for (int i = 1; i < arr.length; i++) {
            if(currentSum < 0){
                currentSum = arr[i];
                start=i;
            }else{
                end =i;
                currentSum = Math.max(currentSum, currentSum+arr[i]);
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        for(int i= start; i < end; i++){
            System.out.print(" "+arr[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, -6};
        System.out.println(lenLongestConSeq(arr));
        getLogestSum(arr);

    }
}
