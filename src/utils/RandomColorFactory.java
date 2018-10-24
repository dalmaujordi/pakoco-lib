package utils;

import javafx.util.Pair;

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
     * Generates a random color inside the range specified on the parameters. */
    public static Color createRandomcolor(Pair<Integer, Integer> redrange,
                                          Pair<Integer, Integer> greenrange,
                                          Pair<Integer, Integer> bluerange) {
        int red, green, blue;
        int redRandom, greenRandom, blueRandom;

        // The random values are generated manually because the Random.nextInt(int)
        // doesn't accept value 0 and some colors use this value.
        redRandom = (int)(Math.random() * Math.abs(redrange.getKey() - redrange.getValue()));
        greenRandom = (int)(Math.random() * Math.abs(greenrange.getKey() - greenrange.getValue()));
        blueRandom = (int)(Math.random() * Math.abs(bluerange.getKey() - bluerange.getValue()));

        // The equation finds the small value of the range
        // a and b are the 2 values of the range
        // c = abs(a-b)
        // (a+b-c)/2 is the small value of the range where i add the random value
        red = (((redrange.getKey() + redrange.getValue()) - Math.abs(redrange.getKey() - redrange.getValue())) / 2) + redRandom;
        green = (((greenrange.getKey() + greenrange.getValue()) - Math.abs(greenrange.getKey() - greenrange.getValue())) / 2) + greenRandom;
        blue = (((bluerange.getKey() + bluerange.getValue()) - Math.abs(bluerange.getKey() - bluerange.getValue())) / 2) + blueRandom;

        return new Color(red, green, blue);
    }

    /**
     * Creates a random color between the two colors passed on the parameters. */
    public static Color createRandomColor(Color colorA, Color colorB) {
        Pair<Integer, Integer> redRange, greenRange, blueRange;

        redRange = new Pair<>(colorA.getRed(), colorB.getRed());
        greenRange = new Pair<>(colorA.getGreen(), colorB.getGreen());
        blueRange = new Pair<>(colorA.getBlue(), colorB.getBlue());

        return createRandomcolor(redRange, greenRange, blueRange);
    }

}
