package com.example.demo.services;

import com.example.demo.models.Point;
import com.example.demo.models.RegressionResult;

import java.util.List;

public interface RegressionService {

    RegressionResult calculateLinearRegression(List<Point> points);

}
