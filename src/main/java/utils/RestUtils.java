package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class RestUtils {


    public static Response performPost(String endpoint, String payload, HashMap<String,String> headers){

        return RestAssured.given().baseUri(endpoint).log().all()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(payload)
                .when().post().then().log().all()
                .extract().response();

    }

    public static Response performPost(String endpoint, HashMap<String,Object> payload, HashMap<String,String> headers){

        return RestAssured.given().baseUri(endpoint).log().all()
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(payload)
                .when().post().then().log().all()
                .extract().response();

    }
}
