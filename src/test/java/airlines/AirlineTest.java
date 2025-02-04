package airlines;

import airlines.pojos.Airline;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Restutils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Payload.airlinePayload.*;
import static utils.JsonUtils.getJsonDataAsMap;

public class AirlineTest extends AirlineAPIs{


    @Test
    public void createAirline() throws IOException {

//        String env = System.getProperty("env")==null ? "qa" : System.getProperty("env");
//        System.out.println(System.getProperty("env") );
//        Map<String,Object> data = getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
////        String endpoint ="https://api.instantwebtools.net/v1/airlines";
//        String endpoint = (String) data.get("createAirLineEndpoint");
//        String payload ="{\n" +
//                        "    \"_id\":\"252d3bca-d9bb-476c-9a97-562d685e235c\",\n" +
//                        "    \"name\": \"Sri Lankan Airways\",\n" +
//                        "    \"country\": \"Sri Lanka\",\n" +
//                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
//                        "    \"slogan\": \"From Sri Lanka\",\n" +
//                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
//                        "    \"website\": \"www.srilankaaairways.com\",\n" +
//                        "    \"established\": \"1990\"\n" +
//                        "}";
//
//        payload = getAirlinePayload("1234578","Sri Lankan Airways","Sri Lanka","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
//                "From Sri Lanka","Mumbai","www.srilankaaairways.com","1990");
//
////        Response response = RestUtils.performPost(endpoint,payload, new HashMap<>());
////        e
//        HashMap<String, Object> payloadmap = getAirlinePayloadFromMap("1234578","Sri Lankan Airways","Sri Lanka","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
//                "From Sri Lanka","Mumbai","www.srilankaaairways.com","1990");
////
////        Response response1 = RestUtils.performPost(endpoint,payloadmap, new HashMap<>());
////        Assert.assertEquals(response1.statusCode(),200);
//
//        Response response = createAirline(payloadmap);
//        Assert.assertEquals(response.statusCode(),2000);

//        Map<String, Object> payload = getCreateAirlinePayloadFromMap();
//
//        Response response = createAirline(payload);
//        Assert.assertEquals(response.statusCode(),200);

//        // to run from pojo
//        Airline airline = getCreateAirlinePayloadFromPojo();
//
//        Response response = createAirline(airline);
//        Assert.assertEquals(response.statusCode(),200);


        // to run from pojo with default values
        Airline airline = new Airline().toBuilder().name("naveen").build();

        Response response = createAirline(airline);
        Assert.assertEquals(response.statusCode(),200);




    }

    @Test
    public void createAirlineAndVerifyResponse() throws IOException {
        Airline airline = new Airline();
        Response response =createAirline(airline);

//        Way 1
        Assert.assertEquals(response.jsonPath().getString("name"),airline.getName());
        ObjectMapper mapper = new ObjectMapper();
        Airline airlineresponse = mapper.readValue(response.getBody().asString(),Airline.class);

        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(airline));

        Assert.assertEquals(airline,airlineresponse);

    }
}
