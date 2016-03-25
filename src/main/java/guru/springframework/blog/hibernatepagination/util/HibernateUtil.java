package guru.springframework.blog.hibernatepagination.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static{
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
         serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
         sessionFactory = configuration
                .buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
