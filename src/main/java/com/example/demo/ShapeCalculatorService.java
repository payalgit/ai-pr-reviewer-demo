package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;

@Service
public class ShapeCalculatorService {

    public double area(String shape, Map<String, String> dimensions) {
        return switch (shape.toLowerCase(Locale.ROOT)) {
            case "circle" -> Math.PI * square(required(dimensions, "radius"));
            case "rectangle" -> required(dimensions, "length") * required(dimensions, "width");
            case "square" -> square(required(dimensions, "side"));
            case "triangle" -> 0.5 * required(dimensions, "base") * required(dimensions, "height");
            default -> throw new IllegalArgumentException("Unsupported 2D shape: " + shape);
        };
    }

    public double volume(String shape, Map<String, String> dimensions) {
        return switch (shape.toLowerCase(Locale.ROOT)) {
            case "sphere" -> (4.0 / 3.0) * Math.PI * cube(required(dimensions, "radius"));
            case "cube" -> cube(required(dimensions, "side"));
            case "cylinder" -> Math.PI * square(required(dimensions, "radius")) * required(dimensions, "height");
            case "rectangular-prism" -> required(dimensions, "length")
                    * required(dimensions, "width")
                    * required(dimensions, "height");
            default -> throw new IllegalArgumentException("Unsupported 3D shape: " + shape);
        };
    }

    private double required(Map<String, String> dimensions, String name) {
        String rawValue = dimensions.get(name);
        double value;
        try {
            value = Double.parseDouble(rawValue);
        } catch (NumberFormatException | NullPointerException exception) {
            throw new IllegalArgumentException("Dimension must be a positive number: " + name);
        }
        if (!Double.isFinite(value) || value <= 0) {
            throw new IllegalArgumentException("Dimension must be a positive number: " + name);
        }
        return value;
    }

    private double square(double value) {
        return value * value;
    }

    private double cube(double value) {
        return value * value * value;
    }
}
