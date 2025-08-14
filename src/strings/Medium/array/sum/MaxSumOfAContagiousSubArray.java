package strings.Medium.array.sum;

public class MaxSumOfAContagiousSubArray {

    public static int getContagiousSub(int[] arr){

        int current_sum =arr[0];
        int max_sum =arr[0];
        int lastIndex=0;
        int startIndex =0;

        for (int i =1; i < arr.length; i++){

            if((current_sum < 0)){
                current_sum = arr[i];
                startIndex= i;
            }else{
                current_sum = current_sum + arr[i];
            }

            if (current_sum > max_sum){
                lastIndex = i;
                max_sum = current_sum;
            }
        }

        for(int i=startIndex; i <=(lastIndex); i++){
            System.out.print(" "+arr[i]);
        }

        System.out.println(" ");
        System.out.println("Max sum is :::: "+max_sum);
        return max_sum;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, 100, -1, -2, 3, 1, -5, 4};
        getContagiousSub(arr);
    }
}
