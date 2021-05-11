package learningPath;

import java.util.HashMap;
import java.util.Map;
import user.User;

public class Topic implements Rateable {

  private Map<User, Integer> userRatings;
  private String name;
  private double rating;

  public Topic(String name) {
    this.name = name;
    this.rating = 0.0;
    this.userRatings = new HashMap<>();
  }

  @Override
  public boolean rate(User user, int grade) {
    if (!userAlreadyRated(user)) {
      this.userRatings.put(user, grade);
      this.setRating();
      return true;
    }
    System.out.println("All users can rate topic only once");
    return false;
  }

  public boolean equals(Object o) {
    if (o instanceof Topic) {
      Topic topic = (Topic) o;
      return this.name.equals(topic.getName());
    }
    return false;
  }

  public String getName() {
    return this.name;
  }

  public double getRating() {
    return this.rating;
  }

  private void setRating() {
    this.rating = (double) getSumOfRatings() / getNumberOfRatings();
  }

  private int getSumOfRatings() {
    int sum = 0;
    for (Integer grade : this.userRatings.values()) {
      sum = sum + grade;
    }
    return sum;
  }

  private int getNumberOfRatings() {
    return this.userRatings.size();
  }

  private boolean userAlreadyRated(User user) {
    return this.userRatings.keySet().contains(user);
  }
}
