package practica2.api.factoryRequest;

import io.restassured.response.Response;
import practica2.api.config.Configuration;

import static io.restassured.RestAssured.given;

public class RequestPUT implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        Response response=given()
                .header("Token",Configuration.tokenValue)
                .body(requestInfo.getBody())
                .log()
                .all()
                .when()
                .put(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }

    @Override
    public Response sendSetUp(RequestInfo requestInfo) {
        return null;
    }
}