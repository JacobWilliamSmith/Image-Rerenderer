package edu.ndsu;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    //TODO: Implement GUI that allows user to specify image url/file and number of iterations

    private static final String DEFAULT_IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/View_of_loch_lomond.JPG/1280px-View_of_loch_lomond.JPG";
    private static final int DEFAULT_ITERATIONS = 100000;

    public static void main(String[] args) throws IOException {
        BufferedImage orig = ImageConverter.urlToImage(DEFAULT_IMAGE_URL);
        BufferedImage gen = ImageGenerator.generateImage(orig, DEFAULT_ITERATIONS);
        ImageViewer.displayImage(orig);
        ImageViewer.displayImage(gen);
    }
}
