import java.util.List;
import learningPath.LearningPath;
import learningPath.Topic;
import loginService.LoginService;
import user.User;

public class LearningHub {


  public LearningHub() {
    LoginService.setNewUsersList();
  }

  public void login(User user) {
    LoginService.login(user);
  }

  public User createAccount(String username, String password) {
    return LoginService.createAccount(username, password);
  }

  public void createLearningPath(User user, String name) {
    user.addLearningPath(name);
  }

  public void addBlockToLearningPath(LearningPath learningPath, Topic topic, String url) {
    learningPath.addBlock(topic, url);
  }

  public List<LearningPath> fetchLearningPaths(User user) {
    return user.getLearningPaths();
  }

  public boolean rateTopic(User user, Topic topic, int grade) {
    if (checkGradeValidation(grade)) {
      return topic.rate(user, grade);
    }
    System.out.println("Grade can be between 1-5");
    return false;
  }

  public List<LearningPath> searchPathsByTopics(User user, Topic topic) {
    return user.getLearningPathsByTopics(topic);
  }

  public String getLearningPathProgress(LearningPath learningPath) {
    return learningPath.getProgress();
  }

  private boolean checkGradeValidation(int grade) {
    return grade >= 1 && grade <= 5;
  }


}
