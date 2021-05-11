package loginService;

import java.util.ArrayList;
import java.util.List;
import user.User;

public class LoginService {

  private static List<User> users;
  

  public static void setNewUsersList(){
    users = new ArrayList<>();
  }

  public static void login(User user) {
    System.out.println(user.getUsername() + " is logged in");
  }

  public static User createAccount(String username, String password) {
    if (!checkForExistingAccount(username)) {
      User user = new User(username, password);
      users.add(user);
      return user;
    }
    return null;
  }

  private static boolean checkForExistingAccount(String username) {
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        return true;
      }
    }
    return false;
  }

}
