package th.co.framework.qa.api.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseServices {
    public Response callPostService(RequestSpecification requestSpec, String requestBody) {
        Response response = given(requestSpec)
                .body(requestBody)
                .when().post()
                .then().extract().response();
        return response;
    }

    public Response callGetService(RequestSpecification requestSpec) {
        Response response = given(requestSpec)
                .when().get()
                .then().extract().response();
        return response;
    }

    public Response callPatchService(RequestSpecification requestSpec, String requestBody) {
        Response response = given(requestSpec)
                .body(requestBody)
                .when().patch()
                .then().extract().response();
        return response;
    }

    public Response callPatchService(RequestSpecification requestSpec) {
        Response response = given(requestSpec)
                .when().patch()
                .then().extract().response();
        return response;
    }

    public Response callPutService(RequestSpecification requestSpec) {
        Response response = given(requestSpec)
                .when().put()
                .then().extract().response();
        return response;
    }

    public Response callPutService(RequestSpecification requestSpec, String requestBody) {
        Response response = given(requestSpec)
                .body(requestBody)
                .when().put()
                .then().extract().response();
        return response;
    }

    public Response callDeleteService(RequestSpecification requestSpec) {
        Response response = given(requestSpec)
                .when().delete()
                .then().extract().response();
        return response;
    }

}
