package utils;


import java.util.Objects;

/**
 * This class can encapsulate two Objects of any type inside.
 * We can see it like a java.awt.Point, but without operations for
 * a XY point, or a java.util.HashMap, but more simple because you
 * don't need to know a key to get a value. */
public class Dual <T1, T2> {

    private T1 a;
    private T2 b;

    /**
     * Creates a Dual with null values for a and b. */
    public Dual() {
        a = null;
        b = null;
    }

    /**
     * Calls to Dual() and creates a Dual with the objects specified
     * on the parameters. */
    public Dual(T1 objectA, T2 objectB) {
        this();
        a = objectA;
        b = objectB;
    }

    public void setA(T1 objectA) {
        a = objectA;
    }

    public void setB(T2 objectB) {
        b = objectB;
    }

    public T1 getA() {
        return a;
    }

    public T2 getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        boolean equals;
        if(!(o instanceof Dual)) {
            equals = false;
        } else {
            Dual tocompare = (Dual)o;
            equals = Objects.equals(a, tocompare.getA())
                        && Objects.equals(b, tocompare.getB());
        }

        return equals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append("a: ");
        sb.append(a.toString());
        sb.append(" b: ");
        sb.append(b.toString());
        sb.append(']');
        return sb.toString();
    }

}
