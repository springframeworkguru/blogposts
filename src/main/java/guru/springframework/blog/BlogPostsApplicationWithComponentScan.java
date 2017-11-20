package guru.springframework.blog;
import guru.springframework.blog.componentscan.example.demopackageB.DemoBeanB1;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"guru.springframework.blog.componentscan.example.demopackageA",
        "guru.springframework.blog.componentscan.example.demopackageD",
        "guru.springframework.blog.componentscan.example.demopackageE"},
        basePackageClasses = DemoBeanB1.class)
public class BlogPostsApplicationWithComponentScan {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.
                run(BlogPostsApplicationWithComponentScan.class,args);
        System.out.println("Contains A  "+context.
                containsBeanDefinition("demoBeanA"));
        System.out.println("Contains B2  " + context.
                containsBeanDefinition("demoBeanB2"));
        System.out.println("Contains C   " + context.
                containsBeanDefinition("demoBeanC"));
        System.out.println("Contains D   " + context.
                containsBeanDefinition("demoBeanD"));

    }
}
