package org.springframework.boot.jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;

/**
 * Created by ktamilvanan on 7/30/17.
 */
public class MyCustomDataConverter implements AttributeConverter<MyCustomData,String> {
    @Override
    public String convertToDatabaseColumn(MyCustomData attribute) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(attribute);
        }catch (JsonProcessingException ex) {

        }
        return null;
    }

    @Override
    public MyCustomData convertToEntityAttribute(String dbData) {
        ObjectMapper mapper = new ObjectMapper();
        if (dbData == null)
            return new MyCustomData();
        TypeReference<MyCustomData> typeRef
                = new TypeReference<MyCustomData>() {};
        try {
            return mapper.readValue(dbData, typeRef);
        } catch (IOException ex) {

        }
        return null;
    }
}
