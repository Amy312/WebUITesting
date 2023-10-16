package practica2.api.factoryRequest;

import io.restassured.response.Response;

public interface IRequest {
    Response send (RequestInfo requestInfo);
    Response sendSetUp  (RequestInfo requestInfo);
}
