package com.example.demo;

import com.example.demo.models.Point;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public enum Utils {
    INSTANCE;

    public double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public List<Point> generatePointsList() {

        List<Point> points = new ArrayList<>();

        points.add(new Point(0, 0.692847));
        points.add(new Point(1, 0.224987));
        points.add(new Point(2, 0.574601));
        points.add(new Point(3, 0.624027));
        points.add(new Point(4, 0.097651));
        points.add(new Point(5, 0.071073));
        points.add(new Point(6, 0.133361));
        points.add(new Point(7, 0.206941));
        points.add(new Point(8, 0.961896));
        points.add(new Point(9, 0.438111));
        points.add(new Point(10, 0.059712));
        points.add(new Point(11, 0.912941));
        points.add(new Point(12, 0.894481));
        points.add(new Point(13, 0.521333));

        return points;
    }
}
