package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/shapes")
public class ShapeController {

    private final ShapeCalculatorService calculatorService;

    public ShapeController(ShapeCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/{shape}/area")
        public ResponseEntity<Double> area(
            @PathVariable String shape,
            @RequestParam Map<String, String> dimensions) {
        return ResponseEntity.ok(calculatorService.area(shape, dimensions));
    }

    @GetMapping("/{shape}/volume")
    public ResponseEntity<Double> volume(
            @PathVariable String shape,
            @RequestParam Map<String, String> dimensions) {
        return ResponseEntity.ok(calculatorService.volume(shape, dimensions));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleInvalidRequest(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
