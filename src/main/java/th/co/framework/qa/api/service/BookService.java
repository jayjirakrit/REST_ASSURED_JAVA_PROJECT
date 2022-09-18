package th.co.framework.qa.api.service;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import th.co.framework.qa.api.base.BaseServices;
import th.co.framework.qa.api.endpoint.Framework;

public class BookService extends BaseServices {
    String token;

    public BookService(String token) {
        this.token = token;
    }

    public RequestSpecification prepareGetBooks() {
        RequestSpecification requestSpec = RestAssured.given()
                .basePath(Framework.requestGetBooks());
        return requestSpec;
    }

    public RequestSpecification preparePostBook() {
        RequestSpecification requestSpec = RestAssured.given()
                .header("Authorization", "Bearer " + token)
                .basePath(Framework.requestCreateBook());
        return requestSpec;
    }

    public RequestSpecification prepareGetBook(String id) {
        RequestSpecification requestSpec = RestAssured.given()
                .basePath(Framework.requestGetBook())
                .pathParam("id", id);
        return requestSpec;
    }

    public RequestSpecification prepareUpdateBook(String id) {
        RequestSpecification requestSpec = RestAssured.given()
                .header("Cookie", "token=" + token + "")
                .basePath(Framework.requestUpdateBook())
                .pathParam("id", id);
        return requestSpec;
    }

    public RequestSpecification prepareDeleteBook(String id) {
        RequestSpecification requestSpec = RestAssured.given()
                .header("Cookie", "token=" + token + "")
                .basePath(Framework.requestDeleteBook())
                .pathParam("id", id);
        return requestSpec;
    }

}
