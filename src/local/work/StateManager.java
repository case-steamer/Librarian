/*
StateManager will act as the interface between the Brain and the Window; at no point should the Brain OR the
WindowManager be responsible for state management. I.e., if the message, address, or metadata that the program is
looking at changes, the Window will only change its display if the StateManager tells it to. Of course,
that means that StateManager needs to be CONSTANTLY updating.
*/

package local.work;

import local.work.panels.*;
import org.jetbrains.annotations.NotNull;

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


    public StateManager(JPanel[] panels, @NotNull Brain brain) {
        this.panels = panels;
        this.brain = brain;

        propagateRoot(brain.getRootDir());


    }
}
