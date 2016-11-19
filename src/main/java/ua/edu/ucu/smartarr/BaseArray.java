package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] val = null;

    public BaseArray(Object[] val) {
        this.val = val;
    }

    @Override
    public Object[] toArray() {
        return this.val.clone();
    }

    @Override
    public String operationDescription() {
        return "base array"; //actually  nothing done on this step
    }

    @Override
    public int size() {
        return this.val.length;//returns size of val array
    }
}
