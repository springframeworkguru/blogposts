package guru.springframework.blog.log4j2properties;

import org.junit.Test;

import static org.junit.Assert.*;

public class Log4J2PropertiesConfTest {

    @Test
    public void testPerformSomeTask() throws Exception {
        Log4J2PropertiesConf log4J2PropertiesConf=new Log4J2PropertiesConf();
        log4J2PropertiesConf.performSomeTask();
    }
}