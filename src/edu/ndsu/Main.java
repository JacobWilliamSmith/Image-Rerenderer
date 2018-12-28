package edu.ndsu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        testViewer();
    }

    public static void testViewer() throws IOException {
        ImageViewer.displayImage((ImageConverter.urlToImage("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/View_of_loch_lomond.JPG/1280px-View_of_loch_lomond.JPG")));
    }
}
