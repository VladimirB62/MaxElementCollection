package com.telran;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxElementCollectionTest {
    private ComporatorByArctan comparator = new ComporatorByArctan();

    MaxElementCollection<RemotePoints> maxElementCollection = new MaxElementCollection(comparator);
    MaxElementCollection<RemotePoints> maxElementCollection1 = new MaxElementCollection();


    RemotePoints point1 = new RemotePoints(5, 5);
    RemotePoints point2 = new RemotePoints(-5, 5);
    RemotePoints point3 = new RemotePoints(-5, -5);
    RemotePoints point4 = new RemotePoints(5, -5);
    RemotePoints point5 = new RemotePoints(5, 0);
    RemotePoints point6 = new RemotePoints(0, 5);
    RemotePoints point7 = new RemotePoints(-5, 0);
    RemotePoints point8 = new RemotePoints(0, -5);
    RemotePoints point9 = new RemotePoints(6, -8);
    List<RemotePoints> points = new ArrayList<>();

    @Test
    void addLast() throws EmptyCollectionException {
        maxElementCollection.addLast(point1);
        maxElementCollection.addLast(point2);
        maxElementCollection.addLast(point3);
        maxElementCollection.addLast(point4);
        maxElementCollection.addLast(point5);
        maxElementCollection.addLast(point6);
        maxElementCollection.addLast(point7);
        maxElementCollection.addLast(point8);

        assertEquals(315, maxElementCollection.getMax().getArctanOffTheCorner());

    }

    @Test
    void addLastWithoutComporator() throws EmptyCollectionException {
        maxElementCollection1.addLast(point6);
        maxElementCollection1.addLast(point1);
        maxElementCollection1.addLast(point2);
        maxElementCollection1.addLast(point3);
        maxElementCollection1.addLast(point4);
        maxElementCollection1.addLast(point5);
        maxElementCollection1.addLast(point6);
        maxElementCollection1.addLast(point9);
        maxElementCollection1.addLast(point8);
        assertEquals(10, maxElementCollection1.getMax().getDistanceToPoint());
    }

    @Test
    void removeLast() throws EmptyCollectionException {
        maxElementCollection.addLast(point1);
        maxElementCollection.addLast(point2);
        maxElementCollection.addLast(point3);
        maxElementCollection.addLast(point4);
        maxElementCollection.addLast(point5);
        maxElementCollection.addLast(point6);
        maxElementCollection.addLast(point7);
        maxElementCollection.addLast(point8);
        maxElementCollection.removeLast();
        maxElementCollection.removeLast();
        maxElementCollection.removeLast();
        maxElementCollection.removeLast();
        assertEquals(315, maxElementCollection.getMax().getArctanOffTheCorner());
    }

    @Test
    void removeLast1() throws EmptyCollectionException {
        maxElementCollection1.addLast(point6);
        maxElementCollection1.addLast(point1);
        maxElementCollection1.addLast(point2);
        maxElementCollection1.addLast(point3);
        maxElementCollection1.addLast(point4);
        maxElementCollection1.addLast(point5);
        maxElementCollection1.addLast(point6);
        maxElementCollection1.addLast(point9);
        maxElementCollection1.addLast(point8);
        maxElementCollection1.removeLast();
        assertEquals(10, maxElementCollection1.getMax().getDistanceToPoint());
    }

}
