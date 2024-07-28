package airlines;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;

import static Payload.airlinePayload.getAirlinePayload;
import static Payload.airlinePayload.getAirlinePayloadFromMap;

public class AirlineTest {


    @Test
    public void createAirline(){

        String endpoint ="https://api.instantwebtools.net/v1/airlines";
        String payload ="{\n" +
                        "    \"_id\":\"252d3bca-d9bb-476c-9a97-562d685e235c\",\n" +
                        "    \"name\": \"Sri Lankan Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                        "    \"website\": \"www.srilankaaairways.com\",\n" +
                        "    \"established\": \"1990\"\n" +
                        "}";

        payload = getAirlinePayload("1234578","Sri Lankan Airways","Sri Lanka","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Mumbai","www.srilankaaairways.com","1990");

//        Response response = RestUtils.performPost(endpoint,payload, new HashMap<>());
//        Assert.assertEquals(response.statusCode(),200);

        HashMap<String, Object> payloadmap = getAirlinePayloadFromMap("1234578","Sri Lankan Airways","Sri Lanka","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka","Mumbai","www.srilankaaairways.com","1990");

        Response response1 = RestUtils.performPost(endpoint,payloadmap, new HashMap<>());
        Assert.assertEquals(response1.statusCode(),200);

    }
}
