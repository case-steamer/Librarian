package local.work;

import local.work.panels.DisplayArea;
import local.work.panels.FileTreeArea;
import local.work.panels.PropertiesArea;
import local.work.panels.Toolbar;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {

    private static Toolbar toolbar;
    private static DisplayArea displayArea;
    private static FileTreeArea fileTreeArea;
    private static PropertiesArea propertiesArea;

    public Window() {
        GridLayout grid = new GridLayout(4, 4);

        Window.toolbar = new Toolbar();
        Window.displayArea = new DisplayArea();
        Window.fileTreeArea = new FileTreeArea();
        Window.propertiesArea = new PropertiesArea();

        this.add(toolbar, TOP_ALIGNMENT);
        this.add(fileTreeArea, LEFT_ALIGNMENT);
        this.add(displayArea, RIGHT_ALIGNMENT);
        this.add(propertiesArea, BOTTOM_ALIGNMENT);


    }
}