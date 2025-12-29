package local.work;

import local.work.panels.BrainClient;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class Brain {

    private static FileSystem fileSystem;
    private static String rootDir;
    private static JPanel[] panels;

    public void publish(JPanel @NotNull [] panels) {
        for (JPanel panel : panels) {
            if (panel instanceof BrainClient) {
                ((BrainClient) panel).update(getRootDir());
                ((BrainClient) panel).setBrain(this);
            }
        }
    }

    public String getRootDir() {
        return rootDir;
    }

    public Brain(JPanel[] panels) {
        fileSystem = FileSystems.getDefault();
        rootDir = String.valueOf('/'); // Change this logic if extending this application to Windows or Mac.
        publish(panels);
    }
}
