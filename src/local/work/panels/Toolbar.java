package local.work.panels;

import local.work.Brain;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements BrainClient, ActionListener {
    private static JButton homeBtn;
    private static JButton rootBtn;
    private static JButton backBtn;
    private static ImageIcon homeIcon;
    private static ImageIcon rootIcon;
    private static JTextField addressBar;
    private static Brain brain;
    private static Dimension d;
    private static Dimension iconSize;

    public static String getAddressBar() {
        return addressBar.getText();
    }

    public static void setAddressBar(String t) {
        addressBar.setText(t);
    }

    @Override
    public void setBrain(Brain brain) {
        this.brain = brain;
    }

    @Override
    public void actionPerformed(@NotNull ActionEvent e) {
        if (e.getSource() == homeBtn) {
            brain.publish("~");
        }
        else if (e.getSource() == rootBtn) {
            brain.publish(brain.getRootDir());
        }
    }

    @Override
   public void update() {}

    @Override
    public void update(String u) {
        setAddressBar(u);
    }

    private @NotNull ImageIcon setIconSize(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    public Toolbar() {
        super();
        Toolbar.iconSize = new Dimension(25, 25);

        Toolbar.homeIcon = new ImageIcon(getClass().getResource("../../../resources/home-2504.png"));
        Toolbar.homeIcon = setIconSize(Toolbar.homeIcon);
        Toolbar.homeBtn = new JButton(Toolbar.homeIcon);
        Toolbar.homeBtn.setPreferredSize(Toolbar.iconSize);
        Toolbar.homeBtn.addActionListener(this);

        Toolbar.rootIcon = new ImageIcon(getClass().getResource("../../../resources/admin-9580.png"));
        Toolbar.rootIcon = setIconSize(Toolbar.rootIcon);
        Toolbar.rootBtn = new JButton(Toolbar.rootIcon);
        Toolbar.rootBtn.setPreferredSize(iconSize);
        Toolbar.rootBtn.addActionListener(this);

        Toolbar.d = new Dimension(500, 25);
        Toolbar.addressBar = new JTextField();
        addressBar.setPreferredSize(d);

        this.add(rootBtn);
        this.add(homeBtn);
        this.add(addressBar);
        this.setBackground(Color.RED);
    }
}
