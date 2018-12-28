package edu.ndsu;

import java.awt.image.BufferedImage;
import java.util.Random;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class ImageGenerator {

    //TODO: Optimize image generation - it takes forever to produce decent rerenders.
    //TODO: Implement different image rerendering techniques, such as via circles or triangles
    //TODO: Implement an option that allows the user to watch the image being generated in real time
    //TODO: Implement an option that allows the user to generate an image using the average RGB value of a subsection instead of random RGB values

    public static BufferedImage generateImage(BufferedImage original, int iterations) {
        int height = original.getHeight();
        int width = original.getWidth();
        BufferedImage generated = new BufferedImage(width, height, TYPE_INT_RGB);
        Random r = new Random();
        int xA, xB, yA, yB;

        for(int i = 0; i < iterations; i++) {
            xA = r.nextInt(width);
            xB = r.nextInt(width);
            yA = r.nextInt(height);
            yB = r.nextInt(height);

            pasteRectangle(original, generated, Math.min(xA, xB), Math.min(yA, yB), Math.max(xA, xB), Math.max(yA, yB), r.nextInt(16777216));
        }

        return generated;
    }

    private static void pasteRectangle(BufferedImage original, BufferedImage generated, int x1, int y1, int x2, int y2, int rgbNew) {
        long resemblance = 0L;
        int rgbOrig;
        int rgbGen;

        for(int y = y1; y <= y2; y++) {
            for(int x = x1; x <= x2; x++) {
                    rgbOrig = original.getRGB(x, y);
                    rgbGen = generated.getRGB(x, y);
                    resemblance += getContrast(rgbOrig, rgbGen) - getContrast(rgbOrig, rgbNew);
            }
        }

        if(resemblance > 0) {
            for(int y = y1; y <= y2; y++) {
                for(int x = x1; x <= x2; x++) {
                    generated.setRGB(x, y, rgbNew);
                }
            }
        }
    }

    private static int getContrast(int rgbA, int rgbB) {
        return Math.abs(((rgbA >> 16) & 0xFF) - ((rgbB >> 16) & 0xFF))      // Comparing rA and rB values
             + Math.abs(((rgbA >> 8) & 0xFF) - ((rgbB >> 8) & 0xFF))        // Comparing gA and gB values
             + Math.abs((rgbA & 0xFF) - (rgbB & 0xFF));                     // Comparing bA and bB values
    }
}
