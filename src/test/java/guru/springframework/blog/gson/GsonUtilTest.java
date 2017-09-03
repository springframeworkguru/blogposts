package guru.springframework.blog.gson;

import guru.springframework.blog.gson.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigDecimal;

public class GsonUtilTest {
    private Product product;

    @Before
    public void setUp(){
        product = new Product("P01","Spring Guru Mug","https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg",new BigDecimal(18.95));
    }

    @After
    public void tearDown(){
     product=null;
    }
    @Test
    public void simpleJson() throws Exception {
        String result = GsonUtil.simpleJson(product);
        assertEquals(4, result.replace("{", "").replace("}","").split(",").length);
        assertEquals("\"productId\":\"P01\"".trim(), result.replace("{", "").replace("}","").split(",")[0].trim());
        assertEquals("\"description\":\"Spring Guru Mug\"".trim(), result.replace("{", "").replace("}","").split(",")[1].trim());
        assertEquals("\"imageUrl\":\"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\"".trim(), result.replace("{", "").replace("}","").split(",")[2].trim());
        assertEquals("\"price\":"+ new BigDecimal(18.95)+"".trim(), result.replace("{", "").replace("}","").split(",")[3].trim());

    }

    @Test
    public void simpleJsonWithPrettyPrinting() throws Exception {
        String result = GsonUtil.simpleJsonWithPrettyPrinting(product);
    }

     @Test
       public void jsonToObject() throws Exception {
       /*ToDo: Condtruct JSON in a Java String and test jsonToObject - refer objectWithCustomDeserialization
      for asserts on Product*/


    }

    @Test
    public void simpleJsonWithExposeFields() throws Exception {
        String result = GsonUtil.simpleJsonWithExposeFields(product);
        assertEquals(1, result.replace("{", "").replace("}","").split(",").length);
        assertEquals("\"price\": "+ new BigDecimal(18.95)+"".trim(), result.replace("{", "").replace("}","").split(",")[0].trim());
    }
    @Test
    public void simpleJsonWithCustomSerialization() throws Exception {
        String result = GsonUtil.simpleJsonWithCustomSerialization(product);
        assertEquals(4, result.replace("{", "").replace("}","").split(",").length);
        assertEquals("\"product-id\": \"P01\"", result.replace("{", "").replace("}","").split(",")[0].trim());
        assertEquals("\"description\": \"Spring Guru Mug\"".trim(), result.replace("{", "").replace("}","").split(",")[1].trim());
        assertEquals("\"image-url\": \"https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg\"".trim(), result.replace("{", "").replace("}","").split(",")[2].trim());
        assertEquals("\"price\": 18.95".trim(), result.replace("{", "").replace("}","").split(",")[3].trim());

    }

    @Test
    public void objectWithCustomDeserialization() throws Exception {
        Product product = GsonUtil.withCustomDeserialization();
        assertNotNull(product);
        assertEquals("235268845711068312", product.getProductId());
        assertEquals("Spring Framework Guru Mug", product.getDescription());
        assertEquals("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_towel-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg", product.getImageUrl());
        assertEquals(new BigDecimal(14), product.getPrice());
    }

}