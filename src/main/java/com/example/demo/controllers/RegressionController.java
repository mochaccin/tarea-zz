package com.example.demo.controllers;

import com.example.demo.models.Point;
import com.example.demo.models.RegressionResult;
import com.example.demo.services.serviceImpls.RegressionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/regression")
public class RegressionController {

    @Autowired
    RegressionServiceImpl RegressionService;

    @PostMapping("/linear")
    public ResponseEntity<?> calculateLinearRegression(@RequestBody List<Point> points) {

        return ResponseEntity.ok(RegressionService.calculateLinearRegression(points));

    }

}
