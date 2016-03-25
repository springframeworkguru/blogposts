package guru.springframework.blog.log4j2async;

import org.junit.Test;
public class Log4J2AsyncLoggerTest {
    @Test
    public void testPerformSomeTask() throws Exception {
        Log4J2AsyncLogger log4J2AsyncLogger=new Log4J2AsyncLogger();
        log4J2AsyncLogger.performSomeTask();
    }
}