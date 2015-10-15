package guru.springframework.blog.currenttime;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentTimeJava8Test {
    @Test
    public void testGetCurrentTime() throws Exception {
        CurrentTimeJava8.getCurrentTime();
    }
    @Test
    public void testGetCurrentTimeWithTimeZone() throws Exception {
        CurrentTimeJava8.getCurrentTimeWithTimeZone();
         }
    @Test
    public void testGetCurrentTimeWithOffset() throws Exception {
        CurrentTimeJava8.getCurrentTimeWithOffset();
    }
}