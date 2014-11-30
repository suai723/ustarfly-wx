import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by sa on 14-11-30.
 */
public class log4jTest {
    private static Logger logger = Logger.getLogger(log4jTest.class);

    @Test
    public void logTest_1() throws IOException {

        System.out.println("this is a log4j test");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
