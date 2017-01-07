package io.jasonlu.scalajdk8patterns.java;

/**
 * Created by louz on 2016/10/10.
 */
public class ImmutableObject {
    private final int a;    // required
    private final int b;    // required
    private final int c;    // optional
    private final int d;    // optional
    private final int e;    // optional

    private ImmutableObject(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    @Override
    public String toString() {
        return "ImmutableObject{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                '}';
    }

    public static class Builder {
        private final int a;
        private final int b;

        // 可以设置默认值
        private int c = 1;
        private int d = 2;
        private int e = 3;

        public Builder(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Builder c(int c) {
            this.c = c;
            return this;
        }

        public Builder d(int d) {
            this.d = d;
            return this;
        }

        public Builder e(int e) {
            this.e = e;
            return this;
        }

        public ImmutableObject build() {
            return new ImmutableObject(this);
        }
    }

    public static void main(String[] args) {
        ImmutableObject obj = new Builder(10, 20)
                .c(30)
                .d(40)
                .build();

        System.out.println(obj);
    }

}
