package tests;

import controllers.UserController;
import create_user.Info;
import create_user.InfoBuilder;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Helper;
import utils.Properties;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    @BeforeClass
    private void setUp() {
        Properties config = new Properties();
        RestAssured.baseURI = config.getProperty("baseUrl");
    }

    @DataProvider(name = "User info")
    public Object[][] createInfo() {
        Helper helper = new Helper();
        List<Long> tasks = new ArrayList<>();
        tasks.add(12L);
        List<Long> companies = new ArrayList<>();
        companies.add(36L);
        companies.add(37L);
        return new Object[][]{
                {
                        new InfoBuilder()
                                .withEmail(helper.getRandomMail())
                                .withName(helper.getRandomString())
                                .withTasks(tasks)
                                .withCompanies(companies)
                                .withHobby(helper.getRandomString())
                                .withAdres(helper.getRandomString())
                                .withName1(helper.getRandomString())
                                .withSurname1(helper.getRandomString())
                                .withFathername1(helper.getRandomString())
                                .withCat(helper.getRandomString())
                                .withDog(helper.getRandomString())
                                .withParrot(helper.getRandomString())
                                .withCavy(helper.getRandomString())
                                .withHamster(helper.getRandomString())
                                .withSquirrel(helper.getRandomString())
                                .withPhone(helper.getRandomNumber(7))
                                .withInn(helper.getRandomNumber(12))
                                .withGender("m")
                                .withBirthday(helper.getRandomDate().toString())
                                .withDateStart(helper.getRandomDate().toString())
                                .build()
                }
        };
    }

    @Test(dataProvider = "User info")
    @Description("Check user creation")
    public void checkCreateUser(Info info) {
        UserController userController = new UserController();
        Response response = userController.createUser(info);
        Assert.assertEquals(info.getName().toLowerCase(), response.jsonPath().getString("name").toLowerCase());
        Assert.assertEquals(info.getEmail().toLowerCase(), response.jsonPath().getString("email").toLowerCase());
        Assert.assertEquals(info.getHobby().toLowerCase(), response.jsonPath().getString("hobby").toLowerCase());
        Assert.assertEquals(info.getPhone(), response.jsonPath().getString("phone"));
    }

    @Test(dataProvider = "User info")
    @Description("Check user exists")
    public void checkUserEmailExists(Info info) {
        UserController userController = new UserController();
        userController.createUser(info);
        Response error = userController.createUser(info);
        Assert.assertEquals(error.jsonPath().getString("message"), "Пользователь с таким email уже существует ");
    }

    @Test(dataProvider = "User info")
    @Description("Check user name exists")
    public void checkUserNameExists(Info info) {
        Helper helper = new Helper();
        UserController userController = new UserController();
        userController.createUser(info);
        info.setEmail(helper.getRandomMail());
        Response error = userController.createUser(info);
        Assert.assertEquals(error.jsonPath().getString("message"), String.format(" имя %s уже есть в БД", info.getName()));
    }

    @Test(dataProvider = "User info")
    @Description("Check user name exists")
    public void checkInnLength(Info info) {
        Helper helper = new Helper();
        UserController userController = new UserController();
        info.setInn(helper.getRandomNumber(5));
        Response error = userController.createUser(info);
        Assert.assertEquals(error.jsonPath().getString("message"), String.format(" Значение %s ИНН ФЛ должен содержать 12 цифр", info.getInn()));
    }
}
