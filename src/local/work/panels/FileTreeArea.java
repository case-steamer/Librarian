package local.work.panels;

import local.work.Brain;
import javax.swing.*;
import java.awt.*;

public class FileTreeArea extends JPanel implements BrainClient {
    private static JLabel label;
    private static Brain brain;

    public static JLabel getLabel() {
        return label;
    }

    public static void setLabel(String t) {
        label.setText(t);
    }

    @Override
    public void setBrain(Brain brain) {
        this.brain = brain;
        System.out.println("FileTreeArea recognizes Brain!");
    }

    @Override
    public void update() {}

    @Override
    public void update(String u) {
        setLabel(u);
    }

    public FileTreeArea() {
        this.setBackground(Color.YELLOW);
        FileTreeArea.label = new JLabel("File Tree Area");

        this.add(label);
        label.setAlignmentY(0f);
    }
}