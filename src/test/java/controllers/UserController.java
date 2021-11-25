package controllers;

import create_user.Info;
import io.qameta.allure.Step;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import utils.AllureLogger;
import utils.Builder;

import static io.restassured.RestAssured.given;

public class UserController {
    @Step("Create user")
    public Response createUser(Info info) {
        Builder builder = new Builder();
        String endPoint = builder
                .getTasks()
                .getRest()
                .getCreateUser()
                .build();
        Response response = given()
                .header("Content-type", "application/json")
                .body(info)
                .when()
                .post(endPoint);
        AllureLogger.log("Request - " + ((RequestSpecificationImpl) given().request().body(info)).getBody().toString());
        AllureLogger.log("Response - " + response.asString());
        return response;
    }
}
