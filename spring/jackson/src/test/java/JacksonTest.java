import Car.Car;
import Person.Person;
import cn.hutool.core.lang.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Daniel Liu 2020/3/4 7:30
 */


public class JacksonTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final String person = "{\"name\":\"Jin\",\"age\":\"20\"}";
    private final String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
    private final String jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
    private final String jsonString = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\":null}";

    @Test
    public void jackson_api_test() throws JsonProcessingException {
        Person value = objectMapper.readValue(person, Person.class);
        System.out.println("value = " + value);
    }

    @Test
    void jsonNode() throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        String color = jsonNode.get("color").asText();
        System.out.println("color = " + color);
    }

    @Test
    void jsonArrayString_to_javaList() throws JsonProcessingException {
        List<Car> listCar = objectMapper.readValue(jsonCarArray, new TypeReference<List<Car>>() {
        });
    }

    @Test
    void configuring() throws JsonProcessingException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        Car car = objectMapper.readValue(jsonString, Car.class);

        JsonNode jsonNodeRoot = objectMapper.readTree(jsonString);
        JsonNode jsonNodeYear = jsonNodeRoot.get("year");
        String year = jsonNodeYear.asText();
        System.out.println("year = " + year);
    }

    @Test
    void enumTest() {
        JSONArray jsonArray = JSONArray.fromObject(jsonString);
        JSONObject jsonObject = jsonArray.getJSONObject(2);
//        String year = jsonObject.get("year").toString();
        String s = String.valueOf(jsonObject.get("year"));
        System.out.println("year = " + s);

//        objectMapper.readTree(jsonString)
    }

    @Test
    void custom_deserializer() throws JsonProcessingException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Car.class, new CustomCarDeserializer());
        mapper.registerModule(module);
        Car car = mapper.readValue(json, Car.class);
        System.out.println("car = " + car);
    }

    @Test
    void handle_collections() throws JsonProcessingException {
        String jsonCarArray = "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        Car[] cars = objectMapper.readValue(jsonCarArray, Car[].class);
        System.out.println("cars = " + Arrays.toString(cars));
// print cars
    }


    @Test
    public void name() {
//        boolean empty = StringUtils.isEmpty(null);
//        boolean empty = StringUtils.isEmpty(" ");
        boolean empty = StringUtils.isBlank(" ");
//        Assertions.assertTrue(empty);
    }
}