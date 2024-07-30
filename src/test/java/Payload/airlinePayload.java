package Payload;

import airlines.pojos.Airline;
import net.datafaker.Faker;
import utils.DateUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypeNames;

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
        payload.put("id", RandomDataGenerator.getRandomNumber(10));
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME));
        payload.put("country", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY));
        payload.put("logo", RandomDataGenerator.getRandomAlphabets(25));
        payload.put("slogan", RandomDataGenerator.getRandomAlphabets(20));
        payload.put("head_quaters", RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME));
        payload.put("website", RandomDataGenerator.getRandomWebsiteName());
        payload.put("established", RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentyear()));
        return payload;
    }

       public static Airline getCreateAirlinePayloadFromPojo(){
           Airline airline=  Airline.builder().id(RandomDataGenerator.getRandomNumber(10))
                   .name( RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.FIRSTNAME))
                   .country(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.COUNTRY))
                   .head_quaters(RandomDataGenerator.getRandomDataFor(RandomDataTypeNames.CITYNAME))
                   .logo(RandomDataGenerator.getRandomAlphabets(25))
                   .slogan(RandomDataGenerator.getRandomAlphabets(20))
                   .website( RandomDataGenerator.getRandomWebsiteName())
                   .established(RandomDataGenerator.getRandomNumber(1900, DateUtils.getCurrentyear())).build();

            return  airline;

       }

}
