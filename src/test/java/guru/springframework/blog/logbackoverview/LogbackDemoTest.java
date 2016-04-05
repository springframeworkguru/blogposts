package guru.springframework.blog.logbackoverview;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogbackDemoTest {

    @Test
    public void testPerformTask() throws Exception {
        LogbackDemo logBackDemo = new LogbackDemo();
        logBackDemo.performTask();
    }
}