package com.telran;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

public class MaxElementCollection<T>{

    Deque<T> numbers;
    Deque<T> maxValue;
    Comparator<T> comparator;

    public MaxElementCollection(Comparator<T> comparator) {
        this.numbers = new ArrayDeque();
        this.maxValue = new ArrayDeque();
        this.comparator = comparator;
    }

    public MaxElementCollection() {
        this.numbers = new ArrayDeque();
        this.maxValue = new ArrayDeque();

    }

    public void addLast (T elt){
        if (numbers.size() == 0) {
            maxValue.addLast(elt);
        }else {
            T maxNumber = maxValue.getLast();
            if (comparator!= null && comparator.compare(maxNumber , elt) <=0
                    || ((Comparable<T>)maxNumber).compareTo(elt) <= 0){
                maxValue.addLast(elt);
            }
        }
        numbers.addLast(elt);
    }

    public T removeLast() throws EmptyCollectionException {
        if (numbers.size() == 0) throw new EmptyCollectionException();
        T lastNumber = numbers.removeLast();
        if (((comparator != null) && (comparator.compare(lastNumber, maxValue.getLast()) == 0))
                || (((Comparable<T>) lastNumber).compareTo(maxValue.getLast()) == 0)) {
            maxValue.removeLast();
        }
        return lastNumber;
    }

    public T getLast() throws EmptyCollectionException {
        if (numbers.size() == 0) throw  new EmptyCollectionException();
        return numbers.getLast();
    }

    public T getMax() throws EmptyCollectionException {
        if (numbers.size() == 0) throw  new EmptyCollectionException();
        else return maxValue.getLast();
    }

    public int size(){
        return numbers.size();
    }
}

