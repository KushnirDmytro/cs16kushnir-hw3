package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
    MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> rawArray = new ArrayList<Object>();
        for (Object element : this.smartArray.toArray()){
            if (this.predicate.test(element)){
                rawArray.add(element);
            }
        }
        return rawArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription().concat(" deleted filter applied ");
    }
}
