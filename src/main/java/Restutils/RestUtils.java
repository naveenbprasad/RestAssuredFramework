package Restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RestUtils {

//    public RequestSpecification getRequestSpecification(String e)


    public static Response performPost(String endpoint, String payload, Map<String,String> headers){

        return RestAssured.given().baseUri(endpoint).log().all()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(payload)
                .when().post().then().log().all()
                .extract().response();

    }

    public static Response performPost(String endpoint, Map<String,Object> payload, Map<String,String> headers){

        return RestAssured.given().baseUri(endpoint).log().all()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(payload)
                .when().post().then().log().all()
                .extract().response();

    }
}
