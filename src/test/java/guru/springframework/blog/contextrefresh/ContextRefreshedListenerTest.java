package guru.springframework.blog.contextrefresh;

import guru.springframework.blog.contextrefresh.config.ContextRefreshConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRefreshConfig.class})
public class ContextRefreshedListenerTest {

    private EventHolderBean eventHolderBean;

    @Autowired
    public void setEventHolderBean(EventHolderBean eventHolderBean) {
        this.eventHolderBean = eventHolderBean;
    }

    @Test
    public void testContext(){
         assertTrue(eventHolderBean.getEventFired());
    }
}
