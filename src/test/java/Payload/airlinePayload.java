package Payload;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;

public class airlinePayload {


    public static String getAirlinePayload(String id, String name, String country,
                                           String logo, String slogan, String head_quaters,
                                           String website, String established){

        String payload = "{\n" +
                "        \"id\": "+id+",\n" +
                "        \"name\": \""+name+"\",\n" +
                "        \"country\": \""+country+"\",\n" +
                "        \"logo\": \""+logo+"\",\n" +
                "        \"slogan\": \""+slogan+"\",\n" +
                "        \"head_quaters\": \""+head_quaters+"\",\n" +
                "        \"website\": \""+website+"\",\n" +
                "        \"established\": \""+established+"\"\n" +
                "}";
        return payload;
    }

    public static HashMap<String , Object> getAirlinePayloadFromMap(String id, String name, String country,
                                                                        String logo, String slogan, String head_quaters,
                                                                        String website, String established){
        HashMap<String, Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("country",country);
        map.put("logo",logo);
        map.put("slogan",slogan);
        map.put("head_quaters",head_quaters);
        map.put("website",website);
        map.put("established",established);

        return  map;





    }

    public static Map<String, Object> getCreateAirlinePayloadFromMap() {
        Faker faker = new Faker();
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", faker.number().digits(10));
        payload.put("name", faker.name().firstName());
        payload.put("country", faker.address().country());
        payload.put("logo", RandomStringUtils.randomAlphanumeric(20));
        payload.put("slogan",RandomStringUtils.randomAlphanumeric(20));
        payload.put("head_quaters",faker.address().cityName());
        payload.put("website", "https://"+RandomStringUtils.randomAlphanumeric(10)+".com");
        payload.put("established", faker.number().numberBetween(1980,2023));
        return payload;
    }
}
