package task2;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @org.junit.jupiter.api.Test
    void quickSortTest1() {
        int [] arr = {12, 5, 8, 2, 22, 9, 3, 1, 10, 55, 11};
        int [] expected ={1,2,3,5,8,9,10,11,12,22,55};
        Task2.quickSort(arr,0,arr.length-1);
        assertArrayEquals(expected,arr);
    }
    @org.junit.jupiter.api.Test
    void quickSortTest2() {
        int [] arr = {9,2,9,3,5,7,3,9,5,1,2,2,1};
        int [] expected ={1,1,2,2,2,3,3,5,5,7,9,9,9};
        Task2.quickSort(arr,0,arr.length-1);
        assertArrayEquals(expected,arr);
    }

    @org.junit.jupiter.api.Test
    void matrixBubbleSortTest1() {
        int[][] expected ={{1,2,3},{4,5,6},{7,8,9}};
        int[][] actual = {{6,7,1},{8,9,2},{3,5,4}};
        Task2.matrixBubbleSort(actual);
        assertArrayEquals(expected,actual);
    }
    @org.junit.jupiter.api.Test
    void matrixBubbleSortTest2() {
        int[][] expected ={{1,2,2},{5,5,6},{7,9,9}};
        int[][] actual = {{2,6,5},{9,7,9},{2,5,1}};
        Task2.matrixBubbleSort(actual);
        assertArrayEquals(expected,actual);
    }
}