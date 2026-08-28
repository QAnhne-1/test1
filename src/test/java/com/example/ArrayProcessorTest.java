package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayProcessorTest {

    private final ArrayProcessor processor = new ArrayProcessor();

    // Bao phủ dòng lệnh ném ngoại lệ khi mảng null
    @Test
    void testStatementCoverage_NullArray_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            processor.sumEvenBelowThreshold(null, 10);
        });
    }

    // Bao phủ dòng lệnh tính tổng bên trong vòng lặp
    @Test
    void testStatementCoverage_ArrayWithValidEvenNumber() {
        int[] input = {4};
        int result = processor.sumEvenBelowThreshold(input, 10);
        assertEquals(4, result);
    }
}