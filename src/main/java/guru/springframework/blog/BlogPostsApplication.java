package guru.springframework.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BlogPostsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BlogPostsApplication.class,args);
            System.out.println("Contains A  "+context.
                    containsBeanDefinition("demoBeanA"));
            System.out.println("Contains B2  " + context.
                    containsBeanDefinition("demoBeanB2"));
            System.out.println("Contains C   " + context.
                    containsBeanDefinition("demoBeanC"));


    }
}
