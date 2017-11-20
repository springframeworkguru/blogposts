package guru.springframework.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "guru.springframework.blog.componentscan.example.demopackageA",
        useDefaultFilters = false)
public class BlogPostsApplicationDisablingDefaultFilters {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(BlogPostsApplicationDisablingDefaultFilters.class,args);
            System.out.println("Contains A  " + context.containsBean("demoBeanA"));
    }
}
