package local.work.panels;

import javax.swing.*;
import java.awt.*;

public class PropertiesArea extends JPanel {
    private static JLabel label;

    public PropertiesArea() {
        PropertiesArea.label = new JLabel("Properties Area");

        label.setAlignmentY(0.5f);
    }
}