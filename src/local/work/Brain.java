package local.work;

import local.work.panels.BrainClient;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Stack;

public class Brain {

    private static FileSystem fileSystem;
    private static String rootDir;
    private static String currentLocation;
    private static JPanel[] panels;
    private static Stack<String> history;
    private static boolean caller;

    public void publish(String string) {
        history.push(currentLocation);
        currentLocation = string;
        for (JPanel panel : panels) {
            if (panel instanceof BrainClient) {
                ((BrainClient) panel).update(string);
                ((BrainClient) panel).setBrain(this);
            }
        }
    }

    public void getBack() {
        if (history.peek() != null) {
            String backElement = history.pop();
            this.publish(backElement);
        }
    }

    public String getRootDir() {
        return rootDir;
    }

    public Brain(JPanel[] panels) {
        this.panels = panels;
        history = new Stack<String>();
        fileSystem = FileSystems.getDefault();
        rootDir = String.valueOf('/'); // Change this logic if extending this application to Windows or Mac.
        currentLocation = null;
        publish(rootDir);
    }
}
