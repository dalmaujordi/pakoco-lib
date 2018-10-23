package utils;

public final class LogicalOperators {

    private LogicalOperators(){}

    /**
     * Returns the a&&b logic operation (and). */
    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    /**
     * Returns the a||b logic operation (or). */
    public static boolean or(boolean a, boolean b) {
        return a || b;
    }

    /**
     * Returns the !(a&&b) logic operation (nand). */
    public static boolean nand(boolean a, boolean b) {
        return !(a && b);
    }

    /**
     * Returns the !(a||b) logic operation (nor). */
    public static boolean nor(boolean a, boolean b) {
        return !(a || b);
    }

    /**
     * Returns the (a||b)&&(!(a&&b)) logic operation (xor). */
    public static boolean xor(boolean a, boolean b) {
        return (a || b)&&(!(a && b));
    }

    /**
     * Validates the parameters, and if parameters.length<2, throws IllegalArgumentException. */
    private static void validateLogicOperationArguments(boolean[] parameters) {
        if(parameters.length < 2) {
            throw new IllegalArgumentException("Cannot do any logic operation with less then 2 arguments: "
                    +parameters.length+" given.");
        }
    }

    /**
     * Returns the and logic operation result with the booleans on the parameters.
     * If the length of the parameters is 1 or 0, throws IllegalArgumentException. */
    public static boolean and(boolean ... booleans) {
        boolean aux = false;
        validateLogicOperationArguments(booleans);
        aux = booleans[0];
        for(boolean b:booleans) {
            aux = and(aux, b);
        }
        return aux;
    }

    /**
     * Returns the or logic operation result with the booleans on the parameters.
     * If the length of the parameters is 1 or 0, throws IllegalArgumentException. */
    public static boolean or(boolean ... booleans) {
        boolean aux = false;
        validateLogicOperationArguments(booleans);
        aux = booleans[0];
        for(boolean b:booleans) {
            aux = or(aux, b);
        }
        return aux;
    }

    /**
     * Returns the nand logic operation result with the booleans on the parameters.
     * If the length of the parameters is 1 or 0, throws IllegalArgumentException. */
    public static boolean nand(boolean ... booleans) {
        boolean aux = false;
        validateLogicOperationArguments(booleans);
        aux = booleans[0];
        for(boolean b:booleans) {
            aux = nand(aux, b);
        }
        return aux;
    }

    /**
     * Returns the nor logic operation result with the booleans on the parameters.
     * If the length of the parameters is 1 or 0, throws IllegalArgumentException. */
    public static boolean nor(boolean ... booleans) {
        boolean aux = false;
        validateLogicOperationArguments(booleans);
        aux = booleans[0];
        for(boolean b:booleans) {
            aux = nor(aux, b);
        }
        return aux;
    }

    /**
     * Returns the xor logic operation result with the booleans on the parameters.
     * If the length of the parameters is 1 or 0, throws IllegalArgumentException. */
    public static boolean xor(boolean ... booleans) {
        boolean aux = false;
        validateLogicOperationArguments(booleans);
        aux = booleans[0];
        for(boolean b:booleans) {
            aux = xor(aux, b);
        }
        return aux;
    }

}
