package tests;

import controllers.UserController;
import create_user.ErrorHandler;
import create_user.Info;
import create_user.InfoBuilder;
import create_user.response.Response;
import utils.Assertion;
import utils.Helper;
import utils.Properties;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class UserService {
    @BeforeClass
    private void setUp() {
        utils.Properties config = new Properties();
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
        Assertion checker = new Assertion();
        checker.assertEquals(info.getName().toLowerCase(), response.getName().toLowerCase());
        checker.assertEquals(info.getEmail().toLowerCase(), response.getEmail().toLowerCase());
        checker.assertEquals(info.getHobby().toLowerCase(), response.getHobby().toLowerCase());
        checker.assertEquals(info.getPhone(), String.valueOf(response.getPhone()));
    }

    @Test(dataProvider = "User info")
    @Description("Check user exists")
    public void checkUserEmailExists(Info info) {
        UserController userController = new UserController();
        userController.createUser(info);
        ErrorHandler error = userController.createUserWithError(info);
        SoftAssert checker = new SoftAssert();
        checker.assertEquals(error.getMessage(), "Пользователь с таким email уже существует");
    }

    @Test(dataProvider = "User info")
    @Description("Check user name exists")
    public void checkUserNameExists(Info info) {
        Assertion checker = new Assertion();
        Helper helper = new Helper();
        UserController userController = new UserController();
        userController.createUser(info);
        info.setEmail(helper.getRandomMail());
        ErrorHandler error = userController.createUserWithError(info);
        checker.assertEquals(error.getMessage(), String.format("имя %s уже есть в БД", info.getName()));
    }

    @Test(dataProvider = "User info")
    @Description("Check user name exists")
    public void checkInnLength(Info info) {
        Assertion checker = new Assertion();
        Helper helper = new Helper();
        UserController userController = new UserController();
        info.setInn(helper.getRandomNumber(5));
        ErrorHandler error = userController.createUserWithError(info);
        checker.assertEquals(error.getMessage(), String.format(" Значение %s ИНН ФЛ должен содержать 12 цифр", info.getInn()));
    }
}
