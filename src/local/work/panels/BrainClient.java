package local.work.panels;

import local.work.Brain;

public interface BrainClient {
    void update();
    void update(String u);
    void setBrain(Brain brain);
}
