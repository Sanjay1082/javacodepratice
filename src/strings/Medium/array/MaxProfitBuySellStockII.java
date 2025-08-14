package strings.Medium.array;

//Buy and sell multiple time
public class MaxProfitBuySellStockII {
    public static int getMaxProfit(int[] arr){
        if(arr.length <= 1){
            return 0;
        }

        int profit = 0;
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i] < arr[i + 1]){
                profit += arr[i + 1] - arr[i];
            }
        }
        return profit;
    }

    //Buy sell only once, This is not handling all the test cases and will fail few of the test case
    public static int getMaxProfit1(int[] arr){
        int startingDay = 0;
        if(arr.length<2){
            return 0;
        }

        for(int i=0; i < (arr.length-1); i++){
            if(arr[i]<arr[i+1]){
              startingDay = i;
              break;
            }
        }
        int max = getMax(arr, startingDay);
        int min = getMin(arr, startingDay);
        return max - min;
    }

    public static int getMax(int[] arr, int index){
        int max = Integer.MIN_VALUE;

        for(int i = index; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }

        }
        return max;
    }

    public static int getMin(int[] arr, int index){
        int min = Integer.MAX_VALUE;

        for(int i = index; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }

        }
        return min;
    }


    //Buy sell only once, This is not handling all the test cases and will fail few of the test case
    public static int getMaxProfit2(int[] arr){
        int startingDay = 0;
        if(arr.length<2){
            return 0;
        }

        int min = arr[0];
        int max =0;

        for (int i =0; i < arr.length; i++){
            max = Math.max(max, arr[i]-min);
            min = Math.min(arr[i], min);
        }

       return max;
    }


// Another way of writing the best solution
    public static int getMaxProfit3(int[] arr){

        int buy_price =arr[0];
        int max_profit = 0;

        for(int i =1; i< arr.length; i++){

            if (buy_price > arr[i]){
                buy_price=arr[i];
            }else{
                int current_profit = arr[i] - buy_price;
                max_profit = Math.max(max_profit,current_profit);
            }
        }
        return max_profit;
    }



    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 9, 1, 2};
        System.out.println(getMaxProfit(arr)); // Output: 8
        System.out.println(getMaxProfit1(arr)); // Output: 5
        System.out.println(getMaxProfit2(arr)); // Output: 5
        System.out.println(getMaxProfit3(arr)); // Output: 5
    }
}