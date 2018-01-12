package guru.springframework.blog.marshal;

import guru.springframework.blog.domain.Product;
import guru.springframework.blog.domain.Products;
import guru.springframework.blog.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class ProductToXmlListTest {
    private Product product;
    private Product product1;

    @Before
    public void setUp(){
        long l = 10;
        Long longId = new Long(l);
        User user = new User(longId,"John","john@springframework.guru");
        product = new Product("PO1", "Spring Guru Mug","https://springframework.guru/wp-content/uploads/2017/12/spring_framework_guru_mug-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal(18.95),user);
        product1 = new Product("PO2", "Spring Guru Shirt","https://springframework.guru/wp-content/uploads/2017/12/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", new BigDecimal(20.00),user);
    }

    @After
    public void tearDown(){
        product = null;
    }

    @Test
    public void testObjectToXml() throws JAXBException, FileNotFoundException {
        Products products = new Products();
        products.add(product);
        products.add(product1);

        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(products, new File("products.xml"));
        marshaller.marshal(products, System.out);
    }
}
