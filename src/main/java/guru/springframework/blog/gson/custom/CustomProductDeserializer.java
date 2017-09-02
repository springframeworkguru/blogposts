package guru.springframework.blog.gson.custom;

import com.google.gson.*;
import guru.springframework.blog.gson.domain.Product;


import java.lang.reflect.Type;
import java.math.BigDecimal;

public class CustomProductDeserializer implements JsonDeserializer<Product>{
    private String productId, description, imageUrl;
    private BigDecimal price;
    @Override
    public Product deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

       if(jsonObject.has("product-id")) {
           productId = jsonObject.get("product-id").getAsString();
       }
        if(jsonObject.has("description")) {
            description = jsonObject.get("description").getAsString();
        }
        if(jsonObject.has("image-url")) {
            imageUrl = jsonObject.get("image-url").getAsString();
        }
        if(jsonObject.has("price")) {
            price = jsonObject.get("price").getAsBigDecimal();
        }
        Product product = new Product(productId, description,imageUrl,price);
        return product;
    }
}
