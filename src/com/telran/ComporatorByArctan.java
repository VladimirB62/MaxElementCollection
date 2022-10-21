package com.telran;

import java.util.Comparator;

public class ComporatorByArctan implements Comparator<RemotePoints> {
    @Override
    public int compare(RemotePoints o1, RemotePoints o2) {
        return (int) (o1.getArctanOffTheCorner()- o2.getArctanOffTheCorner());
    }
}
