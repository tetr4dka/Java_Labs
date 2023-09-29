import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*String str = "abcabcbb";
        System.out.println(Lab2.findLongestSubstring(str));*/

        /*int[] array1 = new int[] {-5, -4, 12, 17, 24, 65};
        int[] array2 = new int[] {4, 23, 54, 77};
        int[] mergedArray = Lab2.mergeSortedArrays(array1, array2);
        System.out.println(Arrays.toString(mergedArray));*/

        /*int[] nums = {1, -2, 3, 4, -5, 6, -7};
        int maxSum = Lab2.maxSubarraySum(nums);
        System.out.println("Максимальная сумма подмассива: " + maxSum);*/

        /*int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotatedArr = Lab2.rotateArray(arr);
        for (int[] row : rotatedArr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }*/

        /*int[] array = {2, 4, 7, 11, 15};
        int target = 9;
        int[] result = Lab2.findPair(array, target);
        System.out.println(Arrays.toString(result));*/

        /*int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Lab2.findMaxElements(matrix));*/

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] rotatedArr = Lab2.rotateBackArray(arr);
        for (int[] row : rotatedArr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
