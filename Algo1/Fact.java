package Algo1;

import static java.lang.System.currentTimeMillis;

import java.util.HashSet;
import java.util.Set;

public class Fact {

    public static double facto(int a) {

        if (a == 0 || a == 1)
            return 1;
        return a * facto(a - 1);
    }

    /*
     * public static double DL(int e){
     * return new Double (0);
     * }
     */

    public static void main(String[] args) {
        double e = System.nanoTime();
        double res = facto(1000);

        double ee = System.nanoTime() - e;

        double e2 = System.nanoTime();
        System.out.println("---------------");
        // factorial(400);
        System.out.println("---------------");

        double e3 = System.nanoTime() - e2;

        System.out.println("1. " + ee);
        System.out.println("2. " + e3);

        // 8.1591528e+47
    }

    static void factorial(int n) {
        int res[] = new int[500];

        // Initialize result
        res[0] = 1;
        int res_size = 1;
        // Apply simple factorial formula
        // n! = 1 * 2 * 3 * 4...*n
        for (int x = 2; x <= n; x++)
            res_size = multiply(x, res, res_size);

        System.out.println("Factorial of given number is ");
        for (int i = res_size - 1; i >= 0; i--)
            System.out.print(res[i]);
    }

    static int multiply(int x, int res[], int res_size) {
        int carry = 0; // Initialize carry

        // One by one multiply n with individual
        // digits of res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10; // Store last digit of
            // 'prod' in res[]
            carry = prod / 10; // Put rest in carry
        }

        // Put carry in res and increase result size
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int m = -1;
        int right = nums.length - 1;
        if (target == nums[right])
            return right;
        else if (target > nums[right]) {
            return right + 1;
        }
        if (target == nums[left])
            return left;
        else if (target < nums[left]) {
            return left;
        }

        System.out.println(right);

        while (left <= right) {
            m = left + (right - left) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] > target)
                right = m - 1;
            else
                left = m + 1;
        }

        return left;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
 
    public ListNode detectCycle(ListNode head) {

        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;

        while(node != null){
            if(visited.contains(node))
                return node;
            visited.add(node);
            node = node.next;
        }

        
        return null;
    }
    
 
} 
