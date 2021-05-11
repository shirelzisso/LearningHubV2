package user;

import learningPath.LearningPath;
import learningPath.Topic;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

  private String username;
  private String password;
  private List<LearningPath> learningPaths;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.learningPaths = new ArrayList<>();
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public List<LearningPath> getLearningPaths() {
    return this.learningPaths;
  }

  public void addLearningPath(String name) {
    this.learningPaths.add(new LearningPath(name));
  }

  public List<LearningPath> getLearningPathsByTopics(Topic topic) {
    return learningPaths.stream().filter(
        learningPath -> learningPath.containTopic(topic)
    ).collect(Collectors.toList());
  }

  public boolean equals(Object o) {
    if (o instanceof User) {
      User user = (User) o;
      return this.username.equals(user.getUsername());
    }
    return false;
  }
}
