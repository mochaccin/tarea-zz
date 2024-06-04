package com.example.demo.services.serviceImpls;

import com.example.demo.Utils;
import com.example.demo.models.Point;
import com.example.demo.models.RegressionResult;
import com.example.demo.services.RegressionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegressionServiceImpl implements RegressionService {
    @Override
    public RegressionResult calculateLinearRegression(List<Point> points) {

        if (points.isEmpty()) {
            return new RegressionResult(0, 0);
        }

        if (points.size() == 1) {
            return new RegressionResult(0, points.get(0).getY());
        }

        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumX2 = 0;
        int n = points.size();

        for (Point point : points) {
            sumX += point.getX();
            sumY += point.getY();
            sumXY += point.getX() * point.getY();
            sumX2 += point.getX() * point.getX();
        }

        double denominator = (n * sumX2 - sumX * sumX);
        if (denominator == 0) {
            return new RegressionResult(Double.NaN, Double.NaN);
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        slope = Utils.INSTANCE.round(slope, 3);
        intercept = Utils.INSTANCE.round(intercept, 3);

        return new RegressionResult(slope, intercept);
    }
}
