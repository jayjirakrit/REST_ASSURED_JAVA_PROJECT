package th.co.framework.qa.api.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import th.co.framework.qa.api.base.BaseServices;
import th.co.framework.qa.api.endpoint.Framework;

import static io.restassured.RestAssured.given;

public class AuthService extends BaseServices {


    public RequestSpecification preparePostToken() {
        RequestSpecification requestSpec = RestAssured.given()
                .basePath(Framework.requestCreateToken());
        return requestSpec;
    }

}
