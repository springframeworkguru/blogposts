package guru.springframework.blog.logbackgroovy;

import org.junit.Test;

public class LogbackConfigGroovyTest {

    @Test
    public void testPerformTask() throws Exception {
        LogbackConfigGroovy logbackConfigGroovy=new LogbackConfigGroovy();
        logbackConfigGroovy.performTask();
    }
}