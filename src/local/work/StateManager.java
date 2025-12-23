package local.work;

import local.work.panels.*;

import javax.swing.*;

public class StateManager {
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

    JPanel[] panels;
    Brain brain;


    public StateManager(JPanel[] panels, Brain brain) {
        this.panels = panels;
        this.brain = brain;

        propagateRoot(brain.getRootDir());


    }
}
