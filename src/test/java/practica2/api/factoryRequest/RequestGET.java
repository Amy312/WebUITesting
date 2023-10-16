package practica2.api.factoryRequest;

import io.restassured.response.Response;
import practica2.api.config.Configuration;

import static io.restassured.RestAssured.given;

public class RequestGET implements IRequest {
    @Override
    public Response send(RequestInfo requestInfo) {
        Response response=given()
                .header("Token",Configuration.tokenValue)
                .log()
                .all()
                .when()
                .get(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }

    public Response sendSetUp(RequestInfo requestInfo) {
        Response response=given()
                .auth()
                .preemptive()
                .basic(Configuration.user, Configuration.password)
                .log()
                .all().
                when()
                .get(requestInfo.getUrl());
        response.then().log().all();
        return response;
    }
}