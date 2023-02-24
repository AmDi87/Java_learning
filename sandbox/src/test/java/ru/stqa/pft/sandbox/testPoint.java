package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


import java.awt.*;

@Test
public class testPoint {

    public void DistanceTest() {
        Point P1 = new Point(-6,2);
        Point P2 = new Point(0,7);
        Assert.assertEquals(P1.distance(P2),7.810249675906654);
    }

    public void DistanceTest2() {
        Point P1 = new Point(0,0);
        Point P2 = new Point(0,0);
        Assert.assertEquals(P1.distance(P2),0);
        Assert.assertTrue(P1.distance(P2) > 1);
    }

    public void DistanceTest3() {
        Point P1 = new Point(-3,2);
        Point P2 = new Point(2,2);
        Assert.assertEquals(P1.distance(P2),5);
    }

}
