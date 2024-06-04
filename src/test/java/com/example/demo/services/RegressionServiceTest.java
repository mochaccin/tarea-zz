package com.example.demo.services;

import com.example.demo.Utils;
import com.example.demo.models.Point;
import com.example.demo.models.RegressionResult;
import com.example.demo.services.serviceImpls.RegressionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegressionServiceTest {

    List<Point> points;
    RegressionServiceImpl regressionService = new RegressionServiceImpl();

    @BeforeEach
    void setUp() {
        points = Utils.INSTANCE.generatePointsList();
    }

    @AfterEach
    void tearDown() {
        points = null;
    }

    @Test
    void calculateLinearRegressionNoPoints() {
        points.clear();
        assertEquals(new RegressionResult(0, 0), regressionService.calculateLinearRegression(points));
    }

    @Test
    void calculateLinearRegressionOnePoint() {
        points.clear();
        points.add(new Point(1,4));
        assertEquals(new RegressionResult(0, 4), regressionService.calculateLinearRegression(points));
    }

    @Test
    public void testTwoPoints() {
        points.clear();
        points.add(new Point(1, 2));
        points.add(new Point(2, 4));

        assertEquals(new RegressionResult(2, 0), regressionService.calculateLinearRegression(points));
    }

    @Test
    public void testColinearPoints() {
        points.clear();
        points.add(new Point(1, 2));
        points.add(new Point(2, 4));
        points.add(new Point(3, 6));

        assertEquals(new RegressionResult(2,0), regressionService.calculateLinearRegression(points));
    }

    @Test
    public void testSameXValues() {
        points.clear();
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));

        RegressionResult result = regressionService.calculateLinearRegression(points);

        assertTrue(Double.isNaN(result.getSlope()));
        assertTrue(Double.isNaN(result.getIntercept()));
    }

    @Test
    public void testSameYValues() {
        points.clear();
        points.add(new Point(1, 2));
        points.add(new Point(2, 2));

        assertEquals(new RegressionResult(0, 2), regressionService.calculateLinearRegression(points));
    }

}