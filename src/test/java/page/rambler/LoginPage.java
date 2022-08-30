package page.rambler;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private static final SelenideElement loginBtn = $x("//*[text()='Вход']");
    private static final SelenideElement loginIFrame = $x("//div[@data-id-frame]/iframe");
    private static final SelenideElement loginInput = $("[type='email']");
    private static final SelenideElement passwordInput = $("[type='password']");
    private static final SelenideElement processLogin = $x("//*[text()='Войти']");
    private static final String ramblerBaseUrl = "https://www.rambler.ru/";

    public LoginPage() {
        open(ramblerBaseUrl);
        openLoginPage();
        switchTo().frame(loginIFrame);
    }

    public static void openLoginPage(){
       loginBtn.click();
    }

    public LoginPage typeLogin(String email){
        loginInput.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }

    public LoggedInPage clickLogin(){
        processLogin.click();
        return new LoggedInPage();
    }

    public LoggedInPage loginAs(String email, String password){
        typeLogin(email);
        typePassword(password);
        return clickLogin();
    }


}
