package controllers;

import create_user.ErrorHandler;
import create_user.Info;
import create_user.response.Response;
import utils.AllureLogger;
import utils.Builder;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Step;

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

        String requestBody;
        String responseBody;
        Response response = new Response();
        ObjectMapper mapper = new ObjectMapper();
        try {
            requestBody = mapper.writeValueAsString(info);
            AllureLogger.log("Requeset - " + requestBody);
            responseBody = given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(requestBody)
                    .when()
                    .post(endPoint)
                    .then()
                    .extract()
                    .response()
                    .asString();
            AllureLogger.log("Response - " + responseBody);
            response = mapper.readValue(responseBody, Response.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    @Step("Create user with Error")
    public ErrorHandler createUserWithError(Info info) {
        Builder builder = new Builder();
        String endPoint = builder
                .getTasks()
                .getRest()
                .getCreateUser()
                .build();
        String responseBody;
        String requestBody;
        ErrorHandler response = new ErrorHandler();
        ObjectMapper mapper = new ObjectMapper();
        try {
            requestBody = mapper.writeValueAsString(info);
            AllureLogger.log("Requeset - " + requestBody);
            responseBody = given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(requestBody)
                    .when()
                    .post(endPoint)
                    .then()
                    .extract()
                    .response()
                    .asString();
            AllureLogger.log("Response - " + responseBody);
            response = mapper.readValue(responseBody, ErrorHandler.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
