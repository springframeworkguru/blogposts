package guru.springframework.blog.jsonannotation.domain.custom;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer extends StdSerializer<Date>{
    private static SimpleDateFormat simpleDateFormat =
            new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
    public CustomDateSerializer(){
        this(null);
    }
    public CustomDateSerializer(Class<Date> t) {
        super(t);
    }

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(simpleDateFormat.format(date));
    }
}
