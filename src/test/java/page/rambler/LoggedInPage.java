package page.rambler;

import com.codeborne.selenide.SelenideElement;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$x;

public class LoggedInPage {

    private static final SelenideElement loggedInEmail = $x("//span[contains(text(), '@rambler.ru')]");
    private static final SelenideElement profileLink = $x("//a[text()='Мой профиль']");

    public boolean isLoggedIn(String email){
        try {
            return loggedInEmail.getText().equals(email);
        } catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }

}
