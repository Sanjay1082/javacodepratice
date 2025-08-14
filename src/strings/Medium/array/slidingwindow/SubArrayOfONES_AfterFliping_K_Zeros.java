package strings.Medium.array.slidingwindow;

public class SubArrayOfONES_AfterFliping_K_Zeros {
    /*
    ✅ Algorithm (Sliding Window Approach)
Initialize left = 0, maxLen = 0, and zeroCount = 0.

Traverse the array with a right pointer:

If arr[right] == 0, increment zeroCount.

While zeroCount > K, shrink window from the left:

If arr[left] == 0, decrement zeroCount.

Move left forward.

Update maxLen = max(maxLen, right - left + 1)

Return maxLen
     */

    /*

arr = [1, 1, 0, 0, 1, 1, 1, 0], K = 2

| Step     | `left` | `right` | Current Element | `zeroCount` | Window `[left..right]`    | Valid? | `maxLen` |
| -------- | ------ | ------- | --------------- | ----------- | ------------------------- | ------ | -------- |
| 1        | 0      | 0       | 1               | 0           | \[1]                      | ✅ Yes  | 1        |
| 2        | 0      | 1       | 1               | 0           | \[1, 1]                   | ✅ Yes  | 2        |
| 3        | 0      | 2       | 0               | 1           | \[1, 1, 0]                | ✅ Yes  | 3        |
| 4        | 0      | 3       | 0               | 2           | \[1, 1, 0, 0]             | ✅ Yes  | 4        |
| 5        | 0      | 4       | 1               | 2           | \[1, 1, 0, 0, 1]          | ✅ Yes  | 5        |
| 6        | 0      | 5       | 1               | 2           | \[1, 1, 0, 0, 1, 1]       | ✅ Yes  | 6        |
| 7        | 0      | 6       | 1               | 2           | \[1, 1, 0, 0, 1, 1, 1]    | ✅ Yes  | 7 ✅      |
| 8        | 0      | 7       | 0               | 3 ❌         | \[1, 1, 0, 0, 1, 1, 1, 0] | ❌ No   | —        |
| → Shrink | 1      | 7       | —               | 3           | \[1, 0, 0, 1, 1, 1, 0]    | ❌      | —        |
| → Shrink | 2      | 7       | —               | 3           | \[0, 0, 1, 1, 1, 0]       | ❌      | —        |
| → Shrink | 3      | 7       | —               | 2 ✅         | \[0, 1, 1, 1, 0]          | ✅ Yes  | 7        |

     */


    public static int getOneSubArray(int[] arr, int k) {
        int max_length = 0;
        int zeros = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            {
                if (arr[right] == 0) {
                    zeros++;
                }

                if (zeros > k) {
                    if (arr[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
                max_length = Math.max(max_length, right - left + 1);
            }
        }
        return max_length;
    }

    //Brute - force
    public static int getOneSubArray1(int[] arr, int k) {

        int max_length = 0;
        for (int i = 0; i < arr.length; i++) {
            int zeros = 0;
            for (int j = i; j < arr.length; j++) {

                if (arr[j] == 0) {
                    zeros++;
                }
                if (zeros > k) {
                    break;
                }
                max_length = Math.max(max_length, j - i + 1);
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 1, 1,};

        System.out.print(getOneSubArray(arr, 2));

        System.out.print(getOneSubArray1(arr, 2));
    }
}
