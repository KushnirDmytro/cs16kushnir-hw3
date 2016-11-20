package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {


    public static String descriptionFilterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        return sa.operationDescription();
    }

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String
    descriptionFindDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate mp = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((((Student) t).getYear() == 2) &&
                        ((Student) t).getGPA() >= 4.0);
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);

        studentSmartArray = new SortDecorator(
                new DistinctDecorator(
                        new FilterDecorator(studentSmartArray, mp)
                ), cmp);
        return studentSmartArray.operationDescription();
    }


    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        MyPredicate mp = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((((Student) t).getYear() == 2) &&
                        ((Student) t).getGPA() >= 4.0);
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);

        studentSmartArray = new SortDecorator(
                new DistinctDecorator(
                        new FilterDecorator(studentSmartArray, mp)
                ), cmp);


        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentSmartArray.toArray();
        String[] resultNames = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            resultNames[i] = ((Student) result[i]).getSurname() + " " + ((Student) result[i]).getName();
        }
        return resultNames;
    }
}
