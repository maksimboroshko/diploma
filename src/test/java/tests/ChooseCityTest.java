package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class ChooseCityTest extends TestBase {

    @Test
    @Step("Тест: Поиск страны Тбилиси")
    public void testCheckCountryBanner() {
        selectCountryTbilisi();
    }

    @Step("Тест: Выбираем страну Тбилиси")
    public void selectCountryTbilisi() {
        mainPage.bannerCountry()
                .changeButton()
                .regionSearchInput()
                .tbilisiButton()
                .okayButton()
                .showMoreButtonForTbilisi();
    }
}
