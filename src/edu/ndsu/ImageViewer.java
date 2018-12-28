package edu.ndsu;

import javax.swing.*;
import java.awt.*;

public class ImageViewer {

    //TODO: Implement image scaling based on system specs such that both images fit on user screen
    //TODO: Make one jFrame pop up on the left half of the screen and the other pop up on the right half

    public static void displayImage(Image image) {
        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(image)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}