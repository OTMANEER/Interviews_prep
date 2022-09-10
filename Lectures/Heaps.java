package Lectures;

import java.util.PriorityQueue;

import javax.sound.midi.MetaEventListener;

import java.util.Collections;

public class Heaps {
    // Code for Min Heap

    public static void minHeap() {
        // Construct an instance of Min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add 3，1，2 respectively to the Min Heap
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);

        // Check all elements in the Min Heap, the result is [1, 3, 2]
        System.out.println("minHeap: " + minHeap.toString());

        // Get the top element of the Min Heap
        int peekNum = minHeap.peek();

        // The result is 1
        System.out.println("peek number: " + peekNum);

        // Delete the top element in the Min Heap
        int pollNum = minHeap.poll();

        // The reult is 1
        System.out.println("poll number: " + pollNum);

        // Check the top element after deleting 1, the result is 2
        System.out.println("peek number: " + minHeap.peek());

        // Check all elements in the Min Heap, the result is [2,3]
        System.out.println("minHeap: " + minHeap.toString());

        // Check the number of elements in the Min Heap
        // Which is also the length of the Min Heap
        int heapSize = minHeap.size();

        // The result is 2
        System.out.println("minHeap size: " + heapSize);

        // Check if the Min Heap is empty
        boolean isEmpty = minHeap.isEmpty();

        // The result is false
        System.out.println("isEmpty: " + isEmpty);
    }

    // Code for Max Heap

    public static void maxHeap() {
        // Construct an instance of Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add 1，3，2 respectively to the Max Heap
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);

        // Check all elements in the Max Heap, the result is [3, 1, 2]
        System.out.println("maxHeap: " + maxHeap.toString());

        // Get the top element of the Max Heap
        int peekNum = maxHeap.peek();

        // The result is 3
        System.out.println("peek number: " + peekNum);

        // Delete the top element in the Max Heap
        int pollNum = maxHeap.poll();

        // The reult is 3
        System.out.println("poll number: " + pollNum);

        // Check the top element after deleting 3, the result is 2
        System.out.println("peek number: " + maxHeap.peek());

        // Check all elements in the Max Heap, the result is [2,1]
        System.out.println("maxHeap: " + maxHeap.toString());

        // Check the number of elements in the Max Heap
        // Which is also the length of the Max Heap
        int heapSize = maxHeap.size();

        // The result is 2
        System.out.println("maxHeap size: " + heapSize);

        // Check if the Max Heap is empty
        boolean isEmpty = maxHeap.isEmpty();

        // The result is false
        System.out.println("isEmpty: " + isEmpty);
    }

    public static void main(String[] args) {
        System.out.println("--------------------------------> Min Heap");
        minHeap();
        System.out.println("--------------------------------> Max Heap");
        maxHeap();
    }
}
