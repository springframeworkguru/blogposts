package guru.springframework.blog.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import guru.springframework.blog.gson.custom.CustomProductDeserializer;
import guru.springframework.blog.gson.custom.CustomProductSerializer;
import guru.springframework.blog.gson.domain.Product;
import java.io.InputStreamReader;
import java.io.Reader;
public class GsonUtil {
    /*Simple serialization of Product object into json without pretty printing*/
    public static String simpleJson(Product product){
        Gson gson = new Gson();
        String json = gson.toJson(product);
        System.out.println(json);
        return json;
    }

    /*GsonBuilder for pretty printing of Json during serializing of Product object*/
    public static String simpleJsonWithPrettyPrinting(Product product){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(product);
        System.out.println(json);
        return json;
    }

    /*Deserializing JSON into Java object*/
    public static Product jsonToObject(String json){
        Gson gson = new Gson();
        Product product = gson.fromJson(json, Product.class);
        System.out.println(product);
        return product;
    }

    /*GsonBuilder for @Expose annotation*/
    public static String simpleJsonWithExposeFields(Product product){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(product);
        System.out.println(json);
        return json;
    }

    /*Custom serialization of product object*/
    public static String simpleJsonWithCustomSerialization(Product product){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Product.class, new CustomProductSerializer()).setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String json = gson.toJson(product);
        System.out.println(json);
        return json;
    }

    /*Custom deserialization of given JSON*/
    public static Product withCustomDeserialization() throws Exception{
        Product product = null;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Product.class, new CustomProductDeserializer());
        Gson gson = gsonBuilder.create();
        try(Reader reader = new InputStreamReader(GsonUtil.class.getResourceAsStream("/json/product.json"))){
            product = gson.fromJson(reader, Product.class);
            System.out.println(product.getProductId());
            System.out.println(product.getDescription());
            System.out.println(product.getImageUrl());
            System.out.println(product.getPrice());
        }
        return product;
    }
}
