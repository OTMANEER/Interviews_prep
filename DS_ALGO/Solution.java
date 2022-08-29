package DS_ALGO;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.ToolTipManager;
import javax.xml.transform.Result;

public class Solution {

    /*
     * public static int search(int[] nums, int target) {
     * int right = nums.length-1;
     * int left = 0;
     * int index = 0;
     * while(left<=right){
     * int mid = left + (right-left)/2;
     * if(nums[mid] == target)
     * return mid;
     * if(nums[mid] < target)
     * left = mid+1;
     * if(nums[mid] > target)
     * right = mid-1;
     * }
     * return -1;
     * }
     */

    /*
     * public boolean isBadVersion(int n){
     * return true; // Predefined function that find( AN API)
     * };
     * 
     * public int firstBadVersion(int n) {
     * int left = 1,right = n;
     * 
     * while(left <= right){
     * System.out.println("right: "+right+" Left: "+left);
     * int index = left + (right-left)/2;
     * if(isBadVersion(index)==true && isBadVersion(index-1)==false)
     * return index;
     * if(isBadVersion(index)== false && isBadVersion(index-1)==false)
     * left = index+1;
     * else if(isBadVersion(index)== true && isBadVersion(index-1)==true)
     * right = index-1;
     * }
     * return -1;
     * }
     */

    /*
     * public static int searchInsert(int[] nums, int target) {
     * int len = nums.length;
     * int left = 0,right=len -1;
     * boolean flag = false;
     * while (left <= right){
     * int mid = left + (right-left)/2;
     * 
     * if(nums[mid] == target) {
     * flag = true;
     * return mid;
     * }
     * else if (nums[mid] < target)
     * left = mid +1;
     * else
     * right = mid -1;
     * }
     * if( flag == false){
     * System.out.println("left: "+left +" right: "+right);
     * }
     * return left;
     * }
     */

    // The first function is not allowed here before the first declaration OKOK
    //
    /*
     * public static int[] searchRange(int[] nums, int target) {
     * int[] returnArray = new int[]{-1,-1};
     * int len = nums.length;
     * int left = 0, right = len-1;
     * int leftInterval=-1;
     * int rightInterval=-1;
     * if(len == 0){
     * return returnArray;
     * }
     * while(left <= right){
     * int mid = left + (right-left)/2; // Locate the mid of this array before the
     * last iteration
     * 
     * if(nums[mid] == target){
     * 
     * leftInterval = mid;
     * rightInterval = mid;
     * int mid1 = mid;
     * int mid2 = mid;
     * 
     * while (mid1 >=0 && nums[mid1] == target) {
     * leftInterval = mid1;
     * mid1--;
     * }
     * 
     * while(mid2 < len && nums[mid2] == target ) {
     * rightInterval = mid2;
     * mid2++;
     * }
     * returnArray[0] = leftInterval;
     * returnArray[1] = rightInterval;
     * 
     * return returnArray;
     * // System.out.println("left: "+left+" right: "+right);
     * }
     * if( nums[mid] < target){ // Second Half
     * left = mid+1;
     * }else if ( nums[mid] > target){// First Half
     * right = mid-1;
     * }
     * }
     * return returnArray;
     * }
     * 
     * public static boolean containsDuplicate(int[] nums) {
     * 
     * List input = Arrays.asList(nums);
     * Set in = new HashSet();
     * 
     * for(int i:nums)
     * if(!in.add(i))
     * return true;
     *//*
        * BRUTEFORCE
        * 
        * for(int i =0;i<nums.length;i++)
        * {
        * for(int j = 0;j< nums.length;j++) {
        * if(nums[i] == nums[j] && i!=j)
        * return true;
        * }
        * }
        *//*
           * return false;
           * }
           */

    /*
     * public static int search(int[] nums, int target) {
     * if (nums.length <= 1) {
     * if (nums[0] == target)
     * return 0;
     * return -1;
     * }
     * int pivot = findPivot(nums, 0, nums.length - 1);
     * if (pivot == -1)
     * return bSearch(nums, 0, nums.length - 1, target);
     * if (nums[pivot] == target)
     * return pivot;
     * if (nums[0] <= target)
     * return bSearch(nums, 0, pivot - 1, target);
     * return bSearch(nums, pivot + 1, nums.length - 1, target);
     * }
     */

    public static int bSearch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] < target)
            return bSearch(nums, mid + 1, right, target);
        return bSearch(nums, left, mid - 1, target);
    }

    public static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    public int findMin2(int[] nums) {
        Set<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Collections.min(temp);
    }
    /*
     * Second method
     * public int findMin(int[] nums) {
     * 
     * int i=0;
     * int j = nums.length-1;
     * 
     * while(i<=j)
     * {
     * int mid = i+(j-i)/2;
     * 
     * if(nums[mid]<nums[j])
     * {
     * j = mid;
     * }
     * else if(nums[mid]>nums[j])
     * {
     * i = mid+1;
     * }
     * else
     * j--;
     * }
     * 
     * return nums[i];
     * }
     * 
     * public static int tribonacci(int n) {
     * 
     * int[] arr = new int[n+1];
     * arr[0] = 0;
     * arr[1] = 1;
     * arr[2] = 1;
     * 
     * int result = 0;
     * for(int i = 3;i<=n;i++){
     * if(arr[i] != 0) {
     * result += arr[i];
     * }else{
     * result = arr[i-1]+ arr[i-2]+ arr[i-3];
     * arr[i] = result;
     * }
     * }
     * return result;
     * }
     * 
     */

    public static boolean searchMatrix(int[][] matrix, int target) {
        // l'idée est de chercher dans un row spécifique

        int temp = bSearchRows(matrix, 0, matrix.length - 1, target);
        if (temp != -1) {
            int temp2 = bSearch(matrix[temp], 0, matrix[0].length - 1, target);
            if (temp2 != -1)
                return true;
            return false;
        }
        return false;

    }

    public static int bSearchRows(int[][] nums, int left, int right, int target) {

        if (left > right)
            return right;
        int mid = (left + right) / 2;
        if (nums[mid][0] == target)
            return mid;
        if (nums[mid][0] < target)
            return bSearchRows(nums, mid + 1, right, target);
        return bSearchRows(nums, left, mid - 1, target);
    }

    public static int findPeakElement(int[] nums) {

        if (nums.length == 3) {
            if (nums[1] > nums[0] && nums[1] > nums[2])
                return 1;
            return 0;
        } else if (nums.length == 2) {
            if (nums[0] > nums[1])
                return 0;
            return 1;
        } else if (nums.length == 1) {
            return 0;
        }
        int left = 0;
        int right = nums.length;

        int n = nums.length;
        return findPeakUtil(nums, 0, n - 1, n);
    }

    public static int findPeakUtil(int arr[], int low, int high, int n) {
        // Find index of middle element
        // (low + high)/2
        int mid = low + (high - low) / 2;

        // Compare middle element with its
        // neighbours (if neighbours exist)
        if ((mid == 0 || arr[mid - 1] <= arr[mid])
                && (mid == n - 1 || arr[mid + 1] <= arr[mid]))
            return mid;

        // If middle element is not peak
        // and its left neighbor is
        // greater than it, then left half
        // must have a peak element
        else if (mid > 0 && arr[mid - 1] > arr[mid])
            return findPeakUtil(arr, low, (mid - 1), n);

        // If middle element is not peak
        // and its right neighbor
        // is greater than it, then right
        // half must have a peak
        // element
        else
            return findPeakUtil(
                    arr, (mid + 1), high, n);
    }

    public static int bSearchPeakElement(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;

        if (mid + 1 >= nums.length)
            mid = nums.length - 1;
        if (mid - 1 < 0)
            mid = 0;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        if (nums[mid] > nums[mid - 1])
            return bSearchPeakElement(nums, mid + 1, right);
        return bSearchPeakElement(nums, left, mid - 1);

    }

    public static int bSearchPeakElement2(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
            return mid;
        return bSearchPeakElement(nums, left, mid - 1);
    }

    public static boolean backspaceCompare(String s, String t) {
        int len = s.length();
        List l1 = new LinkedList<Character>();

        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != '#')
                l1.add(s.charAt(i));
            else {
                i--;
                if (i == 0)
                    i = 0;
            }
        }

        int len2 = t.length();
        List l2 = new LinkedList<Character>();
        for (int j = len2 - 1; j >= 0; j--) {
            if (t.charAt(j) != '#')
                l2.add(s.charAt(j));
            else {
                j--;
                if (j == 0)
                    j = 0;
            }
        }

        System.out.println(l1);
        System.out.println(l2);

        return (l1.toString()).equals(l2.toString());
    }

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null)
            return null;
        if (head.next == null) {
            return new ListNode(head.val);
        }

        ListNode list = new ListNode();

        int size = 0;
        ListNode tempHead = head;
        while (tempHead != null) {
            size++;
            tempHead = tempHead.next;
        }
        int[] arr = new int[size];

        tempHead = head;
        int i = 0;
        while (tempHead != null) {
            arr[i] = tempHead.val;
            i++;
            tempHead = tempHead.next;
        }
        ListNode l = new ListNode();

        boolean flag = false;
        if (arr[0] != arr[1]) {
            flag = true;
            l = new ListNode(arr[0]);
        }

        list = l;

        for (int j = 1; j < size - 1; j++) {
            if (arr[j + 1] != arr[j] && arr[j] != arr[j - 1]) {

                l.next = new ListNode(arr[j]);
                l = l.next;

            }
        }
        if (arr[size - 1] != arr[size - 2])
            l.next = new ListNode(arr[size - 1]);

        if (flag == false)
            return list.next;
        return list;
    }

    /*
     * public static String removeBackSpaces(String s){
     * 
     */
    /*
     * char[] res = s.toCharArray();
     * 
     * if(res[0] == '#')
     * char[] resuresult = Arrays.copyOfRange(res,1,res.length);
     * 
     * for(int i = 0; i < s.length();i++){
     * System.out.println(result[i]);
     * }
     *//*
        * 
        * 
        * return res.toString();
        * }
        */

    public static char[] removeTheElement(char[] arr, int index) {

        // If the array is empty
        // or the index is not in array range
        // return the original array
        if (arr == null || index < 0
                || index >= arr.length) {

            return (arr);
        }

        // Create another array of size one less
        char[] anotherArray = new char[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return (anotherArray);
    }

    public int countOdds(int low, int high) {

        if (low == high) {
            if (low % 2 != 0)
                return 1;
            return 0;
        }
        int counter = 0;

        if (low % 2 != 0 && high % 2 != 0)
            counter = (high - low) / 2 + 1;
        if (low % 2 != 0 && high % 2 == 0)
            counter = (high - low) / 2 + 1;

        if (low % 2 == 0 && high % 2 != 0)
            counter = (high - low) / 2 + 1;
        if (low % 2 == 0 && high % 2 == 0)
            counter = (high - low) / 2;

        return counter;
    }

    public static double average(int[] salary) {/*
                                                 * int min = Collections.min(Arrays.asList(salary));
                                                 * int max = Collections.max(Arrays.asList(salary));
                                                 */
        int min = IntStream.of(salary).min().orElse(Integer.MIN_VALUE);
        int max = IntStream.of(salary).max().orElse(Integer.MAX_VALUE);

        int average = 0;
        int counter = 0;

        for (int i : salary) {
            if (i == min || i == max)
                continue;
            average += i;
            counter++;
        }

        return (double) (average / counter);
    }

    public int hammingWeight(int n) {

        int counter = 0;
        String s = String.valueOf(Integer.toBinaryString(n));

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1')
                counter++;
        }

        return counter;

    }

    public int hammingWeight_JAVA(int n) {
        return Integer.bitCount(n);
    }

    public int subtractProductAndSum(int n) {

        int sum = 0;
        int product = 1;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            product *= Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        return product - sum;
    }

    public static boolean checkExistence(List<Integer> tempL, List<List<Integer>> list) {
        /*
         * int counter = 0;
         * 
         * for(List<Integer> l: list){
         * 
         * for(int i:l){
         * if(i== tempL.get(0) ||i== tempL.get(1) || i== tempL.get(2)){
         * counter++;
         * }
         * }
         * if(counter == 2) {
         * System.out.println(counter);
         * return true;
         * }
         * counter = 0;
         * }
         * return false;
         */
        Collections.sort(tempL);

        for (List<Integer> l : list) {
            Collections.sort(l);
            return l.equals(tempL);
        }
        return false;
    }

    public static void printList(List<Integer> l) {
        for (int i : l) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0)
            return new int[0][0];

        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int[] aHead = null;
        int[] bHead = null;
        while (i < n && j < m) {
            aHead = A[i];
            bHead = B[j];

            int[] intersect = { Math.max(aHead[0], bHead[0]), Math.min(aHead[1], bHead[1]) };
            if (intersect[0] <= intersect[1]) {
                // add intersect
                res.add(intersect);
            }

            if (aHead[1] < bHead[1]) {
                i++;
            } else if (aHead[1] == bHead[1]) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        int dim = res.size();
        int[][] finalRes = new int[dim][2];
        for (i = 0; i < dim; i++) {
            finalRes[i] = res.get(i);
        }
        return finalRes;
    }

    // The end of this function, you can test it with the following arrays:
    /*
     * [[0,2],[5,10],[13,23],[24,25],[30,55]]
     * [[1,5],[8,12],[15,24],[25,26]]
     */

    public int maxArea(int[] H) {
        int ans = 0, i = 0, j = H.length - 1, res = 0;
        while (i < j) {
            if (H[i] <= H[j]) {
                res = H[i] * (j - i);
                i++;
            } else {
                res = H[j] * (j - i);
                j--;
            }
            if (res > ans)
                ans = res;
        }
        return ans;
    }

    // 3NDNA n vertical ligne
    // ay line ( i,0) and (i,height[i]);
    // The maximum value the container can store at this part is not allowed to
    // become the most preferable at this point.
    // The first part of this question is not very important and the answer should
    // be something similar to this;
    // Find all the possible values
    // return the maximum value.

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = n - 1; i > 1; --i)
            if (nums[i] < nums[i - 1] + nums[i - 2])
                return nums[i] + nums[i - 1] + nums[i - 2];
        return 0;
    }

    /*
     * public int minSubArrayLen(int target, int[] nums) {
     * int ans = 0;
     * int sum = 0;
     * int k = 0;
     * int len = nums.length;
     * int i = 0;
     * for (i = 0; i < len; i++) {
     * sum += nums[i];
     * ans++;
     * 
     * if (sum >= target) {
     * k = i;
     * break;
     * }
     * }
     * 
     * if (sum < target && i == len)
     * return 0;
     * 
     * if (k == len && sum == target)
     * return ans;
     * 
     * int tempS = sum;
     * int tempK = k;
     * for (int j = k; j < len; j++) {
     * tempS -= nums[j - k];
     * if (tempS >= target) {
     * ans--;
     * } else {
     * tempS += nums[j];
     * 
     * if (tempS >= target)
     * for (int t = k; t < j; t++) {
     * tempS -= nums[t - k];
     * if (tempS >= target)
     * ans--;
     * else
     * tempS += nums[t - k];
     * }
     * }
     * 
     * }
     * 
     * return ans;
     * }
     */

    public static int OTMANE_TESTING() {
        return 0;
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    /*
     * public static int firstBadVersion(int n) {
     */
    /*
     * Input: n = 5, bad = 4
     * Output: 4
     * Explanation:
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * Then 4 is the first bad version.
     *//*
        * 
        * 
        * int left = 1;
        * int right = n;
        * 
        * 
        * while(left <= right)
        * {
        * int mid = left + (right-left)/2;
        * if(isBadVersion(mid)) {
        * if (!isBadVersion(mid - 1))
        * return mid;
        * right = mid - 1;
        * }else if ( !isBadVersion(mid)){
        * if(isBadVersion(mid+1))
        * return mid+1;
        * left = mid+1;
        * }
        * }
        * return -1;
        * }
        */

    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int lastChance = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            lastChance = mid;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target)
                right = mid - 1;
        }

        if (target > nums[lastChance])
            return lastChance + 1;
        return lastChance;
    }

    /*
     * 
     * string = " otmane erragragui";
     *
     *
     */
    /*
     * public static boolean isMatch(String s, String p) {
     * if(p.equals(".*")){
     * return true;
     * }
     * 
     * String[] strings0 = p.split();
     * 
     * String[] strings = = s.split(p)
     * 
     * return false;
     * }
     */

    /*
     * this is a simple test to test my application before the last term of index
     * before and after the radiation of this element and it could
     */

    /*
     * Find the index of the first non-negative number in the array.
     * Use two pointers to iterate over the array - one pointer will move forward to
     * iterate over the non-negative numbers, and the other pointer will move
     * backward to iterate over the negative numbers.
     * At any step, we check which pointer gives a smaller square. We add the
     * smaller square to the output array and advance the corresponding pointer.
     * 
     */

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;
        int firstNonNegative = n;
        // find the first non negative number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                firstNonNegative = i;
                break;
            }
        }
        // iterate over both of them
        int neg = firstNonNegative - 1;
        int pos = firstNonNegative;
        int index = 0;
        while (neg >= 0 && pos < n) {
            int posValueSquared = nums[pos] * nums[pos];
            int negValueSquared = nums[neg] * nums[neg];

            if (posValueSquared < negValueSquared) {
                result[index++] = posValueSquared;
                pos++;
            } else {
                result[index++] = negValueSquared;
                neg--;
            }
        }
        while (neg >= 0) {
            result[index++] = nums[neg] * nums[neg];
            neg--;
        }
        while (pos < n) {
            result[index++] = nums[pos] * nums[pos];
            pos++;
        }
        return result;
    }
    /*
     * Input: nums = [1,2,3,4,5,6,7], k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * 
     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0)
            return;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (i + k) % n;
            res[index] = nums[i];
        }
        for (int j = 0; j < n; j++)
            nums[j] = res[j];
    }
    /*
     * public void moveZeroes(int[] nums) {
     * int n = nums.length-1;
     * int pos2 = n;
     * int pos1 = 0;
     * while(pos2 <= pos1);{
     * if(nums[pos1] == 0 && nums[pos2]!=0){
     * int temp = nums[pos1];
     * nums[pos1] = nums[pos2];
     * nums[pos2] = ??? ?????????????????
     * 
     * }
     * }
     * }
     */

    public static int[] searchRange(int[] nums, int target) {
        int[] returnArray = new int[] { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        int leftInter = -1;
        int rightInter = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftInter = mid;
                rightInter = mid;
                int left1 = mid;
                int right1 = mid;
                while (left1 >= 0 && nums[left1] == target) {
                    leftInter = left1;
                    left1--;
                }
                while (right1 <= nums.length - 1 && nums[right1] == target) {
                    rightInter = right1;
                    right1++;
                }
                break;
            }
            if (nums[mid] < target) { // Second Half
                left = mid + 1;
            } else if (nums[mid] > target) {// First Half
                right = mid - 1;
            }
        }
        returnArray[0] = leftInter;
        returnArray[1] = rightInter;
        return returnArray;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int x = target - current;
            if (map.containsKey(x)) {
                return new int[] { map.get(x), i };
            }
            map.put(current, i);
        }
        return null;
    }

    public int[] twoSumII(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[] { l + 1, r + 1 };
            }
            if (sum > target)
                r--;
            else
                l++;
        }
        return null;
    }

    // Using the first approach of two pointers.

    // The array should BE SORTED.
    public List<List<Integer>> threeSum(int[] nums) {
        // Step Number ONE
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        }
        return res;
    }

    public void twoSumII(int[] numbers, int i, List<List<Integer>> res) {
        int l = i + 1, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[i] + numbers[l] + numbers[r];
            if (sum < 0) {
                ++l;
            } else if (sum > 0)
                --r;
            else {
                res.add(Arrays.asList(numbers[i], numbers[l++], numbers[r--]));
                while (l < r && numbers[l] == numbers[l - 1])
                    ++l;
            }
        }
    }
    // target = 7, nums = [2,3,1,2,4,3]

    public static int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int s = 0;
        // Using the accumlative sum of nums to remove a time exceeds.

        int sums[] = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++)
            sums[i] = sums[i - 1] + nums[i];

        // sums = [ 2, 5, 6, 8, 12, 15]
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                s = sums[j] - sums[i] + nums[i];
                if (s >= target) {
                    ans = Integer.min(ans, (j - i + 1));
                    break;
                }
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    // A good solution in O(n) using two pointers
    public static int minSubArrayLenII(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int l = 0, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Integer.min(ans, i - l + 1); // i-1+l is the current size of the array
                sum -= nums[l++];
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    /*
     *
     * = [[1,1,0],
     * [1,1,0],
     * [0,0,1]]
     * Output: 2
     *
     */
    public static int numIslands(char[][] grid) {
        int ans = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1')
                    ans++;
                dfs(grid, r, c);
            }
        }
        return ans;
    }

    public static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void dfsII(int[][] isConnected, int[] visited, int node) {
        int nr = isConnected.length;
        for (int i = 0; i < nr; i++) {
            if (isConnected[node][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                dfsII(isConnected, visited, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int ans = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfsII(isConnected, visited, i);
                ans++;
            }
        }
        return ans;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
            return root;

        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);
        // there is an element at least..
        while (Q.size() > 0) {
            // The size of the queue
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                // Pop a node from the front of the queue
                Node node = Q.poll();
                if (i < size - 1) {
                    node.next = Q.peek();
                }

                if (node.left != null)
                    Q.add(node.left);
                if (node.right != null)
                    Q.add(node.right);
            }
        }
        return root;
    }

    public int longestPalindrome(String s) {
        char[] converted = s.toCharArray();
        int len = converted.length, ans = 0;

        int[] count = new int[128];
        for (char c : converted) {
            if (++count[c] == 2) {
                ans += 2;
                count[c] = 0;
            }
        }

        return (ans == s.length()) ? ans : ans + 1;
    }
    // these changes are made for verification only.

    // public List<Integer> preorder(Node root) {
    // LinkedList<Node> stack = new LinkedList<>(); // Last In First OUT

    // LinkedList<Integer> output = new LinkedList<>();
    // if (root == null) {
    // return output;
    // } // clear

    // stack.add(root); // the stack contains all elements of the tree

    // // while the stack in not empty
    // while (!stack.isEmpty()) {
    // Node node = stack.pollLast();
    // System.out.println(" last Poll " + node.val);
    // // poll the last element // [1 2 3 4 ] => poll 4
    // output.add(node.val); // add it the the output => add 4 to the output

    // Collections.reverse(node.children); // reverse node.children =>
    // for (Node item : node.children) {
    // stack.add(item);
    // }
    // }
    // return output;
    // }

    // List<List<Integer>> levels = new ArrayList<List<Integer>>();

    // public void helper(TreeNode node, int level) {
    // // start the current level
    // if (levels.size() == level)
    // levels.add(new ArrayList<Integer>());

    // // fulfil the current level
    // levels.get(level).add(node.val);

    // // process child nodes for the next level
    // if (node.left != null)
    // helper(node.left, level + 1);
    // if (node.right != null)
    // helper(node.right, level + 1);
    // }

    // public List<List<Integer>> levelOrder(TreeNode root) {
    // if (root == null)
    // return levels;
    // helper(root, 0);
    // return levels;
    // }

    // public int firstBadVersion(int n) {

    // int left = 1;
    // int right = n;

    // while (left < right) {
    // int mid = left + (right - left) / 2;
    // if (isBadVersion(mid)) {
    // right = mid;
    // } else {
    // left = mid + 1;
    // }
    // }
    // return left;
    // }

    // public boolean validate(TreeNode root, Integer low, Integer high) {
    // // Empty trees are valid BSTs.
    // if (root == null) {
    // return true;
    // }
    // // The current node's value must be between low and high.
    // if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
    // return false;
    // }
    // // The left and right subtree must also be valid.
    // return validate(root.right, root.val, high) && validate(root.left, low,
    // root.val);
    // }

    // public boolean isValidBST(TreeNode root) {
    // return validate(root, null, null);
    // }

    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    // if (p.val < root.val && q.val < root.val)
    // return lowestCommonAncestor(root.left, p, q);
    // if (p.val > root.val && q.val > root.val)
    // return lowestCommonAncestor(root.right, p, q);
    // return root;
    // }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> inter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int x = target - current;

            if (inter.containsKey(x)) {
                return new int[] { inter.get(x), i };
            }
            inter.put(current, i);
        }
        return null;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np)
            return new ArrayList();

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
            pCount[(int) (ch - 'a')]++;
        }

        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
            // add one more letter
            // on the right side of the window
            sCount[(int) (s.charAt(i) - 'a')]++;
            // remove one letter
            // from the left side of the window
            if (i >= np) {
                sCount[(int) (s.charAt(i - np) - 'a')]--;
            }
            // compare array in the sliding window
            // with the reference array
            if (Arrays.equals(pCount, sCount)) {
                output.add(i - np + 1);
            }
        }
        return output;
    }

    public int numIslands2(char[][] grid) {
        int ans = 0;
        int nr = grid.length;
        int nc = grid[0].length;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1')
                    ans++;
                dfs(grid, r, c);
            }
        }
        return ans;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int nr = image.length;
        int nc = image[0].length;

        if (sr > nr || sc > nc)
            return image;

        if (color != image[sr][sc])
            dfs_fill(image, sr, sc, image[sr][sc], color);

        return image;
    }

    public static void dfs_fill(int[][] grid, int r, int c, int currentColor, int color) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] != currentColor) {
            return;
        }

        grid[r][c] = color;
        dfs_fill(grid, r - 1, c, currentColor, color);
        dfs_fill(grid, r + 1, c, currentColor, color);
        dfs_fill(grid, r, c - 1, currentColor, color);
        dfs_fill(grid, r, c + 1, currentColor, color);
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1; // reach 1 only one way step of 1
        dp[2] = 2; // reach 2 by two way 1+1 or 2

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int minimumCost[] = new int[cost.length + 1];

        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + cost[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }

    // Using a Dynamic prog approach we can solve this problem.
    public int uniquePaths(int m, int n) {
        // Iniitial Map.
        int[][] dp = new int[m][n];

        for (int[] arr : dp)
            Arrays.fill(arr, 1);
        for (int col = 1; col < m; ++col) {
            for (int row = 1; row < n; ++row) {
                dp[col][row] = dp[col - 1][row] + dp[col][row - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int characterReplacement(String s, int k) {
        int ans = 0;
        int[] char_count = new int[26];
        int N = s.length();
        int l = 0;
        int maxLength = 0;
        for (int r = 0; r < N; r++) {
            char_count[s.charAt(r) - 'A']++;
            int currentValue = char_count[s.charAt(r) - 'A'];
            maxLength = Math.max(maxLength, currentValue);
            while (((r - l + 1) - maxLength) > k) {
                char_count[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;

    }

    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap();
        for (char s : secret.toCharArray()) {
            h.put(s, h.getOrDefault(s, 0) + 1);
        }

        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int idx = 0; idx < n; ++idx) {
            char ch = guess.charAt(idx);
            if (h.containsKey(ch)) {
                // corresponding characters match
                if (ch == secret.charAt(idx)) {
                    // update the bulls
                    bulls++;
                    // update the cows
                    // if all ch characters from secret
                    // were used up
                    if (h.get(ch) <= 0)
                        cows--;
                    // corresponding characters don't match
                } else {
                    // update the cows
                    if (h.get(ch) > 0)
                        cows++;
                }
                // ch character was used
                h.put(ch, h.get(ch) - 1);
            }
        }

        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                List<Character> decodedString = new ArrayList<>();
                // get the encoded string
                while (stack.peek() != '[') {
                    decodedString.add(stack.pop());
                }
                // pop [ from the stack
                stack.pop();
                int base = 1;
                int k = 0;
                // get the number k
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                // decode k[decodedString], by pushing decodedString k times into stack
                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.push(decodedString.get(j));
                    }
                    k--;
                }
            }
            // push the current character to stack
            else {
                stack.push(s.charAt(i));
            }
        }
        // get the result from stack
        char[] result = new char[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    private int removeLargest(List<Integer> stones) {
        int indexOfLargest = stones.indexOf(Collections.max(stones));
        int result = stones.get(indexOfLargest);
        stones.set(indexOfLargest, stones.get(stones.size() - 1));
        stones.remove(stones.size() - 1);
        return result;
    }

    public int lastStoneWeight(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int weight : stones) {
            stoneList.add(weight);

        }

        while (stoneList.size() > 1) {
            int stone1 = removeLargest(stoneList);
            int stone2 = removeLargest(stoneList);
            if (stone1 != stone2) {
                stoneList.add(stone1 - stone2);
            }
        }
        return !stoneList.isEmpty() ? stoneList.remove(0) : 0;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                int Frequency1 = map.get(w1);
                int Frequency2 = map.get(w2);
                if (Frequency1 == Frequency2)
                    return w2.compareTo(w1);
                return Frequency1 - Frequency2;
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
            if (pq.size() > k)
                pq.poll();
        }
        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty())
            ans.add(pq.poll());
        Collections.reverse(ans);
        return ans;
    }

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            n = totalSquaredSum(n);
        }

        return n == 1;
    }

    // define a function that will resolve foreach n the value needed
    int totalSquaredSum(int n) {
        int total = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            total += d * d;
        }
        return total;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0;
        int left = 0;
        int right = columns - 1;
        int down = rows - 1;

        while (ans.size() < rows * columns) {
            // Traverse from left to right.
            for (int col = left; col <= right; col++) {
                ans.add(matrix[col][right]);
            }
            // Traverse downwards
            for (int row = up + 1; row <= down; row++) {
                ans.add(matrix[row][right]);
            }

            if (up != down) {
                // traverse from right to left
                for (int col = right - 1; col >= left; col--)
                    ans.add(matrix[down][col]);
            }
            if (left != right) {
                // Traverse upwards.
                for (int row = down - 1; row > up; row--) {
                    ans.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            up++;
            down--;
        }
        return ans;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int columns = matrix[0].length;
        int rows = matrix.length;
        int left = 0, up = 0, right = columns - 1, buttom = rows - 1;

        while (ans.size() < columns * rows) {

            for (int col = left; col <= right; col++) {
                ans.add(matrix[up][col]);
            }

            for (int row = up; row <= buttom; row++) {
                ans.add(matrix[row][right]);
            }

            if (up != buttom)
                for (int col = right - 1; col >= left; col--)
                    ans.add(matrix[buttom][col]);

            if (left != right)
                for (int row = buttom + 1; row > up; row--)
                    ans.add(matrix[row][left]);
        }

        return ans;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public String multiply(String num1, String num2) {

        return "";
    }

}
