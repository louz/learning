package io.jasonlu.scalajdk8patterns.java;

/**
 * Created by louz on 2016/10/9.
 */
public class JavaClosureFunction {
    public static void main(String[] args) {
        /* JDK 7 mode
        BaseFunction baseFunction = new BaseFunction() {
            @Override
            public String call(int i) {
                return "This is string: " + i;
            }
        };
        */

        // JDK 8 mode
        BaseFunction baseFunction = i -> "This is string: " + i;

        ClosureFunction closureFunction = makeClosureFunction(100, baseFunction);
        System.out.println(closureFunction.call(10));
    }

    private static ClosureFunction makeClosureFunction(int i, BaseFunction baseFunction) {
        /* JDK 7 mode
        return new ClosureFunction() {
            @Override
            public String call(int x) {
                return baseFunction.call(x * i);
            }
        };
        */

        // JDK 8 mode
        return x -> baseFunction.call(x * i);
    }
}
