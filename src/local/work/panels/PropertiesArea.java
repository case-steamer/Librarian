package local.work.panels;

import local.work.Brain;

import javax.swing.*;
import java.awt.*;

public class PropertiesArea extends JPanel implements BrainClient{
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
        System.out.println("PropertiesArea recognizes Brain!");
    }

    @Override
    public void update() {}

    @Override
    public void update(String u) {
        setLabel(u);
    }

    public PropertiesArea() {
        super();
        PropertiesArea.label = new JLabel("Properties Area");

        label.setAlignmentY(0.5f);
        this.add(label);
        this.setBackground(Color.BLUE);
    }
}