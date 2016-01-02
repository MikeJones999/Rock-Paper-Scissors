package JunitTests.GameObjs;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestPaperObj.class, TestRockObj.class, TestScissorsObj.class })
public class AllTests {

}
