import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lab2 {
    public static String findLongestSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int i = 0, j = 0; j < input.length(); j++)
        {
            char currentChar = input.charAt(j);
            if (visited.containsKey(currentChar)) {
                i = Math.max(visited.get(currentChar) + 1, i);
            }
            if (output.length() < j - i + 1) {
                output = input.substring(i, j + 1);
            }
            visited.put(currentChar, j);
        }
        return output;
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j])
            {
                mergedArray[k] = array1[i];
                i++;
                k++;
            }
            else {
                mergedArray[k] = array2[j];
                j++;
                k++;
            }
        }

        while (i < array1.length) {
            mergedArray[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length) {
            mergedArray[k] = array2[j];
            j++;
            k++;
        }

        return mergedArray;
    }

    public static int maxSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int[][] rotateArray(int[][] arr) {
        int n = arr.length;
        int[][] rotatedArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedArr[i][j] = arr[n - j - 1][i];
            }
        }
        return rotatedArr;
    }

    public static int[] findPair(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[] {array[i], array[j]};
                }
            }
        }
        return null;
    }

    public static int findMaxElements(int[][] matrix) {
        int maxElement = 0;
        for (int i = 0; i < matrix.length; i++) {
            maxElement = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxElement) {
                    maxElement = matrix[i][j];
                }
            }
        }
        return maxElement;
    }

    public static int[][] rotateBackArray(int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int[][] rotatedArray = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotatedArray[cols - 1 - j][i] = array[i][j];
            }
        }
        return rotatedArray;
    }
}
