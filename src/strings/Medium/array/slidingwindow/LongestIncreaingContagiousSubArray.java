package strings.Medium.array.slidingwindow;

//Longest Increasing Subarray	Find max length increasing subarray	Sliding Window
public class LongestIncreaingContagiousSubArray {

/* Visualization using the sliding window
arr = [1, 2, 2, 4, 5, 6, 3, 4]
| i | arr\[i-1] → arr\[i] | Comparison | currentLen | maxLen | Explanation                      |
| - | ------------------- | ---------- | ---------- | ------ | -------------------------------- |
| 1 | 1 → 2               | 2 > 1 ✅    | 2          | 2      | start counting: \[1, 2]          |
| 2 | 2 → 2               | 2 == 2 ❌   | 1          | 2      | not strictly increasing → reset  |
| 3 | 2 → 4               | 4 > 2 ✅    | 2          | 2      | \[2, 4]                          |
| 4 | 4 → 5               | 5 > 4 ✅    | 3          | 3      | \[2, 4, 5]                       |
| 5 | 5 → 6               | 6 > 5 ✅    | 4          | 4      | \[2, 4, 5, 6] → longest so far ✅ |
| 6 | 6 → 3               | 3 < 6 ❌    | 1          | 4      | decrease → reset                 |
| 7 | 3 → 4               | 4 > 3 ✅    | 2          | 4      | new window: \[3, 4]              |

 */


    //Without the sliding window
    public static int getIncreasingContagiousSubArray(int[] arr) {

        int current_length = 1;
        int max_length = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                current_length++;
            } else {
                current_length = 1;
            }
            max_length = Math.max(max_length, current_length);
        }
        return max_length;
    }

    // Solution Using the sliding window
    public static int getIncreasingContagiousSubArray1(int[] arr) {
        int left = 0;
        int max_length = 0;
        int count = 1;

        for (int right = 0; right < arr.length - 1; right++) {

            if (arr[right] < arr[right + 1]) {
//                max_length = Math.max(max_length, count++);
                max_length = Math.max(max_length, right - left +1);
            } else {
                // here sloving using the shrinking is not necessary
//                while (arr[left] < arr[right + 1]) {
//                    count--;
//                    left++;
//                }

                left = right;
            }
        }
        return max_length;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 6, 3, 4};
//        System.out.print(getIncreasingContagiousSubArray(arr));

        System.out.print(getIncreasingContagiousSubArray1(arr));
    }

}
