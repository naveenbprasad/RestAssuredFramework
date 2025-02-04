package Restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.HashMap;
import java.util.Map;

public class RestUtils {

    public static RequestSpecification getRequestSpecification(String endpoint, Object payload, Map<String,String> headers){
        return RestAssured.given().baseUri(endpoint)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(payload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification= SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Headers are ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body is ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers are ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }


    public static Response performPost(String endpoint, String payload, Map<String,String> headers){

        RequestSpecification requestSpecification=  getRequestSpecification(endpoint,payload,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;

    }

    public static Response performPost(String endpoint, Map<String,Object> payload, Map<String,String> headers){
        RequestSpecification requestSpecification=  getRequestSpecification(endpoint,payload,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }

    public static Response performPost(String endpoint, Object payloadaspojo, Map<String,String> headers){
        RequestSpecification requestSpecification=  getRequestSpecification(endpoint,payloadaspojo,headers);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}
