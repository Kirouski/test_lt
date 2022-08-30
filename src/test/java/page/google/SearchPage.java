package page.google;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import service.GoogleService;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    private static final SelenideElement countOfResults = $x("//*[@id='result-stats']");
    private static final ElementsCollection searchList = $$x("//*[@id='rso']/div/div");
    private static final GoogleService gs = new GoogleService();

    public int getCountOfResults(){
        String res = countOfResults.getOwnText();
        return gs.getNumberFromString(res);
    }

    public List<SelenideElement> getSearchResultList(){
        return searchList;
    }

    public boolean isSitePresent (String matcher){
        return gs.wordKeyIsExist(getSearchResultList(), matcher);
    }
}
