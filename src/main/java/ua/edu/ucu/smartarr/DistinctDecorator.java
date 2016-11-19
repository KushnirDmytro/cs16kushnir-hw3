package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }


    @Override
    public Object[] toArray() {
        //Object[] rawArray = this.smartArray.toArray();
        ArrayList <Object> rawArray = new ArrayList<Object>();
        return new Object[0];
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription().concat(" deleted repeatings ");
    }
}
