package utils;

import java.awt.*;
import java.util.Random;

public final class RandomColorFactory {

    private static final Random random = new Random();

    private RandomColorFactory(){}

    /**
     * Generates a random color between (0, 0, 0) and (255, 255, 255) */
    public static Color createRandomColor() {
        int red, green, blue;
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);

        return new Color(red, green, blue);
    }

    /**
     * Generates a random color inside the range specified on the parameters.
     * If a range Dual.a > Dual.b, the color range will be 0 to 0. */
    public static Color createRandomcolor(Dual<Integer, Integer> redrange,
                                          Dual<Integer, Integer> greenrange,
                                          Dual<Integer, Integer> bluerange) {
        int red, green, blue;
        int redRandom, greenRandom, blueRandom;

        // The random values are generated manually because the Random.nextInt(int)
        // doesn't accept value 0 and some colors use this value.
        redRandom = (int)(Math.random() * Math.abs(redrange.getA() - redrange.getB()));
        greenRandom = (int)(Math.random() * Math.abs(greenrange.getA() - greenrange.getB()));
        blueRandom = (int)(Math.random() * Math.abs(bluerange.getA() - bluerange.getB()));

        // The equation finds the small value of the range
        // a and b are the 2 values of the range
        // c = abs(a-b)
        // (a+b-c)/2 is the small value of the range where i add the random value
        red = (((redrange.getA() + redrange.getB()) - Math.abs(redrange.getA() - redrange.getB())) / 2) + redRandom;
        green = (((greenrange.getA() + greenrange.getB()) - Math.abs(greenrange.getA() - greenrange.getB())) / 2) + greenRandom;
        blue = (((bluerange.getA() + bluerange.getB()) - Math.abs(bluerange.getA() - bluerange.getB())) / 2) + blueRandom;

        return new Color(red, green, blue);
    }

    /**
     * Creates a random color between the two colors passed on the parameters. */
    public static Color createRandomColor(Color colorA, Color colorB) {
        Dual<Integer, Integer> redRange, greenRange, blueRange;

        redRange = new Dual<>(colorA.getRed(), colorB.getRed());
        greenRange = new Dual<>(colorA.getGreen(), colorB.getGreen());
        blueRange = new Dual<>(colorA.getBlue(), colorB.getBlue());

        return createRandomcolor(redRange, greenRange, blueRange);
    }

}
