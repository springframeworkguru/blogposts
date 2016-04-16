package guru.springframework.blog.logbackgroovy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackConfigGroovy {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    public void performTask(){
        logger.info("This is an info message.");
        logger.warn("This is a warn message.");
        logger.error("This is an error message.");
        logger.debug("This is a debug message.");
    }
}
