package guru.springframework.blog.log4joverview;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyAppTest {
    @Test
    public void testPerformSomeTask() throws Exception {
      MyApp app=new MyApp();
      app.performSomeTask();

    }
}