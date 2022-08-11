package BiweeklyContest72;

import java.util.*;

public class Solution {

    public static int countPairs(int[] nums, int k) {
        int i, j;
        int n = nums.length;
        int counter = 0;
        for (i = 0; i < n - 1; i++) {
            for (j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0)
                    counter++;
            }
        }
        return counter;
    }

    public static long[] sumOfThree(long num) {
        boolean isDivisible = (num % 3) == 0;
        long temp = num / 3;

        long[] arr;
        if (isDivisible) {
            arr = new long[3];
            arr[0] = temp - 1;
            arr[1] = temp;
            arr[2] = temp + 1;
        } else {
            arr = new long[0];
        }

        return arr;
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> arr = new LinkedList<>();
        if (finalSum % 2 != 0)
            return arr;
        if (finalSum == 2) {
            arr.add((long) (2));
            return arr;
        }

        long sum = 0;
        for (int i = 2; i < finalSum + 2; i += 2) {
            sum += (long) i;
            if (sum == finalSum) {
                arr.add((long) i);
                return arr;
            }
            if (sum > finalSum) {
                int temp = arr.size() - 1;

                arr.set(temp, arr.get(temp) + ((finalSum - (sum - (long) i))));
                return arr;

            }
            arr.add((long) i);
        }
        return arr;
    }

    public static boolean checkSum(List<Long> arr, long check) {

        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum == check;
    }

    /*
     * public static long goodTriplets(int[] nums1, int[] nums2) {
     * 
     * long totalNumber = 0;
     * int n = nums1.length;
     * if(n<3) {
     * return 0;
     * }
     * 
     * if(n==3){
     * for(int i = 0;i<n;i++)
     * {
     * if(nums1[i] != nums2[i])
     * return 0;
     * }
     * }
     * 
     * long values = nCr(n-1,3);
     * System.out.println(values);
     * long[][] triplet1 = new long[(int) values][3];
     * long[][] triplet2 = new long[(int) values][3];
     * int p=0,q=1,r=2;
     *//*
        * 0 1 2 3 4 5
        * 
        * 0 1 2
        * 0 1 3
        * 0 1 4
        * 0 1 5
        * 0 2 5
        * 0 3 5
        * 0 4 5
        * 1 4 5
        * 2 4 5
        * 3 4 5
        *//*
           * 
           * for(int j = 0;j<values;j++){
           * triplet1[j][0] = nums1[p];
           * triplet1[j][1] = nums1[q];
           * triplet1[j][2] = nums1[r];
           * triplet2[j][0] = nums1[p];
           * triplet2[j][1] = nums1[q];
           * triplet2[j][2] = nums1[r];
           * 
           * r++;
           * if(r == n){
           * r = n-1;
           * q++;
           * if(q == n-1) {
           * q = n - 2;
           * p++;
           * if(p == n-2){
           * p =n-3;
           * }
           * }
           * }
           * }
           * 
           * 
           * 
           *//*
              * for(int[] te : triplet1){
              * for(int t:te){
              * System.out.print(t);
              * }
              * System.out.println();
              * }
              * 
              * System.out.println("---------");
              * for(int[] te : triplet2){
              * for(int t:te){
              * System.out.print(t);
              * }
              * System.out.println();
              * }
              *//*
                 * 
                 * long counter =0;
                 * 
                 * for (long[] arr: triplet1){
                 * afficher1D(arr);
                 * System.out.println("");
                 * 
                 * for (long[] arr2:triplet2){
                 * if(equalArrays(arr,arr2)) {
                 * 
                 * totalNumber++;
                 * break;
                 * }
                 * }
                 * }
                 * 
                 * return totalNumber;
                 * }
                 */

    public static <T> List<T> ArrayToListConversion(T arr[]) {

        // creating the constructor of thr List class
        List<T> list = new ArrayList<>();
        // the method adds Array to the List
        Collections.addAll(list, arr);
        // returns the list
        return list;
    }

    public static boolean equalArrays(Integer[] a, Integer[] b) {
        if (a.length != b.length)
            return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i])
                return false;
        }

        return true;
    }

    public static void removeDuplicates(long[] a) {
        LinkedHashSet<Long> set = new LinkedHashSet<Long>();

        // adding elements to LinkedHashSet
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);

        // Print the elements of LinkedHashSet
        System.out.print(set);
    }

    public static long factorial(int n) {
        long factorial = 1;
        for (long i = 2; i <= n; i++)
            factorial = factorial * i;
        return factorial;
    }

    public static long nCr(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void afficher1D(long[] arr) {
        for (long i : arr)
            System.out.print(i + " ");
        System.out.print(" ");
    }

    /*
     * 
     * 
     * public static void helper(List<int[]> combinations, int data[], int start,
     * int end, int index) {
     * if (index == data.length) {
     * int[] combination = data.clone();
     * combinations.add(combination);
     * } else if (start <= end) {
     * data[index] = start;
     * helper(combinations, data, start + 1, end, index + 1);
     * helper(combinations, data, start + 1, end, index);
     * }
     * }
     * public static List<int[]> generate(int n, int r,int [] arr) {
     * List<int[]> combinations = new ArrayList<>();
     * helper(combinations, new int[r], 0, n-1, 0);
     * return combinations;
     * }
     * 
     */

    public static List<Integer[]> list;
    public static List<Integer[]> list2;

    static void combinationUtil(int arr[], int data[], int start,
            int end, int index, int r, List<Integer[]> l) {
        Integer[] tab = new Integer[3];
        // Current combination is ready to be printed, print it
        if (index == r) {
            for (int j = 0; j < r; j++)
                tab[j] = data[j];
            // System.out.print(data[j]+" ");
            l.add(tab);
            return;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i + 1, end, index + 1, r, l);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r, List<Integer[]> l) {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temporary array 'data[]'
        combinationUtil(arr, data, 0, n - 1, 0, r, l);

    }

    public static long goodTriplets(int[] nums1, int[] nums2) {

        long totalNumber = 0;
        int len = nums1.length;
        if (len < 3) {
            return 0;
        }

        if (len == 3) {
            for (int i = 0; i < len; i++) {
                if (nums1[i] != nums2[i])
                    return 0;
            }
        }

        list = new LinkedList<Integer[]>();
        list2 = new LinkedList<Integer[]>();

        int r = 3;
        int n = nums1.length;
        printCombination(nums1, n, r, list);
        printCombination(nums2, n, r, list2);
        List<Integer[]> listT = new LinkedList<Integer[]>(list);
        listT.retainAll(list2);
        totalNumber = listT.size();
        /*
         * for (int t =0;t<list.size();t++){
         * Integer[] arr = list.get(t);
         * if (list2.contains(arr))
         * {
         * totalNumber++;
         * }
         *//*
            * for(int p = 0;p<list2.size();p++){
            * if(equalArrays(list.get(t),list2.get(p))) {
            * 
            * break;
            * }
            * }
            *//*
               * }
               */

        return totalNumber;
    }

    public static void main(String[] args) {
        /*
         * int nums[] = { 3,1,2,2,2,1,3};
         * int k = 2;
         * int i = countPairs(nums,k);
         * int num = 33;
         * long [] arr = sumOfThree(4);
         * for(long kk:arr){
         * System.out.println(kk);
         * }
         */
        /*
         * List<Long> arr = new LinkedList<>();
         * arr = maximumEvenSplit(4);
         * for(int i = 0;i<arr.size();i++){
         * System.out.println(arr.get(i));
         * }
         */
        int[] nums1 = new int[] { 17, 0, 15, 2, 9, 13, 14, 8, 11, 16, 6, 5, 3, 19, 18, 1, 12, 10, 7, 4 };
        int[] nums2 = new int[] { 13, 3, 14, 18, 8, 11, 4, 5, 10, 7, 9, 0, 12, 17, 15, 6, 16, 19, 1, 2 };
        System.out.println(goodTriplets(nums1, nums2));
    }

    // this is not working today because of a lot of elements int he world of Coding
    // I am just writing whatever...

}
