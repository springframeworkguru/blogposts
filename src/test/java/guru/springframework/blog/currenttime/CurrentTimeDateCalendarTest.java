package guru.springframework.blog.currenttime;

import org.junit.Test;

import static org.junit.Assert.*;


public class CurrentTimeDateCalendarTest {

    @Test
    public void testGetCurrentTimeUsingDate() throws Exception {
        CurrentTimeDateCalendar.getCurrentTimeUsingDate();

    }

    @Test
    public void testGetCurrentTimeUsingCalendar() throws Exception {
        CurrentTimeDateCalendar.getCurrentTimeUsingCalendar();
    }
}