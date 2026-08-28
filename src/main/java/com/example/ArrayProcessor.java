package com.example;

public class ArrayProcessor {
    public int sumEvenBelowThreshold(int[] numbers, int threshold) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int sum = 0;
        for (int num : numbers) {
            if (num % 2 == 0 && num < threshold) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayProcessor processor = new ArrayProcessor();
        int[] testArr = {2, 5, 8, 10, 15};
        int threshold = 10;
        System.out.println("Result: " + processor.sumEvenBelowThreshold(testArr, threshold));
    }
}