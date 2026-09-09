package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeCalculatorServiceTests {

    private final ShapeCalculatorService service = new ShapeCalculatorService();

    @Test
    void calculatesRectangleArea() {
        assertEquals(12.0, service.area("rectangle", Map.of("length", "3", "width", "4")));
    }

    @Test
    void calculatesCylinderVolume() {
        assertEquals(4 * Math.PI, service.volume("cylinder", Map.of("radius", "1", "height", "4")));
    }

    @Test
    void rejectsNonPositiveDimensions() {
        assertThrows(IllegalArgumentException.class,
                () -> service.area("circle", Map.of("radius", "0")));
    }
}
