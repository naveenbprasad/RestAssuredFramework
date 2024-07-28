package Payload;

import java.util.HashMap;

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
}
