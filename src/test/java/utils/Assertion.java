package utils;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

public class Assertion {
    @Step("Assert that {actual} equals {expected}")
    public void assertEquals(final String actual, final String expected) {
        SoftAssert checker = new SoftAssert();
        checker.assertEquals(actual, expected);
    }

    @Step("Assert that {actual} equals {expected}")
    public void assertEquals(final int actual, final int expected) {
        SoftAssert checker = new SoftAssert();
        checker.assertEquals(actual, expected);
    }
}
