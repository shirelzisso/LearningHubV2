package learningPath;

import user.User;

public interface Rateable {

  public boolean rate(User user, int grade);
  public double getRating();
}
