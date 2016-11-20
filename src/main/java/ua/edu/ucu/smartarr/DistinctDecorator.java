package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> rawArray = new ArrayList<Object>(Arrays.asList(this.smartArray.toArray()));
        int indx = 0;
        for (int i = 0; i < rawArray.size(); i++) {
            while (rawArray.lastIndexOf(rawArray.get(i)) != indx) {
                rawArray.remove(rawArray.lastIndexOf(rawArray.get(i)));
            }
            indx++;
        }
        return rawArray.toArray();
    }

    @Override
    public String operationDescription() {
        return this.smartArray.operationDescription().concat(" deleted repeatings ");
    }
}
