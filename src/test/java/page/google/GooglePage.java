package page.google;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class GooglePage {

    private static final String googleBaseUrl = "https://google.com";
    private static final SelenideElement search = $("[name='q']");

    public GooglePage() {
        open(googleBaseUrl);
    }

    public SearchPage searchQuery (String query){
        search.sendKeys(query);
        search.pressEnter();
        return new SearchPage();
    }




}
