package guru.springframework.blog.contextrefresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ContextRefresehedApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(ContextRefresehedApplication.class, args);
        EventHolderBean bean = ctx.getBean(EventHolderBean.class);
        System.out.println("Event Processed?? - " + bean.getEventFired());
    }
}
