package learningPath;

import java.util.ArrayList;
import java.util.List;

public class LearningPath {

  private String name;
  private double progress;
  private List<Block> blocks;

  public LearningPath(String name) {
    this.name = name;
    this.progress = 0.0;
    this.blocks = new ArrayList<>();
  }

  public String getname() {
    return this.name;
  }

  public String getProgress() {
    setProgress();
    return this.progress * 100 + "%";
  }

  public void addBlock(Topic topic, String url) {
    this.blocks.add(new Block(topic, url));
  }

  public boolean containTopic(Topic topic) {
    for (Block block : this.blocks) {
      if (block.getTopic().equals(topic)) {
        return true;
      }
    }
    return false;
  }

  private void setProgress() {
    this.progress = (double) getNumberOfCompletedBlocks() / getNumberOfBlocks();
  }

  private int getNumberOfBlocks() {
    return this.blocks.size();
  }

  private int getNumberOfCompletedBlocks() {
    int count = 0;
    for (Block block : blocks) {
      if (block.isCompleted()) {
        count++;
      }
    }
    return count;
  }

}
