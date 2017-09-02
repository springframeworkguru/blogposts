package guru.springframework.blog.gson.custom;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import guru.springframework.blog.gson.domain.Product;


import java.lang.reflect.Type;
import java.math.RoundingMode;

public class CustomProductSerializer implements JsonSerializer<Product> {
    @Override
    public JsonElement serialize(Product product, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("product-id", product.getProductId());
        jsonObject.addProperty("description", product.getDescription());
        jsonObject.addProperty("image-url", product.getImageUrl());
        jsonObject.addProperty("price", product.getPrice().setScale(2, RoundingMode.HALF_UP));
        return jsonObject;
    }
}
