package learningPath;

public class Block {

  private Topic topic;
  private String url;
  private boolean completed;

  public Block(Topic topic, String url) {
    this.topic = topic;
    this.url = url;
    this.completed = false;
  }

  public Topic getTopic() {
    return this.topic;
  }

  public boolean isCompleted(){
    return this.completed;
  }

}
