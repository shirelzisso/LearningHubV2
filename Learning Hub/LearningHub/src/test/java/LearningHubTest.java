import learningPath.Topic;
import org.junit.Assert;
import org.junit.Test;

public class LearningHubTest {

  private String TEST_USERNAME = "test";
  private String TEST_PASSWORD = "1234";
  private String TEST_TOPIC = "test topic";

  @Test
  public void testAccountCreation(){
    LearningHub learningHub = new LearningHub();
    Assert.assertNotNull(learningHub.createAccount(TEST_USERNAME,TEST_PASSWORD));
  }

  @Test
  public void testDuplicateAccountCreation(){
    LearningHub learningHub = new LearningHub();
    learningHub.createAccount(TEST_USERNAME,TEST_PASSWORD);
    Assert.assertNull(learningHub.createAccount(TEST_USERNAME,TEST_PASSWORD));
  }

  @Test
  public void testvalidRateTopic(){
    LearningHub learningHub = new LearningHub();
    Topic topic = new Topic(TEST_TOPIC);
    Assert.assertTrue(learningHub.rateTopic(learningHub.createAccount(TEST_USERNAME,TEST_PASSWORD),topic,3));
  }

  @Test
  public void testInvalidRateTopic(){
    LearningHub learningHub = new LearningHub();
    Topic topic = new Topic(TEST_TOPIC);
    Assert.assertFalse(learningHub.rateTopic(learningHub.createAccount(TEST_USERNAME,TEST_PASSWORD),topic,7));
  }

}
