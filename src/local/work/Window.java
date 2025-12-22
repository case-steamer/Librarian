package local.work;

import local.work.panels.DisplayArea;
import local.work.panels.FileTreeArea;
import local.work.panels.PropertiesArea;
import local.work.panels.Toolbar;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

public class Window extends JPanel{

    public JPanel[] getPanels() {
        return panels;
    }

    public void setPanels(JPanel[] panels) {
        this.panels = panels;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public DisplayArea getDisplayArea() {
        return displayArea;
    }

    public void setDisplayArea(DisplayArea displayArea) {
        this.displayArea = displayArea;
    }

    public FileTreeArea getFileTreeArea() {
        return fileTreeArea;
    }

    public void setFileTreeArea(FileTreeArea fileTreeArea) {
        this.fileTreeArea = fileTreeArea;
    }

    public PropertiesArea getPropertiesArea() {
        return propertiesArea;
    }

    public void setPropertiesArea(PropertiesArea propertiesArea) {
        this.propertiesArea = propertiesArea;
    }

    public void propagateRoot(String rootDir){
        for (JPanel panel : panels) {
            if (panel instanceof Toolbar) {
                Toolbar.setAddressBar(rootDir);
            }
            else if (panel instanceof FileTreeArea) {
                FileTreeArea.setLabel(rootDir);
            }
            else if (panel instanceof PropertiesArea) {
                PropertiesArea.setLabel(rootDir);
            }
        }
    }

    private Toolbar toolbar;
    private DisplayArea displayArea;
    private FileTreeArea fileTreeArea;
    private PropertiesArea propertiesArea;
    private JPanel[] panels;
    private Brain brain;

    public Window(@NotNull Brain brain) {
        toolbar = new Toolbar();
        fileTreeArea = new FileTreeArea();
        displayArea = new DisplayArea();
        propertiesArea = new PropertiesArea();
        this.brain = brain;

        this.panels = new JPanel[] {
                toolbar,
                displayArea,
                fileTreeArea,
                propertiesArea
        };

        propagateRoot(brain.getRootDir());

        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
        int[] rh = {125, 125, 125, 125, 125};
        int[] cw = {200, 200, 200, 200};
        GridBagLayout layout = new GridBagLayout();
        layout.rowHeights = rh;
        layout.columnWidths = cw;
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0.5;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        this.add(toolbar, gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        this.add(fileTreeArea, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        this.add(displayArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        this.add(propertiesArea, gbc);

        for (JPanel panel: panels) {
            panel.setBorder(border);
        }
    }
}