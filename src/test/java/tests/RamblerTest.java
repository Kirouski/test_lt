package tests;

import org.testng.annotations.Test;
import page.rambler.LoginPage;

import static org.testng.Assert.assertTrue;

public class RamblerTest {

    private static final String email = "kirouski@rambler.ru";
    private static final String password = "1Qaz2Wsx";

    @Test(description = "Успешная авторизация в почтовый ящик rambler.ru")
    public void loginRambler() {
        assertTrue(
                new LoginPage()
                        .loginAs(email, password)
                        .isLoggedIn(email)
        );
    }
}
