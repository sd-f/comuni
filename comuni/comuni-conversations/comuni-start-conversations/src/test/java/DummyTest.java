import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.Assert.assertTrue;

/**
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class DummyTest {

  private final static Logger LOGGER = LoggerFactory.getLogger(DummyTest.class);

  @Test
  public void test() {
    LOGGER.debug("test- and logging framework working...");
    assertTrue("test framework working", true);
  }
}
