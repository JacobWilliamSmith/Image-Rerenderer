package edu.ndsu;

import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static javax.imageio.ImageIO.read;

public class ImageConverter {

    public static BufferedImage urlToImage(String urlPath) throws IOException {
        return read(new URL(urlPath));
    }

    public static BufferedImage fileToImage(String filePath) throws IOException {
        return read(new File(filePath));
    }

    public static Raster imageToRaster(BufferedImage image) {
        return image.getData();
    }
}