package service;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

public class GoogleService {

    public int getNumberFromString (String text) {
        String numberOnly= text.replaceAll("[^0-9]", "");
        return Integer.parseInt(numberOnly);
    }

    public boolean wordKeyIsExist (List<SelenideElement> list, String matcher){
        StringBuilder fullText = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            fullText.append(list.get(i).toString());
        }
        return fullText.toString().contains(matcher);
    }
}
