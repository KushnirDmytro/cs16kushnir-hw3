package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> rawArray = new ArrayList<>();
        for (Object element : this.smartArray.toArray()) {
            rawArray.add(this.function.apply(element));
        }
        return rawArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription().concat(" mapping via function applied ");
    }
}
