package local.work;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static void instLibrarian() {
        Brain brain = new Brain();
        Dimension d = new Dimension(800, 500);
        JFrame frame = new JFrame();
        Window window = new Window();
        StateManager stateManager = new StateManager(window.getPanels(), brain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(window);
        frame.pack();
        frame.setMinimumSize(d);
        frame.setVisible(true);
        System.out.println(brain.getRootDir());
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                instLibrarian();
            }
        });
    }
}
