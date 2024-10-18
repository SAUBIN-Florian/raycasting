package dev.florian;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import dev.florian.game.CanvasPanel;

public class Main {
    final int GAME_WIDTH = 800;
    final int GAME_HEIGHT = 800;

    private void run() {
        JFrame window = new JFrame("Raycasting Game");
        window.setSize(GAME_WIDTH, GAME_HEIGHT);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        JPanel panel = new CanvasPanel();
        window.add(panel);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
