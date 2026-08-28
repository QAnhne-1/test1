package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayProcessorTest {

    private final ArrayProcessor processor = new ArrayProcessor();

    // --- Statement Coverage (Issue #1) ---
    @Test
    void testStatementCoverage_NullArray_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.sumEvenBelowThreshold(null, 10);
        });
    }

    @Test
    void testStatementCoverage_ArrayWithValidEvenNumber() {
        int[] input = {4};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(4, result);
    }

    // --- Path Coverage (Issue #2) ---
    // Đường 1: Mảng rỗng -> vòng lặp không chạy, trả về 0
    @Test
    void testPathCoverage_EmptyArray_ReturnsZero() {
        int[] input = {};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(0, result);
    }

    // Đường 2: Mảng chỉ chứa số lẻ -> điều kiện (num % 2 == 0) False
    @Test
    void testPathCoverage_OddNumbersOnly_Condition1False() {
        int[] input = {1, 3, 5};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(0, result);
    }

    // Đường 3: Mảng chứa số chẵn >= threshold -> điều kiện (num < threshold) False
    @Test
    void testPathCoverage_EvenNumbersAboveOrEqualThreshold_Condition2False() {
        int[] input = {10, 12, 14};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(0, result);
    }

    // Đường 4: Tổ hợp tất cả các nhánh trong một mảng
    @Test
    void testPathCoverage_CombinedPaths() {
        int[] input = {2, 3, 8, 10, 12};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(10, result);
    }
}