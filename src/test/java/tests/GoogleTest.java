package tests;

import org.testng.annotations.Test;
import page.google.GooglePage;
import page.google.SearchPage;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleTest {

    @Test(description = "Проверка google-поиска на предмет наличия сайта-матчера в поисковой выдаче и количества полученных результатов поиска")
    public void searchGoogleTest() {
       String searchQuery = "купить кофемашину bork c804";
       String matcher = "mvideo.ru";
       int checkedNumber = 10;

       SearchPage searchPage = new GooglePage().searchQuery(searchQuery);
       assertTrue(searchPage.isSitePresent(matcher));
       assertTrue(searchPage.getCountOfResults() > checkedNumber); // проверка на общее количество результатов
       assertTrue(searchPage.getSearchResultList().size() > checkedNumber); // проверка на количество результатов на одной странице
    }
}
