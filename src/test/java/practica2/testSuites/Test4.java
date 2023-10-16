package practica2.testSuites;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practica2.api.config.Configuration;
import practica2.api.factoryRequest.FactoryRequest;
import practica2.api.factoryRequest.RequestInfo;

import static org.hamcrest.Matchers.equalTo;

public class Test4 extends TestBase {
    @BeforeEach
    public void setup(){
        requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.token);
        response = FactoryRequest.make(get).sendSetUp(requestInfo);
        Configuration.tokenValue = response.then()
                .extract()
                .path("TokenString");
    }
    @Test
    public void createUpdateDeleteProject(){
        JSONObject body = new JSONObject();
        body.put("Content","My Project");

        this.createProject(Configuration.host + "/api/projects.json", body, post);
        int idProject = response.then().extract().path("Id");
        this.readProject(idProject, get, body);

        body.put("Content","My Project Updated");
        this.updateProject(Configuration.host + "/api/projects/" + idProject + ".json", body, put);
        this.deleteProject(idProject, delete, body);
    }

    private void deleteProject(int idProject, String delete, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void updateProject(String host, JSONObject body, String put) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(put).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void readProject(int idProject, String get, JSONObject body) {
        requestInfo.setUrl(Configuration.host + "/api/projects/" + idProject + ".json");
        response = FactoryRequest.make(get).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void createProject(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

}