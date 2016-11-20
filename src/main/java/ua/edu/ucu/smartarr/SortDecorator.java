package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }

    @Override
    public Object[] toArray() {
        Object[] rawArray = this.smartArray.toArray();
        Arrays.sort(rawArray, comparator); // Assume it works
        return rawArray;
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription().concat(" sorted ");
    }
}
