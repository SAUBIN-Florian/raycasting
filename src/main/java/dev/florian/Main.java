package dev.florian;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {

    void run() {
        JFrame window = new JFrame();
        window.setSize(1000,800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}